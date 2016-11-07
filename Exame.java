package project;

import java.util.ArrayList;
import java.util.Date;

abstract class Exame {
	
	ArrayList<Docente> vigilantes = new ArrayList<Docente>();
	ArrayList<NaoDocente> naodocentes = new ArrayList<NaoDocente>();
	ArrayList<Double> notas = new ArrayList<Double>();
	ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private Docente docenteresponsavel;
	private Date data;
//	private Sala sala;
	public Docente getDocenteresponsavel() {
		return docenteresponsavel;
	}
	public void setDocenteresponsavel(Docente docenteresponsavel) {
		this.docenteresponsavel = docenteresponsavel;
	}
	boolean allowedEpocaEspecial(Aluno a) {
		switch(a.getRegime().toUpperCase()){
		case "TRABALHADOR":
			return true;
		case "ATLETAS":
			return true;
		case "DIRIGENTES":
			return true;
		case "ULTIMOANO":
			return true;
		}
		return false;
	}
	void createNotas() {
		for(int i = 0;i<alunos.size();i++) {
			double a = Math.random()*21;
			notas.add(a);
		}
	}
	void listAlunos() {
		for(int i = 0;i<alunos.size();i++) {
			System.out.println(alunos.get(i).getName());
		}
	}
	void listFunctionaros() {
		System.out.println("Docente responsavel: "+getDocenteresponsavel());
		for(int i = 0; i<vigilantes.size();i++) {
			System.out.println("Vigilantes: ");
			System.out.println(vigilantes.get(i).getName());
		}
		for(int i = 0;i<naodocentes.size();i++) {
			System.out.println("Functionarios :");
			System.out.println(naodocentes.get(i).getName());
		}
	}
	void listNotas() {
		for(int i = 0;i<alunos.size();i++) {
			System.out.println("Aluno : "+alunos.get(i).getName()+" | Nota: "+notas.get(i));
		}
	}
	abstract void addAluno(Aluno a);
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}