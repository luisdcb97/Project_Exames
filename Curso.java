/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Kwinten Jacobs
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
    /**
     * Requests a series of user inputs to create a new instance of type Disciplina
     * @param departamento The instance of DEI in which the Disciplina will be situated
     */
    public void createDisciplina(DEI departamento){
        Scanner scan = new Scanner(System.in);
        String novo_nome;
        
        System.out.println("Insira o nome da nova disciplina:");
        novo_nome = scan.nextLine();
        
        int count = departamento.listPessoa("docente");
        
        if(count == 0){
            System.out.println("Nao existem docentes para colocar como responsaveis desta disciplina");
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
    /**
     * Requests a series of user inputs to remove a Disciplina
     */
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
    /**
     * Prints all instances of Disciplina to console
     * @return Integer stating the number of Disciplinas encountered
     */
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
    
    
    // <editor-fold defaultstate="collapsed" desc="void alteraDados(String altera)">
    /**
     * Allows the alteration of an existing Curso
     * @param altera 
     */
    public void alteraDados(String altera){
        Scanner scan = new Scanner(System.in);
        
        if(altera.equalsIgnoreCase("grau")){
            String novo_grau;
            while(true){
                System.out.println("Insira o grau do novo curso[ L/Licenciatura | M/Mestrado | D/Doutoramento]:");
                novo_grau = scan.nextLine();
                if(novo_grau.equals("Licenciatura") || novo_grau.equals("Mestrado") || novo_grau.equals("Doutoramento")
                        || novo_grau.equals("L") || novo_grau.equals("M") || novo_grau.equals("D")){
                    break;
                }

                System.out.println("Insercao invalida!!!");
            }
            
            this.setGrau(novo_grau);
        }
        else if(altera.equalsIgnoreCase("duracao")){
            int nova_dur;
            while(true){
                System.out.println("Insira a duracao do novo curso em anos [1-9]:");
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 1 e 9");
                    scan.nextLine();
                }
                nova_dur = scan.nextInt();
                if(nova_dur >=1 && nova_dur <= 9){
                    break;
                }

                System.out.println("Insercao invalida!!!");
            }
            
            this.setDuracao(nova_dur);
        }
        
        
        System.out.print("Curso ");
        System.out.print(this.getNome());
        System.out.println(" " + "alterado");
       
    } //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="int listExamsOfPessoa(Pessoa person)">
    /**
     * Prints all exams of Pessoa person
     * @param person The Pessoa who's exams are to be printed
     * @return Integer of amount of exams encountered for Pessoa person
     */
    public int listExamsOfPessoa(Pessoa person){
        String prefix = "[" + this.getNome()+ "] ";
        int count = 0;
        
        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina obtida = disciplinas.get(i);
            
            count += obtida.listExamsOfPessoa(person, prefix);
            
        }
        
        return count;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Duracao get/set">
    /**
     * Returns the duracao variable of a Curso
     * @return integer duracao
     */
    public int getDuracao() {
        return duracao;
    }
    
    /**
     * Sets duracao as the duracao variable of a Curso
     * @param duracao The duracao to be set
     * @return true if the duracao variable was set correctly, false if otherwise
     */
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
    /**
     * Returns the grau variable of a Curso
     * @return String grau
     */
    public String getGrau() {
        return grau;
    }
    
    /**
     * Sets the grau variable of a Curso
     * @param grau String [L|Licenciatura / M|Mestrado / D|Doutoramento] (Insert character)
     * @return Returns true if the grau variable was set correctly, false if otherwise
     */
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
    /**
     * Returns the nome variable of the Curso
     * @return String nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Sets nome as the nome variable of Curso
     * @param nome
     */
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
    
    //<editor-fold defaultstate="collapsed" desc="void writeListaDisciplinasToLIST()">
    /**
     * Writes all instances of Disciplina to a predefined list file.
     */
    public void writeListaDisciplinasToLIST(){
        int listados = listDisciplinas();
        
        if(listados == 0){
            return;
        }
        
        String escolha;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Deseja guardar esta lista em ficheiro? [Y/YES | N/NO]");
            escolha = scan.nextLine();
            if(!(escolha.equalsIgnoreCase("Y") || escolha.equalsIgnoreCase("N") 
                    || escolha.equalsIgnoreCase("YES") || escolha.equalsIgnoreCase("NO"))){
            
                System.out.println("Insercao invalida");
            }
            else if(escolha.equalsIgnoreCase("Y") || escolha.equalsIgnoreCase("YES")){
                System.out.println("Writing File...");
                break;
            }
            else{
                System.out.println("Returning to menu...");
                return;
            }
        }
        
        String foldername = "_Dados";
        File pasta = new File(foldername);
        if(!pasta.exists()){
            pasta.mkdir();
        }
        else if(!pasta.isDirectory()){
            pasta.mkdir();
        }
        
        
        String filename = "ListaDisciplinas_" + this.getNome();
        
        
        filename = foldername.concat("/" + filename +".list");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filename));
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        
        String escreve;
        int count = 0;
        
        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina get = disciplinas.get(i);
            escreve = get.toString();
            try {
                bw.write(escreve, 0, escreve.length());
                bw.write('\n');
                count++;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
          
        }
        
        try {
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        
        System.out.println("Escreveu " + count+ " disciplinas de " + disciplinas.size() + " para o ficheiro "+ filename);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ArrayList<Curso> getDisciplinas()">
/**
 * Returns the disciplinas ArrayList
 * @return disciplinas ArrayList (Disciplina)
 */
public ArrayList<Disciplina> getDisciplinas(){
    return this.disciplinas;
} //</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Curso getDisciplinas(int index)">
/**
 * Returns the instance of Disciplina in ArrayList disciplinas at index "index"
 * @param index
 * @return Disciplina "index" of ArrayList disciplinas
 */
public Disciplina getDisciplina(int index){
    Disciplina novo;
    
    if(index > this.disciplinas.size()){
        return null;
    }
    
    novo = disciplinas.get(index);
    
    return novo;
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="int escolheDisciplina()">
/**
 * Allows the user to search for a Disciplina in ArrayList disciplinas
 * @return the index of the chosen Disciplina
 */
public int escolheDisciplina(){
    Scanner scan = new Scanner(System.in);
    int escolha;
    int list_size = listDisciplinas();
    
    if(list_size == 0){
        System.out.println("Nao existem disciplinas");
        return -1;
    }
    
    while(true){
        System.out.println("Insira um inteiro entre 0 e " + list_size);
        while(!scan.hasNextInt()){
            System.out.println("Insercao invalida! Insira um inteiro entre 0 e " + list_size);
            scan.nextLine();
        }
        escolha = scan.nextInt();
        if(escolha >= 0 && escolha <= list_size){
            break;
        }
    }
    return escolha;
}
//</editor-fold>
}