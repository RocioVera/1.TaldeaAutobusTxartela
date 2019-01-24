package kontrolatzailea;

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

	public static void geltokiakHartu(String linea) {
		ArrayList<GeltokiaLinea> arrayGelLinea = Kontsultak.arrayGelLinea();
		ArrayList<Integer> arrayGeltokiak = new ArrayList<>();
		for (GeltokiaLinea obj : arrayGelLinea) {
			while (linea == obj.getKodLinea()) {
				arrayGeltokiak.add(obj.getKodGeltokia());
			}
		}


	}
	
	public static void kalkulatuPrezioa(double prezioa) {
		double guztira = 0;
		
		
	}
	
	public static void ateraTiketa() {
		
	}
	
	
}
