package kontrolatzailea;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import eredua.*;
import ikuspegia.*;

public class Metodoak {
	/**
	 * Etxera ematerakoan variableak hasieratik hasteko
	 * 
	 * @author talde1
	 */
	public static void hasieratuMetodoa() {

	}

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

	public static double kalkulatuPrezioa() {
		double guztira = 0;

		return guztira;
	}

	public static String balidatuPasahitza(String pasahitza) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(pasahitza.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			System.out.println();
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean frogatuPasahitza(String pasahitza) {
		boolean bal = false;
		String pasaEnkr = "";
		pasaEnkr = balidatuPasahitza(pasahitza);
		ArrayList<Bezeroak> bezeroak = new ArrayList<>();
		bezeroak = Kontsultak.bezeroDatuak();
		for (Bezeroak bezeroak2 : bezeroak) {
			if (pasaEnkr.equals(bezeroak2.getPasahitza()))
				bal = true;
		}
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

	}
}
