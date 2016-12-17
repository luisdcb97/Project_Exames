package project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

abstract class Exame implements Serializable{
    private static final long serialVersionUID = 506L;
	
    protected ArrayList<Docente> vigilantes = new ArrayList<Docente>();
    protected ArrayList<NaoDocente> naodocentes = new ArrayList<NaoDocente>();
    protected ArrayList<Double> notas = new ArrayList<Double>();
    protected ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    protected Sala sala;
    protected Docente docenteresponsavel;
    protected Date data;
    protected int duration;
	
    public Exame(Docente responsavel, Sala local, Date hora, int tempo){
        
    }
        
        
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
    
    public ArrayList<Double> getNotas() {
        return this.notas;
    }

    protected boolean checkDone(){
        if( this.notas.size() > 0){
            System.out.println("Este Exame ja foi realizado!!!\nNao e possivel altera-lo");
            return true;
        }
        return false;
    }
    
    //<editor-fold defaultstate="collapsed" desc="boolean isAssociatedAluno(Aluno person)">
    public boolean isAssociatedAluno(Aluno person){
        
        for (int i = 0; i < alunos.size(); i++) {
            Aluno get = alunos.get(i);
            if( get.getNum() == person.getNum()){
                return true;
            }
        }
        
        
        return false;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="boolean isAssociatedDocente(Docente person)">
    public boolean isAssociatedDocente(Docente person){
        if(person.getMecano() == getDocenteresponsavel().getMecano()){
            return true;
        }
        
        for (int i = 0; i < vigilantes.size(); i++) {
            Docente get = vigilantes.get(i);
            if(person.getMecano() == get.getMecano()){
                return true;
            }

        }
        
        return false;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="boolean isAssociatedNaoDocente(NaoDocente person)">
    public boolean isAssociatedNaoDocente(NaoDocente person){
        for (int i = 0; i < naodocentes.size(); i++) {
            NaoDocente get = naodocentes.get(i);
            if(person.getMecano() == get.getMecano()){
                return true;
            }

        }
        
        return false;
    }
//</editor-fold>
}