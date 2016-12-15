/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis David
 */
public class Dei {
    private static final long serialVersionUID = 503L;
    
    private ArrayList<Curso> cursos;
    private ArrayList<Pessoa> pessoa;
    private ArrayList<Sala> salas;

    public Dei(){
        this.cursos = new ArrayList<>();
        this.pessoa = new ArrayList<>();
        this.salas = new ArrayList<>();
    }
    
    public void listAllFunctionarios() {
        ArrayList<Functionario> lista = new ArrayList<>();
        
        for(int i = 0;i<pessoa.size();i++) {
            Pessoa pes = pessoa.get(i);
            if(pes.getClass() != Aluno.class) {
                Functionario func = (Functionario) pes;
                lista.add(func);
            }
        }
        
        if(lista.isEmpty()){
            System.out.println("\nNo funcionarios to list\n");
        }
        else{
            System.out.println("\nListing all funcionarios");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
            }
            System.out.println("\n End of list\n");
            
        }
        
        
    }
    
    void listExamsofFunctionario(){

        //Ask for index of functionario (index given is (index -1) of arraylist
    }
    
    

    //<editor-fold defaultstate="collapsed" desc="void createPessoa(String classe)">
    public void createPessoa(String classe){
        String novo_nome;
        String novo_email;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Insira o nome da nova pessoa:");
        novo_nome = scan.nextLine();
        
        while (true) {
            System.out.println("Insira o email da nova pessoa[(20 carateres) + @student.uc.pt]:");
            novo_email = scan.nextLine();
            if(novo_email.length() > 0 && novo_email.length()<20){
                novo_email += "@student.uc.pt";
                break;
            }
            System.out.println("Email invalido");
            
        }
        
        // <editor-fold defaultstate="collapsed" desc="criar Aluno">
        if(classe.equalsIgnoreCase("aluno")){
            int novo_numero;
            boolean existe;
            
            while (true) {
                System.out.println("Insira o numero de estudante do Aluno[entre 1990000000 e 2016000000]:");
                
                while(!scan.hasNextInt()){
                    System.out.println("Tem de inserir um numero inteiro");
                    scan.nextLine();
                }
                
                novo_numero = scan.nextInt();
                scan.nextLine();
                
                if( novo_numero < 1990000000 || novo_numero > 2016000000){
                    System.out.println("Numero invalido");
                    continue;
                }
                
                existe = false;
                for (int i = 0; i < pessoa.size(); i++) {
                    Pessoa get = pessoa.get(i);
                    if(get.getClass() == Aluno.class){
                        Aluno al = (Aluno) get;
                        if(novo_numero == al.getNum()){
                            existe = true;
                            break;
                        }
                    }   
                }
                
                if(existe){
                    System.out.println("O numero de estudante " + novo_numero + " ja esta ocupado"); 
                }
                else{
                    break;
                }
            }
            
            
            Aluno novo = new Aluno(novo_nome, novo_email, novo_numero);
            this.pessoa.add(novo);
            return;
            
        } //</editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="numero mecanografico">
        int novo_mecano;
        boolean exist;
        
        while (true) {
            System.out.println("Insira o numero mecanografico[9 digitos]:");
            while (!scan.hasNextInt()) {
                System.out.println("Tem de inserir um numero inteiro");
                scan.nextLine();
            }
                
            novo_mecano = scan.nextInt();
            scan.nextLine();
            
            if(novo_mecano < 0 || novo_mecano > 999999999){
                System.out.println("Numero invalido");
                continue;
            }
            
            exist = false;
            for (int i = 0; i < pessoa.size(); i++) {
                Pessoa get = pessoa.get(i);
                if(get.getClass() != Aluno.class){
                    Functionario func = (Functionario) get;
                    if(novo_mecano == func.getMecano()){
                        exist = true;
                        break;
                    }
                }   
            }
            
            if (exist) {
                System.out.println("Ja existe um funcionario com o numero " + novo_mecano);
            }
            else{
                break;
            }
            
        } //</editor-fold>
        
        String nova_categ;
        // <editor-fold defaultstate="collapsed" desc="criar docente">
        if(classe.equalsIgnoreCase("docente")){
            while (true) {
                System.out.println("Insira a categoria do novo Docente");
                System.out.println("asi/Assistente | aux/Auxiliar | aso/Associado | cat/Catedratico");
                nova_categ = scan.nextLine();
                if(nova_categ.equals("Assistente") || nova_categ.equals("Auxiliar") 
                        || nova_categ.equals("Associado") || nova_categ.equals("Catedratico")){
                    
                    break;
                }
                else if(nova_categ.equals("asi")){
                    nova_categ = "Assistente";
                    break;
                }
                else if(nova_categ.equals("aso")){
                    nova_categ = "Associado";
                    break;
                }
                else if(nova_categ.equals("aux")){
                    nova_categ = "Auxiliar";
                    break;
                }
                else if(nova_categ.equals("cat")){
                    nova_categ = "Catedratico";
                    break;
                }
                
                System.out.println("Insercao Invalida!!!");
            }
            
            String nova_area;
            
            while (true) {
                System.out.println("Insira a area de investigacao do novo Docente");
                System.out.println("SI/Sistemas de Informacao | CT/Comunicacao e Telematica | ES/Engenharia de Software");
                nova_area = scan.nextLine();
                if(nova_area.equals("Sistemas de Informacao") || nova_area.equals("Comunicacao e Telematica") 
                        || nova_area.equals("Engenharia de Software")){
                    
                    break;
                }
                else if(nova_area.equals("ES")){
                    nova_area = "Engenharia de Software";
                    break;
                }
                else if(nova_area.equals("CT")){
                    nova_area = "Comunicacao e Telematica";
                    break;
                }
                else if(nova_area.equals("SI")){
                    nova_area = "Sistemas de Informacao";
                    break;
                }
                
                System.out.println("Insercao Invalida!!!");
            }
            
            Docente dc = new Docente(novo_nome, novo_email, novo_mecano, nova_categ, nova_area);
            pessoa.add(dc);
            
        } // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="criar nao docente">
        else if(classe.equalsIgnoreCase("nao docente")){
            while (true) {
                System.out.println("Insira a categoria do novo Nao-Docente");
                System.out.println("AO/Assistente Operacional | AT/Assistente Tecnico | EI/Especialista de Informatica");
                System.out.println("TI/Tecnico de Informatica | TS/Tecnico Superior");
                nova_categ = scan.nextLine();
                if(nova_categ.equals("Assistente Operacional") || nova_categ.equals("Assistente Tecnico") 
                        || nova_categ.equals("Especialista de Informatica") || nova_categ.equals("Tecnico de Informatica")
                        || nova_categ.equals("Tecnico Superior")){
                    
                    break;
                }
                else if(nova_categ.equals("AO")){
                    nova_categ = "Assistente Operacional";
                    break;
                }
                else if(nova_categ.equals("AT")){
                    nova_categ = "Assistente Tecnico";
                    break;
                }
                else if(nova_categ.equals("EI")){
                    nova_categ = "Especialista de Informatica";
                    break;
                }
                else if(nova_categ.equals("TI")){
                    nova_categ = "Tecnico de Informatica";
                    break;
                }
                else if(nova_categ.equals("TS")){
                    nova_categ = "Tecnico Superior";
                    break;
                }
                
                System.out.println("Insercao Invalida!!!");
            }
            
            String novo_cargo;
            
            while (true) {
                System.out.println("Insira a area de investigacao do novo Docente");
                System.out.println("SC/Secretaria | FN/Financeiro | AT/Apoio Técnico");
                novo_cargo = scan.nextLine();
                if(novo_cargo.equals("Secretaria") || novo_cargo.equals("Financeiro") 
                        || novo_cargo.equals("Apoio Técnico")){
                    
                    break;
                }
                else if(novo_cargo.equals("SC")){
                    novo_cargo = "Secretaria";
                    break;
                }
                else if(novo_cargo.equals("FN")){
                    novo_cargo = "Financeiro";
                    break;
                }
                else if(novo_cargo.equals("AT")){
                    novo_cargo = "Apoio Técnico";
                    break;
                }
                
                System.out.println("Insercao Invalida!!!");
            }
            
            NaoDocente ndc = new NaoDocente(novo_nome, novo_email, novo_mecano, nova_categ, novo_cargo);
            pessoa.add(ndc);
            
        } // </editor-fold>
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="void createAluno(String nome, String email, int num)">
    public void createAluno(String nome, String email, int num){
        Aluno al = new Aluno(nome, email, num);
        pessoa.add(al);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="void createDocente(String nome, String email, int num, String categ, String area)">
    public void createDocente(String nome, String email, int num, String categ, String area){
        Docente dc = new Docente(nome, email, num, categ, area);
        pessoa.add(dc);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="void createNaoDocente(String nome, String email, int num, String categ, String cargo)">
    public void createNaoDocente(String nome, String email, int num, String categ, String cargo){
        NaoDocente ndc = new NaoDocente(nome, email, num, categ, cargo);
        pessoa.add(ndc);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="int listPessoa(String classe)">
    public int listPessoa(String classe){
        int count = 0;
        
        switch (classe) {
            case "aluno":
                classe = Aluno.class.toString();
                break;
            case "docente":
                classe = Docente.class.toString();
                break;
            case "nao docente":
                classe = NaoDocente.class.toString();
                break;
            case "funcionario":
                classe = Functionario.class.toString();
                break;
            default:
                classe = Pessoa.class.toString();
        }
        
        if(pessoa.isEmpty()){
            System.out.println("Nao existem pessoas para listar");
            return 0;
        }
        
        System.out.println("\n-------------------------------\n");
        for (int i = 0; i < pessoa.size(); i++) {
            Pessoa get = pessoa.get(i);
            if(classe.equals(Pessoa.class.toString())){
                System.out.println(get);
                count++;
            }
            else if(classe.equals(Functionario.class.toString()) && get.getClass() != Aluno.class){
                System.out.println(get);
                count++;
            }
            else if(get.getClass().toString().equals(classe)){
                System.out.println(get);
                count++;
            }
            
        }
        System.out.println("\n-------------------------------\n");
        
        return count;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Pessoa getPessoa(String classe, int index)">
    public Pessoa getPessoa(String classe, int index){
        int count = 0;
        
        switch (classe) {
            case "aluno":
                classe = Aluno.class.toString();
                break;
            case "docente":
                classe = Docente.class.toString();
                break;
            case "nao docente":
                classe = NaoDocente.class.toString();
                break;
            default:
                classe = Pessoa.class.toString();
        }
        
        for (int i = 0; i < pessoa.size(); i++) {
            Pessoa get = pessoa.get(i);
            if(get.getClass().toString().equals(classe)){
                if(count == index){
                    return get;
                }
                count++;
            }
        }
        
        return null;
    }
//</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="void createCurso()">
    public void createCurso(){
        Scanner scan = new Scanner(System.in);
        String novo_nome;
        String novo_grau;
        int nova_dur;
       
        System.out.println("Insira o nome do novo curso:");
        novo_nome = scan.nextLine();
       
        while(true){
            System.out.println("Insira o grau do novo curso[ L/Licenciatura | M/Mestrado | D/Doutoramento]:");
            novo_grau = scan.nextLine();
            if(novo_grau.equals("Licenciatura") || novo_grau.equals("Mestrado") || novo_grau.equals("Doutoramento")
                    || novo_grau.equals("L") || novo_grau.equals("M") || novo_grau.equals("D")){
                break;
            }
            
            System.out.println("Insercao invalida!!!");
        }
        
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
        
        Curso novo = new Curso(novo_nome, nova_dur, novo_grau);
        
        this.cursos.add(novo);
        
        System.out.print("Curso ");
        System.out.print(novo);
        System.out.println(" " + "adicionado ao departamento");
       
    } //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="void removeCurso()">
    public void removeCurso(){
        int escolha;
        
        escolha = escolheCurso();
        
        if(escolha == -1){
            System.out.println("Nao existem cursos para remover");
            return;
        }
        else if (escolha == 0) {
            System.out.println("A cancelar remocao de curso");
            return;
        }

        Curso deleted = cursos.remove(escolha-1);
        //remove disciplinas and alunos
        
        System.out.print("Curso ");
        System.out.print(deleted);
        System.out.println(" " + "retirado do departamento");
       
    } //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="int listCursos()">
    public int listCursos(){
        if(cursos.isEmpty()){
            System.out.println("Não existem cursos para listar");
            return 0;
        }
        int count = 0;
        System.out.println("\nIndice Nome Grau Duracao");
        System.out.println("-------------------------------");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(i+1 + " " + cursos.get(i));
            count++;
        }
        System.out.println("-------------------------------\n");
        
        return count;
        
    } //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="int escolheCurso()">
    public int escolheCurso(){
        Scanner scan = new Scanner(System.in);
        int escolha;
        int list_size = listCursos();
        
        if(list_size == 0){
            System.out.println("Nao existem cursos");
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
    
    // <editor-fold defaultstate="collapsed" desc="ArrayList<Curso> getCursos()">
    public ArrayList<Curso> getCursos(){
        return this.cursos;
    } //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Curso getCurso(int index)">
    public Curso getCurso(int index){
        Curso novo;
        
        if(index > this.cursos.size()){
            return null;
        }
        
        novo = cursos.get(index);
        
        return novo;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="void setCurso(int index, Curso insere)">
    public void setCurso(int index, Curso insere){
        Curso novo;
        
        if(index > this.cursos.size()){
            return;
        }
        
        novo = cursos.set(index, insere);
        
    }
//</editor-fold>
    
    
    
    //<editor-fold defaultstate="collapsed" desc="void writePessoasToTXT()">
    public void writePessoasToTXT(){
        String foldername = "_Dados";
        File pasta = new File(foldername);
        if(!pasta.exists()){
            pasta.mkdir();
        }
        else if(!pasta.isDirectory()){
            pasta.mkdir();
        }
        
        String filename = foldername.concat("/" + "_Pessoas.txt");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filename));
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        
        String escreve;
        int count = 0;
        
        for (int i = 0; i < pessoa.size(); i++) {
            Pessoa get = pessoa.get(i);
            escreve = get.toText();
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
        
        System.out.println("Escreveu " + count+ " pessoas de " + pessoa.size() + " para o ficheiro "+ filename);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="void readPessoasFromTXT()">
    public void readPessoasFromTXT(){
        String foldername = "_Dados";
        File pasta = new File(foldername);
        if(!pasta.exists() || !pasta.isDirectory()){
            System.out.println("A pasta nao " + foldername + " existe");
        }
        
        String filename = foldername.concat("/" + "_Pessoas.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        
        String lido;
        int count = 0;
        int lines = 0;
        StringTokenizer tok;
        String novo_nome;
        String novo_email;
        int novo_num;
        String novo_categ;
        String novo_area;
        
        while(true){
            try {
                lido = br.readLine();
                lines++;
            } catch (IOException ex) {
                ex.printStackTrace();
                continue;
            }
            
            if(lido == null){
                break;
            }
            
            tok = new StringTokenizer(lido,"|");
            
            if(!tok.hasMoreTokens()){
                continue;
            }
            
            novo_nome = tok.nextToken();
            
            
            if(!tok.hasMoreTokens()){
                continue;
            }
            
            novo_email = tok.nextToken();
            
            if(!tok.hasMoreTokens()){
                continue;
            }
            
            novo_categ = tok.nextToken();
            try{
               novo_num = Integer.parseInt(novo_categ);  
            } catch(NumberFormatException ex){
                ex.printStackTrace();
                continue;
            }
            
            if(!tok.hasMoreTokens()){
                createAluno(novo_nome, novo_email, novo_num);
                count++;
                continue;
            }
            
            novo_categ = tok.nextToken();
            
            if(!tok.hasMoreTokens()){
                continue;
            }
            
            novo_area = tok.nextToken();
            
            switch (novo_categ) {
                case "Assistente Operacional":
                case "Assistente Tecnico":
                case "Tecnico Superior":
                case "Tecnico de Informatica":
                case "Especialista de Informatica":
                    createNaoDocente(novo_nome, novo_email, novo_num, novo_categ, novo_area);
                    count++;
                    break;
                default:
                    createDocente(novo_nome, novo_email, novo_num, novo_categ, novo_area);
                    count++;
            }
        }
        
        try {
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        
        System.out.println("Leu " + count+ " pessoas de " + pessoa.size() + " do ficheiro "+ filename);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="void writeCursosToOBJ()">
    public void writeCursosToOBJ(){
        String foldername = "_Dados";
        File pasta = new File(foldername);
        if(!pasta.exists()){
            pasta.mkdir();
        }
        else if(!pasta.isDirectory()){
            pasta.mkdir();
        }
        
        
        String filename = foldername.concat("/" + "_Cursos.obj");
        ObjectOutputStream oos = null;
        
        try{
            oos = new ObjectOutputStream(new FileOutputStream(filename));
        } catch (IOException ex) {
            System.out.println("Erro a abrir ficheiro de cursos");
            ex.printStackTrace();
            return;
        }
        
        try {
            oos.writeObject(this.cursos);
        } catch (IOException ex) {
            System.out.println("Erro a escrever cursos");
            ex.printStackTrace();
            return;
        }
        
        try {
            oos.close();
        } catch (IOException ex) {
            System.out.println("Erro a fechar ficheiro de cursos");
            ex.printStackTrace();
            return;
        }
        
        System.out.println("Escreveu ArrayList de cursos para o ficheiro " +filename);
        
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="void readCursosToOBJ()">
    public void readCursosToOBJ(){
        String foldername = "_Dados";
        File pasta = new File(foldername);
        if(!pasta.exists() || !pasta.isDirectory()){
            System.out.println("A pasta nao " + foldername + " existe");
        }
        
        String filename = foldername.concat("/" + "_Cursos.obj");
        ObjectInputStream ois = null;
        
        try{
            ois = new ObjectInputStream(new FileInputStream(filename));
        } catch (IOException ex) {
            System.out.println("Erro a abrir ficheiro de cursos");
            ex.printStackTrace();
            return;
        }
        
        try {
            cursos = (ArrayList<Curso>) ois.readObject();
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro de cursos [IO]");
            ex.printStackTrace();
            return;
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a ler ficheiro de cursos [CNF]");
            ex.printStackTrace();
            return;
        } 
        
        try {
            ois.close();
        } catch (IOException ex) {
            System.out.println("Erro a fechar ficheiro de cursos");
            ex.printStackTrace();
            return;
        }
        
        System.out.println("Leu ArrayList de cursos do ficheiro " +filename);
        
    }
//</editor-fold>
}
