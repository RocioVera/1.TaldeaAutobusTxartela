package eredua;

public class Txartelak {
	
	private int kodTxartela;
	private String kodLinea;
	private int kodBus;
	private int kodGeltokiHasiera;
	private int kodGeltokiAmaiera;
	private String data;
	private String ordua;
	private String NAN;
	private float prezioa;
	
	public Txartelak(int kodTxartela, String kodLinea, int kodBus, int kodGeltokiHasiera, int kodGeltokiAmaiera,
			String data, String ordua, String nAN, float prezioa) {
		
		this.kodTxartela = kodTxartela;
		this.kodLinea = kodLinea;
		this.kodBus = kodBus;
		this.kodGeltokiHasiera = kodGeltokiHasiera;
		this.kodGeltokiAmaiera = kodGeltokiAmaiera;
		this.data = data;
		this.ordua = ordua;
		NAN = nAN;
		this.prezioa = prezioa;
	}
	
	public int getkodTxartela() {
		return kodTxartela;
	}

	public void setkodTxartela(int kodTxartela) {
		this.kodTxartela = kodTxartela;
	}

	public String getkodLinea() {
		return kodLinea;
	}

	public void setkodLinea(String kodLinea) {
		this.kodLinea = kodLinea;
	}

	public int getkodBus() {
		return kodBus;
	}

	public void setkodBus(int kodBus) {
		this.kodBus = kodBus;
	}

	public int getkodGeltokiHasiera() {
		return kodGeltokiHasiera;
	}

	public void setkodGeltokiHasiera(int kodGeltokiHasiera) {
		this.kodGeltokiHasiera = kodGeltokiHasiera;
	}

	public int getkodGeltokiAmaiera() {
		return kodGeltokiAmaiera;
	}

	public void setkodGeltokiAmaiera(int kodGeltokiAmaiera) {
		this.kodGeltokiAmaiera = kodGeltokiAmaiera;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOrdua() {
		return ordua;
	}

	public void setOrdua(String ordua) {
		this.ordua = ordua;
	}

	public String getNAN() {
		return NAN;
	}

	public void setNAN(String nAN) {
		NAN = nAN;
	}

	public float getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}

	

}
