package project;
/*
 * @author Kwinten Jacobs
 * @author Luis David
 * @version 1.0
 */
abstract class Functionario extends Pessoa {
	
	private int mecano;
	protected String categoria;
	
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

	abstract void setCategoria(String categoria);
}

