package project;

public class Docente extends Functionario {
	
    private String area;

    Docente(String nome, String email, int mecano, String d, String e){
        super(nome,email,mecano,d);
        setArea(e);
    }

    public String getArea() {
        return area;
    }
    
    public boolean setArea(String area) {
        switch (area) {
            case "Sistemas de Informacao":
                break;
            case "Comunicação e Telemática":
                break;
            case "Engenharia de Software":
                break;
            default:
                System.out.println("Area de Investigacao invalida!\n Escolha entre [Licenciatura | Mestrado | Doutoramento]");
                return false;
        }
        
        this.area = area;
        return true;
    }
    
    @Override
    public String toString() {
        String str = "";
        super.toString();
        str += this.getArea();
        return str;
    }

}
