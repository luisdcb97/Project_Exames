package project;

import java.io.Serializable;
import java.util.ArrayList;

public class Disciplina implements Serializable{
    private static final long serialVersionUID = 504L;
    
    private String name;
    private Docente docenteresponsavel;
    ArrayList<Docente> docentes = new ArrayList<Docente>();
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    ArrayList<Exame> exames = new ArrayList<Exame>();


    public Disciplina(String nome, Docente responsavel){
        this.name = nome;
        this.docenteresponsavel = responsavel;
        this.docentes.add(responsavel);
    }

    public void listExams() {
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
            System.out.println(normal.get(i).getData());
        }
        for(int i = 0;i<recurso.size();i++) {
            System.out.println(recurso.get(i).getData());
        }
        for(int i = 0;i<especial.size();i++) {
            System.out.println(especial.get(i).getData());
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

    @Override
    public String toString() {
        String str = "";
        str += this.name + "\t";
        str += this.docenteresponsavel.getName() + "\t";
        str += this.docenteresponsavel.getEmail()+ "\t";
        str += this.docentes.size() + "\t";
        str += this.alunos.size() + "\t";
        str += this.exames.size() + "\t";
        return str;
    }
    
    
}
