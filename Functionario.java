package project;

import java.io.Serializable;

abstract class Functionario extends Pessoa implements Serializable{
    private static final long serialVersionUID = 510L;
	
    private int mecano;
    private String categoria;

    Functionario(String nome, String email, int mecano, String categ) {
        super(nome,email);
        setMecano(mecano);
        setCategoria(categ);
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

    public boolean setCategoria(String categoria) {
        if(this.getClass() == Docente.class){
            switch (categoria) {
                case "Assistente":
                    break;
                case "Auxiliar":
                    break;
                case "Associado":
                    break;
                case "Catedratico":
                    break;
                default:
                    System.out.println("Categoria invalida!\n Escolha entre [Licenciatura | Mestrado | Doutoramento]");
                    return false;
            }
        }
        else{
            switch (categoria) {
                case "Assistente Operacional":
                    break;
                case "Assistente Tecnico":
                    break;
                case "Tecnico Superior":
                    break;
                case "Tecnico de Informatica":
                    break;
                case "Especialista de Informatica":
                    break;
                default:
                    System.out.println("Categoria invalida!\n Escolha entre [Licenciatura | Mestrado | Doutoramento]");
                    return false;
            }
        }
        this.categoria = categoria;
        return true;
    }

    @Override
    public String toString() {
        String str = "";
        str += super.toString();
        str += String.format("%09d", this.getMecano()) + " ";
        str += this.getCategoria() + " ";
        return str;
    }
    
    @Override
    public String toText() {
        String str = "";
        str += super.toText() + "|";
        str += String.format("%09d", this.getMecano()) + "|";
        str += this.categoria;
        return str;
    }
        
}
