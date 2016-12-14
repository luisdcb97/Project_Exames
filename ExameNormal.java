package project;

import java.util.Date;

public class ExameNormal extends Exame {

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
