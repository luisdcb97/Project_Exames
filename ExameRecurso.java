package project;

import java.io.Serializable;
import java.util.Date;

public class ExameRecurso extends Exame implements Serializable{
    private static final long serialVersionUID = 509L;

    public ExameRecurso(Docente responsavel, Sala local, Date hora, int tempo) {
        super(responsavel, local, hora, tempo);
    }

    @Override
    void addAluno(Aluno a) {
        if( checkDone()){
            return;
        }
        
        
    }

    

	
}
