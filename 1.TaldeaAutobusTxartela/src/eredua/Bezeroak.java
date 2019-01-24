package eredua;

public class Bezeroak {
	
	private String NAN;
	private String izena;
	private String abizenak;
	private String data;
	private String sexua;
	private String pasahitza;
	
	public Bezeroak(String nAN, String izena, String abizenak, String data, String sexua, String pasahitza) {
		
		NAN = nAN;
		this.izena = izena;
		this.abizenak = abizenak;
		this.data = data;
		this.sexua = sexua;
		this.pasahitza = pasahitza;
	}
	
	public String getNAN() {
		return NAN;
	}
	
	public void setNAN(String nAN) {
		NAN = nAN;
	}
	
	public String getIzena() {
		return izena;
	}
	
	public void setIzena(String izena) {
		this.izena = izena;
	}
	
	public String getAbizenak() {
		return abizenak;
	}
	
	public void setAbizenak(String abizenak) {
		this.abizenak = abizenak;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getSexua() {
		return sexua;
	}
	
	public void setSexua(String sexua) {
		this.sexua = sexua;
	}
	
	public String getPasahitza() {
		return pasahitza;
	}
	
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	

}
