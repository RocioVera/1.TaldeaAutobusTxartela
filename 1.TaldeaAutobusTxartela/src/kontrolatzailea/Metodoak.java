package kontrolatzailea;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.toedter.calendar.JDateChooser;

import eredua.*;
import ikuspegia.*;

public class Metodoak {
	/**
	 * Etxera ematerakoan variableak hasieratik hasteko
	 * 
	 * @author talde1
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
	public static double kalkulatuDistantzia(double altuera1, double luzera1, double altuera2, double luzera2) {
		double lurrarenErradioa = 6371;  
        double dLat = Math.toRadians(altuera2 - altuera1);  
        double dLng = Math.toRadians(luzera2 - luzera1);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)* Math.cos(Math.toRadians(altuera1)) * Math.cos(Math.toRadians(altuera2));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distantzia = lurrarenErradioa * va2;  
        return distantzia;  
	}
	
	public static double kalkulatuPrezioa(double altuera1, double luzera1, double altuera2, double luzera2, int zPlaza) {
		double guztira = 0;
		double distantzia=kalkulatuDistantzia(altuera1, luzera1, altuera2, luzera2);
		
		return guztira;
	}

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
	
	public static Date dataAldatu(Date jaioData) {
		String strFecha=new SimpleDateFormat("yyyy-MM-dd").format(jaioData);
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		try {
			jaioData = formatoDelTexto.parse(strFecha);
			} catch (ParseException ex) {
			ex.printStackTrace();
			System.out.println("txarto");
			}
		System.out.println(jaioData);
		return jaioData;
	}
	
	
	public static boolean erregistratuBezeroak(String pasahitza, String NAN, String izena, String abizenak, String sexua, Date jaioData) {
		boolean bal = true;
		String pasaEnkr = "";
		pasaEnkr = zifratuPasahitza(pasahitza);
		
		ArrayList<Bezeroak> bezeroak = new ArrayList<>();
		bezeroak = Kontsultak.erregistratuBezeroak(pasaEnkr, NAN, izena, abizenak, sexua, jaioData);
		
			if (pasahitza.length()==0 || NAN.isEmpty() || izena.isEmpty() || abizenak.isEmpty() || sexua.isEmpty() || jaioData==null)
				bal = false;
		return bal;
	}

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

	// lehio1 sortu
	public static void lehenengoLeihoa() {
		Leiho1 Leiho1 = new Leiho1();
		Leiho1.setVisible(true);

	}

	// leiho2 sortu
	public static void bigarrenLeihoa() {
		ArrayList<Lineak> lineak = new ArrayList<Lineak>();
		lineak = Kontsultak.lineakDatuak();
		ArrayList<Autobusak> autobusak = new ArrayList<>();
		autobusak = Kontsultak.autobusDatuak();
		Leiho2 Leiho2 = new Leiho2(lineak, autobusak);
		Leiho2.setVisible(true);
	}

	// leiho3 sortu
	public static void hirugarrenLeihoa(String hartutakoLinea) {
		ArrayList<Geltokiak> arrayGeltokia = new ArrayList<Geltokiak>();
		Leiho3 Leiho3 = new Leiho3(arrayGeltokia, hartutakoLinea);
		Leiho3.setVisible(true);
		
	}

	// leiho4 sortu
	public static void laugarrenLeihoa(String hartutakoLinea) {

		Leiho4 Leiho4 = new Leiho4(hartutakoLinea);
		Leiho4.setVisible(true);

	}

	// leiho5 sortu
	public static void bostgarrenLeihoa(String hartutakoLinea) {

		Leiho5 Leiho5 = new Leiho5(hartutakoLinea);
		Leiho5.setVisible(true);

	}

	// leiho6 sortu
	public static void seigarrenLeihoa(String hartutakoLinea) {
		Leiho6 Leiho6 = new Leiho6(hartutakoLinea);
		Leiho6.setVisible(true);
	//	Metodoak.Leiho_segunduak();

	}
	public static void Leiho_segunduak(){
		for (int i=1;i<=5;i++) {
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
	 * @author talde1
	 * @param kont
	 * @return sartutakoa
	 */
	public static double diruaSartu(int kont, double sartutakoa) {
		switch (kont) {
			case 1:
				sartutakoa += 200;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 2:
				sartutakoa += 100;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 3:
				sartutakoa += 50;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 4:
				sartutakoa += 20;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 5:
				sartutakoa += 10;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 6:
				sartutakoa += 5;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 7:
				sartutakoa += 2;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 8:
				sartutakoa += 1;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 9:
				sartutakoa += 0.5;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 10:
				sartutakoa += 0.2;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 11:
				sartutakoa += 0.1;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 12:
				sartutakoa += 0.05;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 13:
				sartutakoa += 0.02;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			case 14:
				sartutakoa += 0.01;
				sartutakoa = Math.round(sartutakoa*100.0)/100.0;
				break;
			
			default:
				sartutakoa=0;
				break;
			}
		return sartutakoa;
	}
	/**
	 * Jakiteko zenbat diru sartu duen gero bueltak emateko ala ez
	 * @author talde1
	 * @return diruFalta
	 */
	public static double diruFaltaBueltakMetodoa(double diruFalta, double guztiraPrez, double sartutakoa) {
		diruFalta = guztiraPrez-sartutakoa;
		diruFalta = Math.round(diruFalta*100.0)/100.0;
		return diruFalta;
	}
	
	/**
	 * Arrayan sartzeko zenbat kantitate txanpon bakoitza eta bueltatu txanpona / billete
	 * @author talde1
	 * @return bueltakString
	 */
	public static String bueltakZerrenda(double diruFalta) {
		String bueltakString="";
		double bueltak=0;

		if (diruFalta<0) {
			bueltak=-diruFalta;
			for (double i = bueltak; i>0 ; i=bueltak) {
				if (bueltak >= 200) {
					bueltak = bueltak - 200;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"200€-ko bilete \n";

				} else if (bueltak >= 100) {
					bueltak = bueltak - 100;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"100€-ko bilete \n";

				} else if (bueltak >= 50) {
					bueltak = bueltak - 50;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"50€-ko bilete \n";

				} else if (bueltak >= 20) {
					bueltak = bueltak - 20;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"20€-ko bilete \n";


				} else if (bueltak >= 10) {
					bueltak = bueltak - 10;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"10€-ko bilete \n";
					
				} else if (bueltak >= 5) {
					bueltak = bueltak - 5;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"5€-ko bilete \n";

				} else if (bueltak >= 2) {
					bueltak = bueltak - 2;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"2€-ko moneta \n";

				} else if (bueltak >= 1) {
					bueltak = bueltak - 1;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"1€-ko moneta \n";

				} else if (bueltak >= 0.5) {
					bueltak = bueltak - 0.5;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"0.5€-ko moneta \n";


				} else if (bueltak >= 0.2) {
					bueltak = bueltak - 0.2;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"0.2€-ko moneta \n";

				} else if (bueltak >= 0.1) {
					bueltak = bueltak - 0.1;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"0.1€-ko moneta \n ";

				} else if (bueltak >= 0.05) {
					bueltak = bueltak - 0.05;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"0.05€-ko moneta \n ";

				} else if (bueltak >= 0.02) {
					bueltak = bueltak - 0.02;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"0.02€-ko moneta \n";

				} else if (bueltak >= 0.01) {
					bueltak = bueltak - 0.01;
					bueltak = Math.round(bueltak*100.0)/100.0;
					bueltakString=bueltakString+"0.01€-ko moneta \n ";
				}
			}
		}
		return bueltakString;
	}

	
	
}
