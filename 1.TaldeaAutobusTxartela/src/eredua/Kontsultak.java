package eredua;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

import eredua.*;
import kontrolatzailea.AutobusLinea;
import kontrolatzailea.Autobusak;
import kontrolatzailea.Bezeroak;
import kontrolatzailea.GeltokiaLinea;
import kontrolatzailea.Geltokiak;
import kontrolatzailea.Konexioa;
import kontrolatzailea.Lineak;

import java.sql.*;

public class Kontsultak {
	// static ez
	public static ArrayList<Lineak> lineakDatuak() {
		ArrayList<Lineak> arrayLineak = new ArrayList<Lineak>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		String kodLinea, izena;

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("select * from linea");

			// crear obejtos asignandoselo al rs, luego crear el obejeto y luego meterle las
			// variables
			while (rs.next()) {

				kodLinea = (rs.getString("Cod_Linea"));
				izena = (rs.getString("Nombre"));
				Lineak lineak = new Lineak(kodLinea, izena);
				arrayLineak.add(lineak);

			}

		} catch (Exception e) {
			e.getMessage();
		}
		return arrayLineak;
	}

	public static ArrayList<Autobusak> autobusDatuak() {
		ArrayList<Autobusak> arraybus = new ArrayList<Autobusak>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int kodBus, nPlaza;
		String kolorea;
		float kontsumoa;

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("select * from autobus");
			while (rs.next()) {
				kodBus = (rs.getInt("Cod_bus"));
				nPlaza = (rs.getInt("N_plazas"));
				kontsumoa = (rs.getFloat(3));
				kolorea = (rs.getString(4));
				Autobusak autobusak = new Autobusak(kodBus, nPlaza, kontsumoa, kolorea);
				arraybus.add(autobusak);
				for (int i = 0; i < arraybus.size(); i++) {
					System.out.println(arraybus);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return arraybus;
	}

	public static ArrayList<Geltokiak> geltokiakAtera(String linea) {
		ArrayList<Geltokiak> arrayparada = new ArrayList<Geltokiak>();
		PreparedStatement st = null;
		Connection konexioa = Konexioa.getConexion();
		try {

			st = konexioa.prepareStatement(
					"SELECT * FROM parada, linea_parada,linea WHERE parada.Cod_Parada=linea_parada.Cod_Parada and linea.Cod_Linea=linea_parada.Cod_Linea AND linea.Cod_Linea like"
							+ "'" + linea + "'");
			ResultSet rs = st.executeQuery();

			int kodGeltokia;
			String izena;
			String kalea;
			float altuera;
			float luzera;
			while (rs.next()) {
				System.out.println(rs.getString(2));
				kodGeltokia = (rs.getInt(1));
				izena = (rs.getString(2));
				kalea = (rs.getString(3));
				altuera = (rs.getFloat(4));
				luzera = (rs.getFloat(5));
				Geltokiak parada = new Geltokiak(kodGeltokia, izena, kalea, altuera, luzera);
				arrayparada.add(parada);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return arrayparada;
	}

	public static ArrayList<Bezeroak> bezeroDatuak() {
		ArrayList<Bezeroak> arrayBezeroak = new ArrayList<Bezeroak>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		String izena, abizena, NAN, data, pasahitza, sexua;

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("select * from cliente");
			while (rs.next()) {
				NAN = (rs.getString(1));
				izena = (rs.getString(2));
				abizena = (rs.getString(3));
				data = (rs.getString(4));
				sexua = (rs.getString(5));
				pasahitza = (rs.getString(6));
				Bezeroak bezeroa = new Bezeroak(NAN, izena, abizena, data, sexua, pasahitza);
				arrayBezeroak.add(bezeroa);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return arrayBezeroak;
	}

	public static ArrayList<GeltokiaLinea> arrayGelLinea() {

		ArrayList<GeltokiaLinea> arrayGelLinea = new ArrayList<GeltokiaLinea>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		String kodLinea;
		int kodGeltokia;

		try {

			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("Select * from linea_parada");
			while (rs.next()) {
				kodLinea = (rs.getString("Cod_Linea"));
				kodGeltokia = (rs.getInt("Cod_Parada"));
				GeltokiaLinea geltokiLinea = new GeltokiaLinea(kodLinea, kodGeltokia);
				arrayGelLinea.add(geltokiLinea);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return arrayGelLinea;

	}

	public static ArrayList<AutobusLinea> arrayBusLinea() {

		ArrayList<AutobusLinea> arrayBusLinea = new ArrayList<AutobusLinea>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		String kodLinea;
		int kodAutobusa;

		try {

			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("Select * from linea_autobus");
			while (rs.next()) {
				kodLinea = (rs.getString("Cod_Linea"));
				kodAutobusa = (rs.getInt("Cod_bus"));
				AutobusLinea autobusLinea = new AutobusLinea(kodLinea, kodAutobusa);
				arrayBusLinea.add(autobusLinea);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return arrayBusLinea;

	}
}
