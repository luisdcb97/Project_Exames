package project;

import java.io.Serializable;

/**
 * @author Kwinten Jacobs
 * @author Luis David
 */
public class Docente extends Functionario implements Serializable{
    private static final long serialVersionUID = 505L;
	
    private String area;

    Docente(String nome, String email, int mecano, String categ, String area){
        super(nome,email,mecano,categ);
        setArea(area);
    }

    /**Returns the area variable of the Docente
     * @return String area
     */
    public String getArea() {
        return area;
    }
    
    /**
     * Sets the area variable of the Docente
     * @param area [Sistemas de Informacao / Comunicacao e Telematica / Engenharia de Software]
     * @return True if succesful, false if param area is invalid
     */
    public boolean setArea(String area) {
        switch (area) {
            case "Sistemas de Informacao":
                break;
            case "Comunicacao e Telematica":
                break;
            case "Engenharia de Software":
                break;
            default:
                System.out.println("Area de Investigacao invalida!\n Escolha entre [Sistemas de Informacao | Comunicacao e Telematica | Engenharia de Software]");
                return false;
        }
        
        this.area = area;
        return true;
    }
    
    @Override
    public String toString() {
        String str = "";
        str += super.toString();
        str += this.getArea();
        return str;
    }
    
    @Override
    public String toText() {
        String str = "";
        str += super.toText() + "|";
        str += this.area;
        return str;
    }

}
