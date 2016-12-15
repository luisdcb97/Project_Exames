package project;

import java.io.Serializable;

public class NaoDocente extends Functionario implements Serializable{
    private static final long serialVersionUID = 511L;
    private String cargo;
	
    public NaoDocente(String nome, String email, int mecano, String categ, String cargo) {
        super(nome,email,mecano,categ);
        setCarga(cargo);
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
            case "Apoio Tecnico":
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
    
    @Override
    public String toText() {
        String str = "";
        str += super.toText() + "|";
        str += this.cargo;
        return str;
    }
}
