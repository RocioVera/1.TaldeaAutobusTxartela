package kontrolatzailea;

public class Geltokiak {
	
	private int kodGeltokia;
	private String izena;
	private String kalea;
	private float altuera;
	private float luzera;
	
	public Geltokiak(int kodGeltokia, String izena, String kalea, float altuera, float luzera) {
		
		this.kodGeltokia = kodGeltokia;
		this.izena = izena;
		this.kalea = kalea;
		this.altuera = altuera;
		this.luzera = luzera;
	}
	
	public int getKodGeltokia() {
		return kodGeltokia;
	}
	
	public void setKodGeltokia(int kodGeltokia) {
		this.kodGeltokia = kodGeltokia;
	}
	
	public String getIzena() {
		return izena;
	}
	
	public void setIzena(String izena) {
		this.izena = izena;
	}
	
	public String getKalea() {
		return kalea;
	}
	
	public void setKalea(String kalea) {
		this.kalea = kalea;
	}
	
	public float getAltuera() {
		return altuera;
	}
	
	public void setAltuera(float altuera) {
		this.altuera = altuera;
	}
	
	public float getLuzera() {
		return luzera;
	}
	
	public void setLuzera(float luzera) {
		this.luzera = luzera;
	}


}
