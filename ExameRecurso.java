package project;

import java.util.Date;

public class ExameRecurso extends Exame {

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
