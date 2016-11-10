package project;
/*
 * @author Kwinten Jacobs
 * @author Luis David
 * @version 1.0
 */
public class ExameEspecial extends Exame {

	void addAluno(Aluno a) {
	if(allowedEpocaEspecial(a)){
		alunos.add(a);
	} else {
		//Rewrite into Portuguese
		System.err.println("Student: "+a.getName()+" is not eligible for the EpocaEspecial");
	}
	}
}
