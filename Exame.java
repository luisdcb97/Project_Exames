package project;

import java.util.ArrayList;
import java.util.Date;

abstract class Exame {
	
    protected ArrayList<Docente> vigilantes = new ArrayList<Docente>();
    protected ArrayList<NaoDocente> naodocentes = new ArrayList<NaoDocente>();
    protected ArrayList<Double> notas = new ArrayList<Double>();
    protected ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    protected ArrayList<Sala> sala = new ArrayList<Sala>();
    protected Docente docenteresponsavel;
    protected Date data;
    protected int duration;
	
        
        
        
    public Docente getDocenteresponsavel() {
        return docenteresponsavel;
    }
        
        
    public void setDocenteresponsavel(Docente docenteresponsavel) {
            this.docenteresponsavel = docenteresponsavel;
    }

    void createNotas() {
        for(int i = 0; i < alunos.size();i++) {
            double grade = (int) (Math.random()*21);
            notas.add(grade);
        }
    }

    void listAlunos() {
        for(int i = 0;i<alunos.size();i++) {
            System.out.println(alunos.get(i).getName());
        }
    }

    void listFunctionaros() {
        System.out.println("Docente responsavel: " + getDocenteresponsavel());
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

    protected boolean checkDone(){
        if( this.notas.size() > 0){
            System.out.println("Este Exame ja foi realizado!!!\nNao e possivel altera-lo");
            return true;
        }
        return false;
    }
        
}