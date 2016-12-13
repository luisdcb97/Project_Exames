package project;

public class ExameEspecial extends Exame {

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
