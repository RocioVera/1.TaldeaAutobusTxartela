package kontrolatzailea;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
	
	public static boolean erregistratuBezeroak(String pasahitza, String NAN, String izena, String abizenak, String sexua, String jaioData) {
		boolean bal = true;
		String pasaEnkr = "";
		pasaEnkr = zifratuPasahitza(pasahitza);
		
		ArrayList<Bezeroak> bezeroak = new ArrayList<>();
		bezeroak = Kontsultak.erregistratuBezeroak(pasaEnkr, NAN, izena, abizenak, sexua, jaioData);
		
	//	for (Bezeroak bezeroak2 : bezeroak) {
			if (pasaEnkr.isEmpty() || NAN.isEmpty() || izena.isEmpty() || abizenak.isEmpty() || sexua.isEmpty() || jaioData.isEmpty())
				bal = false;
	//	}
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

		Leiho2 Leiho2 = new Leiho2(lineak);
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
	public static void seigarrenLeihoa() {
		Leiho6 Leiho6 = new Leiho6();
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
}
