package project;

public class Aluno extends Pessoa {
	
    private int num;
    private int ano;
    private String regime;

    Aluno(String nome, String email, int number) {
        super(nome,email);
        setNum(number);
    }

    Aluno(String nome, String email, int number, int year, String regime) {
        super(nome,email);
        setNum(number);
        setAno(year);
        setRegime(regime);
    }

    public int getNum() {
            return num;
    }

    public void setNum(int num) {
            this.num = num;
    }

    public int getAno() {
            return ano;
    }

    public void setAno(int ano) {
            this.ano = ano;
    }

    public String getRegime() {
            return regime;
    }

    public boolean setRegime(String regime) {
        switch (regime) {
            case "Normal":
                break;
            case "Trabalhador-estudante":
                break;
            case "Atleta":
                break;
            case "Dirigente Associativo":
                break;
            case "Erasmus":
                break;
            default:
                System.out.println("Regime invalido!\n Escolha entre [Licenciatura | Mestrado | Doutoramento]");
                return false;
        }

        this.regime = regime;
        return true;
    }

    @Override
    public String toString() {
        String str = "";
        str += super.toString();
        str += this.num;
        return str;
    }
    
    @Override
    public String toText() {
        String str = "";
        str += super.toText() + "|";
        str += this.num ;
        return str;
    }
    
    
        
}
