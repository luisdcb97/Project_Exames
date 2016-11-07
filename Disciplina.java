package project;

import java.util.ArrayList;

public class Disciplina {
	
	private String name;
	private Docente docenteresponsavel;
	ArrayList<Docente> docentes = new ArrayList<Docente>();
	ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	ArrayList<Exame> exames = new ArrayList<Exame>();
	
	void listExams() {
		ArrayList<ExameEspecial> especial = new ArrayList<ExameEspecial>();
		ArrayList<ExameNormal> normal = new ArrayList<ExameNormal>();
		ArrayList<ExameRecurso> recurso = new ArrayList<ExameRecurso>();
		for(int i = 0;i<exames.size();i++) {
			if(exames.get(i).getClass() ==ExameEspecial.class) {
				especial.add((ExameEspecial)exames.get(i));
			}
			if(exames.get(i).getClass() == ExameNormal.class){
				normal.add((ExameNormal)exames.get(i));
			}
			if(exames.get(i).getClass() == ExameRecurso.class){
				recurso.add((ExameRecurso)exames.get(i));
			}
		}
		System.out.println("The normal exams of: "+getName());
		for(int i = 0;i<normal.size();i++) {
			System.out.println(normal.get(i).getData()+"  "+ normal.get(i).getSala().getId());
		}
		for(int i = 0;i<recurso.size();i++) {
			System.out.println(recurso.get(i).getData()+"  "+recurso.get(i).getSala().getId());
		}
		for(int i = 0;i<especial.size();i++) {
			System.out.println(especial.get(i).getData()+"  "+especial.get(i).getSala().getId());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Docente getDocenteresponsavel() {
		return docenteresponsavel;
	}

	public void setDocenteresponsavel(Docente docenteresponsavel) {
		this.docenteresponsavel = docenteresponsavel;
	}
}
