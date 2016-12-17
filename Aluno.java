package project;

import java.io.Serializable;

/**
 * Aluno is the class which represents a student belonging to the university
 * 
 * @author Kwinten Jacobs
 * @author Luis David
 * @version 1.0
 * @see project.Pessoa
 * @since 1.0
 */
public class Aluno extends Pessoa implements Serializable{
    /**
    * Defines the <code>serialVersionUID</code> of this Aluno to prevent
    * errors when reading Object Files after altering class methods or 
    * when using different compilers
    * 
    * @see java.io.Serializable
    */
    private static final long serialVersionUID = 501L;
    
    private int num;
    private int ano;
    private String regime;

    /**
     * Constructs an <code><b>Aluno</b></code> object and initializes it so that
     * it represents a student named <code><b>nome</b></code>, with an e-mail
     * address <code><b>email</b></code> and a student university number
     * <code><b>number</b></code>
     * 
     * @param nome the name of the student
     * @param email the e-mail of the student
     * @param number the student's university student number
     * 
     * @since 1.0
     */
    Aluno(String nome, String email, int number) {
        super(nome,email);
        setNum(number);
    }

    /**
     * Constructs an <code><b>Aluno</b></code> object and initializes it so that
     * it represents a student named <code><b>nome</b></code>, with an e-mail
     * address <code><b>email</b></code>, a student university number
     * <code><b>number</b></code>, on his/hers <code><b>year</b></code> year
     * of a course and with a <code><b>regime</b></code> current student status
     * for a course
     * 
     * @param nome the name of the student
     * @param email the e-mail of the student
     * @param number the student's university student number
     * @param year the student's current year on a course
     * @param regime the student's status on a course
     * 
     * @since 1.0
     */
    Aluno(String nome, String email, int number, int year, String regime) {
        super(nome,email);
        setNum(number);
        setAno(year);
        setRegime(regime);
    }

    /**
     * Returns this student's student indetifying number
     *
     * @return the number which identifies this student
     * @since 1.0
     */
    public int getNum() {
            return num;
    }

    /**
     * Changes this student's student identifying number to
     * <code><b>num</b></code>
     * 
     * @param num the new number to identify this student
     * @since 1.0
     */
    public void setNum(int num) {
            this.num = num;
    }

    /**
     * Returns the year in which this student has been enrolled on a course
     * 
     * @return the year in which this student has been enrolled on a course
     * @since 1.0
     */
    public int getAno() {
            return ano;
    }

    /**
     * Changes the year in which this student has been enrolled on a course
     * to <code><b>ano</b></code>
     * 
     * @param ano the new year in which this student will be enrolled on a course
     * @since 1.0
     */
    public void setAno(int ano) {
            this.ano = ano;
    }

    /**
     * Returns the student status in which this student has been enrolled on a course
     * 
     * @return the student status in which this student has been enrolled on a course
     * @since 1.0
     */
    public String getRegime() {
            return regime;
    }

    /**
     * Changes the student status in which this student has been enrolled on a course
     * to <code><b>regime</b></code> as long is is one of the following
     * valid statuses:
     * 
     * <p>
     * <ul>
     *  <li>Normal</li>
     *  <li>Trabalhador-estudante</li>
     *  <li>Atleta</li>
     *  <li>Dirigente Associativo</li>
     *  <li>Erasmus</li>
     *  <li>Ultimo Ano</li>
     * </ul>
     * </p>
     * 
     * @param regime the new student status in which this student will be enrolled on a course
     * @return true if and only if the new student status is a valid student status
     * @since 1.0
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
            case "Ultimo Ano":
                break;
            default:
                System.out.print("Regime invalido!\n Escolha entre [Normal | Trabalhador-estudante");
                System.out.print(" | Atleta | Erasmus | Ultimo Ano]");
                return false;
        }

        this.regime = regime;
        return true;
    }

    /**
     * Returns a string representation of this <code>Aluno</code> 
     * 
     * @return a string representation of this <code>Aluno</code> 
     * @since 1.0
     */
    @Override
    public String toString() {
        String str = "";
        str += super.toString();
        str += this.num;
        return str;
    }
    
    /**
     * Returns a string representation of this <code>Aluno</code> formatted 
     * in a way to assist splitting of the returned string
     * 
     * @return a string representation of this <code>Aluno</code>
     * @since 1.0
     */
    @Override
    public String toText() {
        String str = "";
        str += super.toText() + "|";
        str += this.num ;
        return str;
    }
    
    
        
}
