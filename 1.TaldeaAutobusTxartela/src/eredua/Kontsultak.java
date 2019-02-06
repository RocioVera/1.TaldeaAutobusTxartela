package eredua;

import java.util.ArrayList;
import java.sql.*;
import kontrolatzailea.*;
import java.time.LocalDate;

public class Kontsultak {
	// kontsultak
	public static ArrayList<Lineak> lineakDatuak() {
		ArrayList<Lineak> arrayLineak = new ArrayList<Lineak>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		String kodLinea, izena;

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM linea");

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
			ResultSet rs = st.executeQuery("SELECT * FROM autobus");
			while (rs.next()) {
				kodBus = (rs.getInt("Cod_bus"));
				nPlaza = (rs.getInt("N_plazas"));
				kontsumoa = (rs.getFloat(3));
				kolorea = (rs.getString(4));
				Autobusak autobusak = new Autobusak(kodBus, nPlaza, kontsumoa, kolorea);
				arraybus.add(autobusak);
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
		String izena, abizenak, NAN, pasahitza, sexua;
		java.sql.Date data;
		ResultSet rs = null;

		try {
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT * FROM cliente");

			while (rs.next()) {
				NAN = (rs.getString(1));
				izena = (rs.getString(2));
				abizenak = (rs.getString(3));
				data = (rs.getDate(4));
				sexua = (rs.getString(5));
				pasahitza = (rs.getString(6));
				Bezeroak bezeroa = new Bezeroak(NAN, izena, abizenak, data, sexua, pasahitza);
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
			ResultSet rs = st.executeQuery("Select * FROM linea_parada");
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
			ResultSet rs = st.executeQuery("Select * FROM linea_autobus");
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

	public static String hasGeltokiarenIzena(int kodGeltokiHasiera) {
		PreparedStatement st = null;
		Connection konexioa = Konexioa.getConexion();
		String geltHasiIzena = null;
		try {
			st = konexioa.prepareStatement(
					"SELECT nombre FROM parada WHERE Cod_Parada="+"'"+kodGeltokiHasiera + "'");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				geltHasiIzena = (rs.getString("nombre"));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return geltHasiIzena;

	}

	public static String amaGeltokiarenIzena(int kodGeltokiHasiera) {
		PreparedStatement st = null;
		Connection konexioa = Konexioa.getConexion();
		String geltAmaIzena = null;
		try {
			st = konexioa.prepareStatement(
					"SELECT nombre FROM parada WHERE Cod_Parada="+"'"+kodGeltokiHasiera + "'");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				geltAmaIzena = (rs.getString("nombre"));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return geltAmaIzena;

	}

	// insertak
	public static ArrayList<Bezeroak> erregistratuBezeroak(String pasahitza, String NAN, String izena, String abizenak,
			String sexua, String jaioData) {
		ArrayList<Bezeroak> arrayBezeroak = new ArrayList<Bezeroak>();
		Connection konexioa = Konexioa.getConexion();

		try {
			PreparedStatement st = konexioa.prepareStatement(
					"INSERT INTO `cliente` (`DNI`, `Nombre`, `Apellidos`, `Fecha_nac`, `Sexo`, `Contrasena`)"
							+ " VALUES(?, ?, ?, ?, ?, ?)");

			st.setString(1, NAN);
			st.setString(2, izena);
			st.setString(3, abizenak);
			st.setString (4, jaioData);
			st.setString(5, sexua);
			st.setString(6, pasahitza);

			st.executeUpdate();
			st.close();

			System.out.println("Gehitu da");
		} catch (SQLException e) {
			System.out.println("Ez da gehitu");
			// e.printStackTrace();
		}

		arrayBezeroak = bezeroDatuak();
		return arrayBezeroak;
	}

	public static void billeteaKontsulta(Txartelak txartela, String data, int ibilbideZbk) {
		// kalkulatu prezioa distantziaren metodoak dietzen
		Connection konexioa = Konexioa.getConexion();
		try {

			PreparedStatement st = konexioa.prepareStatement(
					"INSERT INTO `billete` (`NTrayecto`, `Cod_Linea`, `Cod_Bus`, `Cod_Parada_Inicio`, `Cod_Parada_Fin`, `Fecha`, `Hora`, `DNI`, `Precio`, `IbilbideData`)"
							+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			st.setInt(1, ibilbideZbk);
			st.setString(2, txartela.getkodLinea());
			st.setInt(3, txartela.getkodBus());
			st.setInt(4, txartela.getkodGeltokiHasiera());
			st.setInt(5, txartela.getkodGeltokiAmaiera());
			st.setDate(6, txartela.getData());
			st.setTimestamp(7, txartela.getOrdua());
			st.setString(8, txartela.getNan());
			st.setFloat(9, txartela.getPrezioa());
			st.setString(10, data);
			
			st.executeUpdate();
			System.out.println(ibilbideZbk);
			System.out.println(data);
			st.close();

			System.out.println("Gehitu da");
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	
	/*
	 * 
CREATE TABLE `billete` (
  `Cod_Billete` int(8) NOT NULL,
  `NTrayecto` int(11) NOT NULL,
  `Cod_Linea` varchar(10) COLLATE utf8_bin NOT NULL,
  `Cod_Bus` int(11) NOT NULL,
  `Cod_Parada_Inicio` int(8) NOT NULL,
  `Cod_Parada_Fin` int(8) NOT NULL,
  `FechaCompra` date NOT NULL,
  `HoraCompra` time NOT NULL,
  `DNI` varchar(9) COLLATE utf8_bin NOT NULL,
  `ibilbideData` varchar(20) NOT NULL,
  `Precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;*/
	
	

}
