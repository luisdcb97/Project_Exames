package project;

import java.util.ArrayList;
/*
 * @author Kwinten Jacobs
 * @author Luis David
 * @version 1.0
 */
public class Curso {

	private String nome;
	private int duracao;
	private String grau;
	protected ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public String getGrau() {
		return grau;
	}
	public void setGrau(String grau) {
		this.grau = grau;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
