package project;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Kwinten Jacobs
 * @author Luis David
 */
public class ExameNormal extends Exame implements Serializable{
    private static final long serialVersionUID = 508L;

    public ExameNormal(Docente responsavel, Sala local, Date hora, int tempo) {
        super(responsavel, local, hora, tempo);
    }

    @Override
    void addAluno(Aluno a) {
        if( checkDone()){
            return;
        }
        
        
    }

	
}
