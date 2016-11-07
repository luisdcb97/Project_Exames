package project;

public class NaoDocente extends Functionario {
	
	private String carga;
	
	NaoDocente(String a, String b, int c, String d, String e) {
		super(a,b,c,d);
		setCarga(e);
	}

	public String getCarga() {
		return carga;
	}

	public void setCarga(String carga) {
		this.carga = carga;
	}

}
