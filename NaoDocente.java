package project;

public class NaoDocente extends Functionario {
    private String cargo;
	
    public NaoDocente(String a, String b, int c, String d, String e) {
        super(a,b,c,d);
        setCarga(e);
    }

    public String getCarga() {
        return cargo;
    }

    public boolean setCarga(String carga) {
        switch (carga) {
            case "Secretaria":
                break;
            case "Financeiro":
                break;
            case "Apoio Técnico":
                break;
            default:
                System.out.println("Cargo invalido!\n Escolha entre [Secretaria | Financeiro | Apoio Técnico]");
                return false;
        }
        
        this.cargo = carga;
        return true;
    }
        
    @Override
    public String toString() {
        String str = "";
        str += super.toString();
        str += this.getCarga();
        return str;
    }
}
