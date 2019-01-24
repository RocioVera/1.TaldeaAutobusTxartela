package Aplikazioa;

import java.util.ArrayList;
import eredua.*;
import ikuspegia.Frame;
import kontrolatzailea.*;

public class Nagusia {

	public static void main(String[] args) {
		String basedatos = "ethazi3";
		Konexioa konex = new Konexioa(basedatos);
		konex.getConexion();
	//	Kontsultak.arrayGelLinea();

		Frame Ejecutar = new Frame();
		Ejecutar.setVisible(true);

		// ateratzeko datuak baina static ez
		// Kontsultak.autobusDatuak();
		//Kontsultak.geltokiakAtera("L2");

	}
}