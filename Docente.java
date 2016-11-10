package project;
/*
 * @author Kwinten Jacobs
 * @author Luis David
 * @version 1.0
 */
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
	
	public void setCategoria(String a) {
		switch(a.toLowerCase()) {
		case "assistente":
			this.categoria = "Assistente";
			break;
		case "auxiliar":
			this.categoria = "Auxiliar";
			break;
		case "associado":
			this.categoria = "Associado";
			break;
		case "catedratico":
			this.categoria = "Associado";
			break;
		default:
			System.out.println("Invalid Input");
		}
	}

}
