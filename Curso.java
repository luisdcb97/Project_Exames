/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author Luis David
 */
public class Curso {
    private String nome;
    private int duracao;
    private String grau;
    private ArrayList<Disciplina> disciplinas;
    
    
    public Curso(String nome, int dur, String titulo){
        this.nome = nome;
        setDuracao(dur);
        setGrau(titulo);
        this.disciplinas = new ArrayList<>(10 * dur); // 10 cadeiras por ano
    }
    
    public Curso(String nome, int dur, String titulo, ArrayList<Disciplina> cadeiras){
        this.nome = nome;
        setDuracao(dur);
        setGrau(titulo);
        this.disciplinas = new ArrayList<>(cadeiras);
    }
    
    public int getDuracao() {
        return duracao;
    }
    public boolean setDuracao(int duracao) {
        if(duracao < 3 || duracao > 9){
            System.out.println("Duracao invalida!!\n Duracao tem de ser entre 3 e 9 anos");
            return false;
        }
        this.duracao = duracao;
        return true;
    }
    
    public String getGrau() {
        return grau;
    }
    public boolean setGrau(String grau) {
        switch (grau) {
            case "Licenciatura":
                break;
            case "Mestrado":
                break;
            case "Doutoramento":
                break;
            default:
                System.out.println("Grau invalido!\n Escolha entre [Licenciatura | Mestrado | Doutoramento]");
                return false;
        }
        this.grau = grau;
        return true;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String str = "";
        str += this.getNome() + " ";
        str += this.getGrau() + " ";
        str += this.getDuracao();
        return str;
    }
    
    
}
