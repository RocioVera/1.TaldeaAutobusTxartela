package kontrolatzailea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.sql.*;
import java.sql.Date;

import com.toedter.calendar.JDateChooser;

import eredua.*;
import ikuspegia.*;

public class Metodoak {
	/**
	 * Hartutako linea jakinda geltokiak bueltatu
	 * 
	 * @param arrayGeltokiak
	 * @author talde1
	 * @return arrayGeltokiak
	 */

	public static ArrayList<Integer> geltokiakHartu(String linea) {
		ArrayList<GeltokiaLinea> arrayGelLinea = Kontsultak.arrayGelLinea();
		ArrayList<Integer> arrayGeltokiak = new ArrayList<>();
		for (GeltokiaLinea obj : arrayGelLinea) {
			while (linea == obj.getKodLinea()) {
				arrayGeltokiak.add(obj.getKodGeltokia());
			}
		}
		return arrayGeltokiak;

	}

	/**
	 * Bi geltokien harteko distantzia kalkulatu
	 * 
	 * @param altuera1
	 * @param luzera1
	 * @param altuera2
	 * @param luzera2
	 * @return distantzia
	 * @author talde1
	 */
	public static double kalkulatuDistantzia(double altuera1, double luzera1, double altuera2, double luzera2) {
		double lurrarenErradioa = 6371;
		double dLat = Math.toRadians(altuera2 - altuera1);
		double dLng = Math.toRadians(luzera2 - luzera1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(altuera1)) * Math.cos(Math.toRadians(altuera2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		double distantzia = lurrarenErradioa * va2;
		return distantzia;
	}

	/**
	 * Bi geltokien harteko distantzia kalkulatu
	 * 
	 * @param kontsumoa
	 * @param eserKop
	 * @return totPertsonaBilletea
	 * @author talde1
	 */
	public static float kalkPrezioa(float kontsumoa, int eserKop, double altuera1, double luzera1, double altuera2,
			double luzera2) {
		float zenbatIrabazi, totBidaia, totPertsonaBilletea;
		final double onurak = 0.20, erregaia = 0.80;

		double distantzia = kalkulatuDistantzia(altuera1, luzera1, altuera2, luzera2);
		zenbatIrabazi = (float) (erregaia * kontsumoa * distantzia);
		totBidaia = (float) (zenbatIrabazi * onurak + zenbatIrabazi);
		totPertsonaBilletea = totBidaia / eserKop;
		totPertsonaBilletea = (float) (Math.round(totPertsonaBilletea * 100.0) / 100.0);
		return totPertsonaBilletea;
	}

	/**
	 * Sartutako pasahitza zifratu
	 * 
	 * @param pasahitza
	 * @return hashtext
	 * @author talde1
	 */
	public static String zifratuPasahitza(String pasahitza) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(pasahitza.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Sartutako pasahitza (zifratuta) ea datu basean dagoen ala ez
	 * 
	 * @param pasahitza
	 * @return bal
	 * @author talde1
	 */
	public static boolean frogatuPasahitza(String pasahitza) {
		boolean bal = false;
		String pasaEnkr = "";
		pasaEnkr = zifratuPasahitza(pasahitza);
		ArrayList<Bezeroak> bezeroak = new ArrayList<>();
		bezeroak = Kontsultak.bezeroDatuak();
		for (Bezeroak bezeroak2 : bezeroak) {
			if (pasaEnkr.equals(bezeroak2.getPasahitza()))
				bal = true;
		}
		return bal;
	}

	/**
	 * Sartutako nan-a ea datu baaean dagoen ala ez
	 * 
	 * @param nan
	 * @return bal
	 * @author talde1
	 */
	public static boolean frogatuNAN(String nan) {
		boolean bal = false;
		ArrayList<Bezeroak> bezeroak = new ArrayList<>();
		bezeroak = Kontsultak.bezeroDatuak();
		for (Bezeroak bezeroak2 : bezeroak) {
			if (nan.equals(bezeroak2.getNAN()))
				bal = true;
		}
		return bal;
	}

	/**
	 * Bezeroen erregistroa egin datu basean eta hutzik baldin badago sartu behar
	 * den daturen bat balidazioa bueltatu
	 * 
	 * @param pasahitza
	 * @param NAN
	 * @param izena
	 * @param abizenak
	 * @param sexua
	 * @param jaioData
	 * @return bal
	 * @author talde1
	 */
	public static boolean erregistratuBezeroak(String pasahitza, String NAN, String izena, String abizenak,
			String sexua, java.util.Date jaioData) {
		boolean bal = true;
		String pasaEnkr = "";
		pasaEnkr = zifratuPasahitza(pasahitza);
		ArrayList<Bezeroak> bezeroak = new ArrayList<>();
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		bezeroak = Kontsultak.erregistratuBezeroak(pasaEnkr, NAN, izena, abizenak, sexua, jaioData);
		// enviar al fitxero
		if (pasahitza.length() == 0 || NAN.isEmpty() || izena.isEmpty() || abizenak.isEmpty() || sexua.isEmpty()
				|| jaioData == null)
			bal = false;
		return bal;
	}

	/**
	 * Billetea sortu
	 * 
	 * @param txartela
	 * @author talde1
	 */
	public static void sortuBilletea(Txartelak txartela) {
		Kontsultak.billeteaKontsulta(txartela);
	}

	/**
	 * Leiho1 sortu
	 * 
	 * @author talde1
	 */
	public static void lehenengoLeihoa() {
		Leiho1 Leiho1 = new Leiho1();
		Leiho1.setVisible(true);

	}

	/**
	 * Leiho2 sortu
	 * 
	 * @author talde1
	 */
	public static void bigarrenLeihoa() {
		ArrayList<Lineak> lineak = new ArrayList<Lineak>();
		lineak = Kontsultak.lineakDatuak();
		ArrayList<Autobusak> autobusak = new ArrayList<>();
		autobusak = Kontsultak.autobusDatuak();
		Leiho2 Leiho2 = new Leiho2(lineak, autobusak);
		Leiho2.setVisible(true);
	}

	/**
	 * Leiho3 sortu
	 * 
	 * @author talde1
	 */
	public static void hirugarrenLeihoa(String hartutakoLinea, Autobusak autobusa) {
		Leiho3 Leiho3 = new Leiho3(hartutakoLinea, autobusa);
		Leiho3.setVisible(true);

	}

	/**
	 * Leiho4 sortu
	 * 
	 * @author talde1
	 * @param luzera2
	 * @param altuera2
	 * @param luzera1
	 * @param altuera1
	 * @param arrayGeltokia 
	 */
	public static void laugarrenLeihoa(String hartutakoLinea, Autobusak autobusa, int ibilbideZbk,
			int hasierakoGeltokiaKod, int amaierakoGeltokiaKod, double altuera1, double luzera1, double altuera2,
			double luzera2, ArrayList<Geltokiak> arrayGeltokia) {
		Leiho4 Leiho4 = new Leiho4(hartutakoLinea, autobusa, ibilbideZbk, hasierakoGeltokiaKod, amaierakoGeltokiaKod,
				altuera1, luzera1, altuera2, luzera2, arrayGeltokia);
		Leiho4.setVisible(true);

	}

	/**
	 * Leiho5 sortu
	 * 
	 * @author talde1
	 * @param luzera2
	 * @param altuera2
	 * @param luzera1
	 * @param altuera1
	 * @param arrayGeltokia 
	 */
	public static void bostgarrenLeihoa(String hartutakoLinea, Autobusak autobusa, int ibilbideZbk,
			int hasierakoGeltokiaKod, int amaierakoGeltokiaKod, float guztiraPrez, String nan, double altuera1,
			double luzera1, double altuera2, double luzera2, ArrayList<Geltokiak> arrayGeltokia) {
		Leiho5 Leiho5 = new Leiho5(hartutakoLinea, autobusa, ibilbideZbk, hasierakoGeltokiaKod, amaierakoGeltokiaKod,
				guztiraPrez, nan, altuera1, luzera1, altuera2, luzera2, arrayGeltokia);
		Leiho5.setVisible(true);

	}

	/**
	 * Leiho6 sortu
	 * 
	 * @author talde1
	 * @param txartela
	 * @param arrayGeltokia 
	 */
	public static void seigarrenLeihoa(String hartutakoLinea, Autobusak autobusa, int ibilbideZbk,
			int hasierakoGeltokiaKod, int amaierakoGeltokiaKod, Txartelak txartela) {
		Leiho6 Leiho6 = new Leiho6(hartutakoLinea, autobusa, ibilbideZbk, hasierakoGeltokiaKod, amaierakoGeltokiaKod,
				txartela);
		Leiho6.setVisible(true);

	}

	/**
	 * Amaieran tiketa imprimatzen dagoen bitartean itxaron behar den denbora
	 * 
	 * @author talde1
	 */
	public static void Leiho_segunduak() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		lehenengoLeihoa();
	}

	/**
	 * Zenbat diru sartzen duen jakiteko egiteko
	 * 
	 * @param kont
	 * @param sartutakoa
	 * @return sartutakoa
	 * @author talde1
	 */
	public static double diruaSartu(int kont, double sartutakoa) {
		switch (kont) {
		case 1:
			sartutakoa += 200;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 2:
			sartutakoa += 100;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 3:
			sartutakoa += 50;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 4:
			sartutakoa += 20;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 5:
			sartutakoa += 10;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 6:
			sartutakoa += 5;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 7:
			sartutakoa += 2;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 8:
			sartutakoa += 1;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 9:
			sartutakoa += 0.5;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 10:
			sartutakoa += 0.2;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 11:
			sartutakoa += 0.1;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 12:
			sartutakoa += 0.05;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 13:
			sartutakoa += 0.02;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 14:
			sartutakoa += 0.01;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;

		default:
			sartutakoa = 0;
			break;
		}
		return sartutakoa;
	}

	/**
	 * Jakiteko zenbat diru sartu duen gero bueltak emateko ala ez
	 * 
	 * @param diruFalta
	 * @param guztiraPrez
	 * @param sartutakoa
	 * @author talde1
	 * @return diruFalta
	 */
	public static double diruFaltaBueltakMetodoa(double diruFalta, double guztiraPrez, double sartutakoa) {
		diruFalta = guztiraPrez - sartutakoa;
		diruFalta = Math.round(diruFalta * 100.0) / 100.0;
		return diruFalta;
	}

	/**
	 * Arrayan sartzeko zenbat kantitate txanpon bakoitza eta bueltatu txanpona /
	 * billete
	 * 
	 * @param diruFalta
	 * @author talde1
	 * @return bueltakString
	 */
	public static String bueltakZerrenda(double diruFalta) {
		String bueltakString = "";
		double bueltak = 0;

		if (diruFalta < 0) {
			bueltak = -diruFalta;
			for (double i = bueltak; i > 0; i = bueltak) {
				if (bueltak >= 200) {
					bueltak = bueltak - 200;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "200€-ko bilete \n";

				} else if (bueltak >= 100) {
					bueltak = bueltak - 100;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "100€-ko bilete \n";

				} else if (bueltak >= 50) {
					bueltak = bueltak - 50;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "50€-ko bilete \n";

				} else if (bueltak >= 20) {
					bueltak = bueltak - 20;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "20€-ko bilete \n";

				} else if (bueltak >= 10) {
					bueltak = bueltak - 10;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "10€-ko bilete \n";

				} else if (bueltak >= 5) {
					bueltak = bueltak - 5;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "5€-ko bilete \n";

				} else if (bueltak >= 2) {
					bueltak = bueltak - 2;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "2€-ko moneta \n";

				} else if (bueltak >= 1) {
					bueltak = bueltak - 1;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "1€-ko moneta \n";

				} else if (bueltak >= 0.5) {
					bueltak = bueltak - 0.5;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "0.5€-ko moneta \n";

				} else if (bueltak >= 0.2) {
					bueltak = bueltak - 0.2;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "0.2€-ko moneta \n";

				} else if (bueltak >= 0.1) {
					bueltak = bueltak - 0.1;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "0.1€-ko moneta \n ";

				} else if (bueltak >= 0.05) {
					bueltak = bueltak - 0.05;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "0.05€-ko moneta \n ";

				} else if (bueltak >= 0.02) {
					bueltak = bueltak - 0.02;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "0.02€-ko moneta \n";

				} else if (bueltak >= 0.01) {
					bueltak = bueltak - 0.01;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "0.01€-ko moneta \n ";
				}
			}
		}
		return bueltakString;
	}

	public static void fitxIdatzi(Txartelak txartela) {
		FileWriter fitx = null;
		PrintWriter pw = null;

		try {
			fitx = new FileWriter("src\\eredua\\Billetea", true);
			pw = new PrintWriter(fitx);

			pw.println("Ibilbidearen datuak:  \n" + "\tHartutako linea:  " + txartela.getkodLinea() + "\t\t\t"
					+ "Hasierako geltokia:  " + txartela.getkodGeltokiHasiera() + "\t\t\t" + "Amaierako geltokia:  "
					+ txartela.getkodGeltokiAmaiera() + "\t\t\t" + "Zure autobusaren kodigoa:  " + txartela.getkodBus()
					+ "\n");
			pw.println("Bezeroaren datuak:  \n" + "\tNAN:  " + txartela.getNan() + "\n");
			pw.println("Erosketaren datuak:  \n" + "\tData eta ordua:  " + txartela.getOrdua() + "\t\t\t"
					+ "Bidaiaren prezioa:  " + txartela.getPrezioa() + "\n");
			pw.println(
					"******************************************************************************************************************************************");

			pw.println("");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fitx)
					fitx.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
