package project;

import java.util.ArrayList;
import java.util.Date;
/*
 * @author Kwinten Jacobs
 * @author Luis David
 * @version 1.0
 */
abstract class Exame {
	
	private ArrayList<Docente> vigilantes = new ArrayList<Docente>();
	private ArrayList<NaoDocente> naodocentes = new ArrayList<NaoDocente>();
	private ArrayList<Double> notas = new ArrayList<Double>();
	protected ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private Docente docenteresponsavel;
	private Date data;
	private Sala sala;
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
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
}