package project;

public class Docente extends Functionario {
	
	private String area;
	
	Docente(String a, String b, int c, String d, String e){
		super(a,b,c,d);
		setArea(e);
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
