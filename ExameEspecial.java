package project;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Kwinten Jacobs
 * @author Luis David
 */
public class ExameEspecial extends Exame implements Serializable{
    private static final long serialVersionUID = 507L;

    public ExameEspecial(Docente responsavel, Sala local, Date hora, int tempo) {
        super(responsavel, local, hora, tempo);
    }

    @Override
    public void addAluno(Aluno student) {
        if( checkDone()){
            return;
        }
        
        if( allowedEpocaEspecial(student)){
            this.alunos.add(student);
        }
        else{
            System.out.println("Este aluno não é permitido neste Exame");
        }
    }
    
    /**
     * Checks whether the given Aluno is allowed to participate in an ExameEspecial
     * @param student Aluno
     * @return true if the student is allowed, false if otherwise
     */
    private boolean allowedEpocaEspecial(Aluno student) {
        switch(student.getRegime().toUpperCase()){
            case "TRABALHADOR":
                    return true;
            case "ATLETA":
                    return true;
            case "DIRIGENTE ASSOCIATIVO":
                    return true;
            default:
                break;
            }
        // add last year verification
        return false;
    }

	
}
