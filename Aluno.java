package project;

import java.io.Serializable;

/**
 * @author Kwinten Jacobs
 * @author Luis David
 */
public class Aluno extends Pessoa implements Serializable{
    private static final long serialVersionUID = 501L;
    
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

    /**
     * Returns the number of the Aluno
     * @return integer representing the number of the Aluno
     */
    public int getNum() {
            return num;
    }

    /**
     * Sets num as the number variable of the Aluno
     * @param num integer to be set as num var for Aluno
     */
    public void setNum(int num) {
            this.num = num;
    }

    /**
     * Returns the ano of the Aluno
     * @return integer ano
     */
    public int getAno() {
            return ano;
    }

    /**
     * Sets ano as the ano variable of the Aluno
     * @param ano integer to be set as ano variable for Aluno
     */
    public void setAno(int ano) {
            this.ano = ano;
    }

    /**
     * Returns the regime of the Aluno
     * @return String regime
     */
    public String getRegime() {
            return regime;
    }

    /**
     * Sets the regime of the Aluno to variable regime
     * @param regime [Normal / Trabalhador-estudante / Atleta / Dirigente Associativo / Erasmus]
     * @return
     */
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
                System.out.println("Regime invalido!\n Escolha entre [Normal | Trabalhador-estudante | Atleta | Dirigente Associativo | Erasmus]");
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
