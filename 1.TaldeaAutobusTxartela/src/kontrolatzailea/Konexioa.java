package kontrolatzailea;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {
	private String makina;
	private String bezeroa;
	private String pasahitza;
	private int portua;
	private String portuaStr;

	private String zerbitzaria;
	private static Connection conexion = null;

	// CONSTRUCTOR
	// Recibe el nombre de la base de datos
	public Konexioa(String datuBasea) {

		String fitx = "src\\eredua\\DBkonexioa";
		try {
			FileReader fr = new FileReader(fitx);
			BufferedReader br = new BufferedReader(fr);

			Object[] arraya = br.lines().toArray();
			this.makina = String.valueOf(arraya[0]);
			this.bezeroa = String.valueOf(arraya[1]);
			this.pasahitza = String.valueOf(arraya[2]);
			this.portuaStr =String.valueOf(arraya[3]);
			this.portua = Integer.parseInt(portuaStr);
			this.zerbitzaria = String.valueOf(arraya[4]);

			
			fr.close();
		} catch (Exception e) {
			System.out.println("Excepcion leyendo fichero " + fitx + ": " + e);
		}

		this.zerbitzaria = "jdbc:mysql://" + this.makina + ":" + this.portua + "/" + datuBasea;

		// Registrar el driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR AL REGISTRAR EL DRIVER");
			System.exit(0); // parar la ejecución
		}

		// Establecer la conexión con el servidor
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://" + this.makina, this.bezeroa, this.pasahitza);
		} catch (SQLException e) {
			System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
			System.exit(0); // parar la ejecución
		}
		System.out.println("Conectado a " + datuBasea);
	}

	// Devuelve el objeto Connection que se usará en la clase Controller
	public static Connection getConexion() {
		return conexion;
	}

}