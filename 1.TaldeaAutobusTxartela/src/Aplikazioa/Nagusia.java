package Aplikazioa;

import kontrolatzailea.*;

public class Nagusia {

	public static void main(String[] args) {
		String basedatos = "ethazi3";
		Konexioa konex = new Konexioa(basedatos);
		konex.getConexion();
		
		Metodoak.lehenengoLeihoa();

	}
}