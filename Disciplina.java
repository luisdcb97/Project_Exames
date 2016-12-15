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
    

    //<editor-fold defaultstate="collapsed" desc="int listExams(String classe)">
    public int listExams(String classe) {
        switch (classe) {
            case "normal":
                classe = ExameNormal.class.toString();
                break;
            case "recurso":
                classe = ExameRecurso.class.toString();
                break;
            case "especial":
                classe = ExameEspecial.class.toString();
                break;
            default:
                classe = Exame.class.toString();
        }
        
        int count = 0;
        for(int i = 0; i < exames.size(); i++) {
            Exame get = exames.get(i);
            if(!Exame.class.toString().equals(classe)) {
                // Print specific exams
                if(!get.getClass().toString().equals(classe)){
                    continue;
                }
            }
            System.out.println(get);
            count++;
        }
        return count;
    }
//</editor-fold>

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
