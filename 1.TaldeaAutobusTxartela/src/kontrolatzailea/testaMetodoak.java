package kontrolatzailea;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class testaMetodoak {
	@BeforeClass
	public void KonexioaTesta() {
		Connection konexioa = Konexioa.getConexion();
		Statement st = null;
		ResultSet rs = null;

		System.out.println(konexioa);
	}
	// double
	// Zenbat diru sartzen duen jakiteko egiteko - froga
	@Test
	public void diruaSartuTesta() {
		assertEquals(Metodoak.diruaSartu(0, 0), 0.0); // 0
		assertEquals(Metodoak.diruaSartu(1, 0), 200);
		assertEquals(Metodoak.diruaSartu(2, 200), 300); // 200+100
		assertEquals(Metodoak.diruaSartu(3, 300), 350); // 300+50
		assertEquals(Metodoak.diruaSartu(4, 350), 370); // 350+20
		assertEquals(Metodoak.diruaSartu(5, 370), 380); // 370+10
		assertEquals(Metodoak.diruaSartu(6, 380), 385); // 380+5
		assertEquals(Metodoak.diruaSartu(7, 385), 387);// 385+2
		assertEquals(Metodoak.diruaSartu(8, 387), 388); // 387+1
		assertEquals(Metodoak.diruaSartu(9, 388), 388.5); // 387.5+0.5
		assertEquals(Metodoak.diruaSartu(10, 388.5), 388.7); // 388.5+0.2
		assertEquals(Metodoak.diruaSartu(11, 388.7), 388.8); // 388.7+0.1
		assertEquals(Metodoak.diruaSartu(12, 388.8), 388.85); // 388.80+0.05
		assertEquals(Metodoak.diruaSartu(13, 388.85), 388.87); // 388.85+0.02
		assertEquals(Metodoak.diruaSartu(14, 388.87), 388.88); // 388.87+0.01
	}

	// Jakiteko zenbat diru sartu duen gero bueltak emateko ala ez - froga
	@Test
	public void diruFaltaBueltakMetodoaTesta() {
		assertEquals(Metodoak.diruFaltaBueltakMetodoa(0, 6, 2.5), 3.5);
	}

	// Bi geltokien harteko distantzia kalkulatu
	@Test
	public void kalkulatuDistantziaTesta() {
		assertEquals(Metodoak.kalkulatuDistantzia(43.2614, -2.94974, 43.3759, -2.99183), 13.179291549936597); // termibus -  metro  larrabasterra
	}

	// float
	// Bi geltokien harteko distantzia kalkulatu
	@Test
	public void kalkPrezioaTesta() {
		float kontsumoa = (float) 0.32;
		float erantzuna = (float) 0.1;
		assertEquals(Metodoak.kalkPrezioa(kontsumoa, 40, 43.2614, -2.94974, 43.3759, -2.99183, 1), erantzuna); // termibus -metro larrabasterra
	}

	// String
	// Arrayan sartzeko zenbat kantitate txanpon bakoitza eta bueltatu txanpona / billete- froga
	@Test
	public void diruBueltakZerrenda() {
		assertEquals(Metodoak.diruBueltakZerrenda(-200), "200�-ko bilete \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-100), "100�-ko bilete \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-50), "50�-ko bilete \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-20), "20�-ko bilete \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-10), "10�-ko bilete \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-5), "5�-ko bilete \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-2), "2�-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-1), "1�-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-0.5), "0.5�-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-0.2), "0.2�-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-0.1), "0.1�-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-0.05), "0.05�-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-0.02), "0.02�-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-0.01), "0.01�-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(1), "");
	}

	// nan-aren zenbaki guztiak gehitzen ditu eta zati 23 egiten hondarra lortzen du. Hondarra horrekin sartutako nan-aren letra bueltatzen du.
	@Test
	public void nanLetraTesta() {
		String nan = "12345678Z";
		assertEquals(Metodoak.nanLetra(nan), "Z");
	}

//TXARTO
	//zifratuPasahitza
	@Test
	public void zifratuPasahitzaTesta() {
		String pasahitza="123456";
		assertEquals(Metodoak.zifratuPasahitza(pasahitza), "e10adc3949ba59abbe56e057f20f883e");

	}

	//boolean
	// Sartutako pasahitza (zifratuta) ea datu basean dagoen ala ez
	@Test
	public void frogatuPasahitzaTesta() {
		String pasahitzaTxarto="abracadabra";
		assertFalse(Metodoak.frogatuPasahitza(pasahitzaTxarto));

		String pasahitzaOna="123456";
		assertTrue(Metodoak.frogatuPasahitza(pasahitzaOna));
	}
	
	//Sartutako nan-a ea datu baaean dagoen ala ez
	@Test
	public void frogatuNANTesta() {
		String nanOna="12345678Z";
		String nanTxarto="12345678x";
		assertFalse(Metodoak.frogatuNAN(nanTxarto));
		assertTrue(Metodoak.frogatuNAN(nanOna));
		
	}
	//frogatuNAN
	@Test
	public void nanBalidazioaTesta() {
		String nanOna="12345678Z";
		String nanTxarto="12345678x";
		assertTrue(Metodoak.nanBalidazioa(nanOna));
		assertFalse(Metodoak.nanBalidazioa(nanTxarto));
	}
	
}
