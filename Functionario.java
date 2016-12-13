package project;

abstract class Functionario extends Pessoa {
	
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
                case "Catedrático":
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
                case "Assistente Técnico":
                    break;
                case "Técnico Superior":
                    break;
                case "Técnico de Informática":
                    break;
                case "Especialista de Informática":
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
        super.toString();
        str += this.getMecano() + " ";
        str += this.getCategoria() + " ";
        return str;
    }
        
}
