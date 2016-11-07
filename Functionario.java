package project;

abstract class Functionario extends Pessoa {
	
	private int mecano;
	private String categoria;
	
	Functionario(String a, String b, int c, String d) {
		super(a,b);
		setMecano(c);
		setCategoria(d);
	}

	public int getMecano() {
		return mecano;
	}

	public void setMecano(int mecano) {
		this.mecano = mecano;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
