/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luis David
 */
public class Curso implements Serializable{
    private static final long serialVersionUID = 502L;
    
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
    
    //<editor-fold defaultstate="collapsed" desc="void createDisciplina(Dei departamento)">
    public void createDisciplina(Dei departamento){
        Scanner scan = new Scanner(System.in);
        String novo_nome;
        
        System.out.println("Insira o nome da nova disciplina:");
        novo_nome = scan.nextLine();
        
        int count = departamento.listPessoa("docente");
        
        if(count == 0){
            System.out.println("Não existem docentes para colocar como responsaveis desta disciplina");
            System.out.println("Crie um docente no Menu de Pessoas!!!");
            return;
        }
        
        int escolha; 
        while(true){
            System.out.println("Insira o Docente que deseja ser o responsavel da disciplina[0-" +count+"]:");
            while (!scan.hasNextInt()) {
                System.out.println("Insercao invalida");
                scan.nextLine();
            }
            escolha = scan.nextInt();
            
            if(escolha >= 0 && escolha <= count){
                break;
            }
            System.out.println("Insercao invalida!!!!!!");
        }
        
        Docente doc = (Docente) departamento.getPessoa("docente", escolha-1);
        
        Disciplina nova = new Disciplina(novo_nome, doc);
        
        this.disciplinas.add(nova);
        
        System.out.print("Disciplina ");
        System.out.print(nova);
        System.out.println(" " + "adicionado ao curso " + this);
        
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="void removeDisciplina()">
    public void removeDisciplina(){
        int count = listDisciplinas();
        
        if(count == 0){
            System.out.println("Nao existem disciplinas para remover");
            return;
        }
        
        int escolha;
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Insira a disciplina a remover[0-" +count+"]:");
            while (!scan.hasNextInt()) {
                System.out.println("Insercao invalida");
                scan.nextLine();
            }
            escolha = scan.nextInt();
            
            if(escolha >= 0 && escolha <= count){
                break;
            }
            System.out.println("Insercao invalida!!!!!!");
        }
        
        if(escolha == 0){
            System.out.println("A cancelar remocao de disciplina...");
            return;
        }
        
        disciplinas.remove(escolha-1);
        System.out.println("Disciplina removida!");
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="int listDisciplinas()">
    public int listDisciplinas(){
        if(disciplinas.isEmpty()){
            System.out.println("Sem disciplinas para listar");
            return 0;
        }
        
        int count = 0;
        System.out.println("Nome\tNomeResponsavel\tEmailResponsavel\tNrDocentes\tNrAlunos\tNrExames");
        System.out.println("\n---------------------------------------------------------------------\n");
        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina get = disciplinas.get(i);
            System.out.println(get);
            count ++;
        }
        System.out.println("\n---------------------------------------------------------------------\n");
        
        return count;
    }
//</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Duracao get/set">
    public int getDuracao() {
        return duracao;
    }
    
    public boolean setDuracao(int duracao) {
        if(duracao < 1 || duracao > 9){
            System.out.println("Duracao invalida!!\n Duracao tem de ser entre 3 e 9 anos");
            return false;
        }
        this.duracao = duracao;
        return true;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Grau get/set">
    public String getGrau() {
        return grau;
    }
    
    public boolean setGrau(String grau) {
        switch (grau) {
            case "L":
                grau = "Licenciatura";
                break;
            case "M":
                grau = "Mestrado";
                break;
            case "D":
                grau = "Doutoramento";
                break;
            default:
                System.out.println("Grau invalido!\n Escolha entre [Licenciatura | Mestrado | Doutoramento]");
                return false;
        }
        
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
 //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Nome get/set">
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
//</editor-fold>

    @Override
    public String toString() {
        String str = "";
        str += this.getNome() + " ";
        str += this.getGrau() + " ";
        str += this.getDuracao();
        return str;
    }
    
    
}
