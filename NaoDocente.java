package project;

import java.io.Serializable;

/**
 * @author Kwinten Jacobs
 * @author Luis David
 */
public class NaoDocente extends Functionario implements Serializable{
    private static final long serialVersionUID = 511L;
    private String cargo;
	
    public NaoDocente(String nome, String email, int mecano, String categ, String cargo) {
        super(nome,email,mecano,categ);
        setCargo(cargo);
    }

    /**Returns the cargo variable of the NaoDocente
     * @return String cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Sets cargo as the cargo variable of NaoDocente
     * @param cargo [Secretaria / Financeiro / Apoio Tecnico]
     * @return true if succesful, false if otherwise
     */
    public boolean setCargo(String cargo) {
        switch (cargo) {
            case "Secretaria":
                break;
            case "Financeiro":
                break;
            case "Apoio Tecnico":
                break;
            default:
                System.out.println("Cargo invalido!\n Escolha entre [Secretaria | Financeiro | Apoio Tecnico]");
                return false;
        }
        
        this.cargo = cargo;
        return true;
    }
        
    @Override
    public String toString() {
        String str = "";
        str += super.toString();
        str += this.getCargo();
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
