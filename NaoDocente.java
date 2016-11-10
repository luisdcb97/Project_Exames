package project;
/*
 * @author Kwinten Jacobs
 * @author Luis David
 * @version 1.0
 */
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
	
	public void setCategoria(String a) {
		switch(a.toLowerCase()) {
		case "assistente operacional":
			this.categoria = "Assistente Operacional";
			break;
		case "assistente tecnico":
			this.categoria = "Assistente Tecnico";
			break;
		case "tecnico superior":
			this.categoria = "Tecnico Superior";
			break;
		case "tecnico de informatica":
			this.categoria = "Tecnico de Informatica";
			break;
		case "especialista de informatica":
			this.categoria = "Especialista de Informatica";
			break;
		default:
			System.out.println("Invalid Input");
		}
	}
}
