package project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Exame is the abstract base class for all exams to be managed by the application
 * 
 * @author Kwinten Jacobs
 * @author Luis David
 * @version 1.0
 * 
 * @see project.ExameNormal
 * @see project.ExameRecurso
 * @see project.ExameEspecial
 * 
 * @since 1.0
 */
public abstract class Exame implements Serializable{
    /**
    * Defines the <code>serialVersionUID</code> of this Exame to prevent
    * errors when reading Object Files after altering class methods or 
    * when using different compilers
    * 
    * @see java.io.Serializable
    */
    private static final long serialVersionUID = 506L;
	
    protected ArrayList<Docente> vigilantes = new ArrayList<Docente>();
    protected ArrayList<NaoDocente> naodocentes = new ArrayList<NaoDocente>();
    protected ArrayList<Double> notas = new ArrayList<Double>();
    protected ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    protected Sala sala;
    protected Docente docenteresponsavel;
    protected Date data;
    protected int duration;

    /**
     * Constructs an <code><b>Exame</b></code> object and initializes it so that
     * it represents an exam overseen by <code><b>responsavel</b></code>
     * and taking place at <code><b>hora</b></code> for <code><b>tempo</b></code> minutes in
     *<code><b>{@link project.Sala}</b></code> <code><b>local</b></code>
     * 
     * @param responsavel the <code><b>{@link project.Docente}</b></code> which oversees the exam 
     * @param local the <code><b>{@link project.Sala}</b></code> where the exam takes place
     * @param hora  the <code><b>{@link java.util.Date}</b></code> the exam begins at
     * @param tempo the time (in minutes) the exam lasts
     * 
     * @see project.Docente
     * @see project.Sala
     * @see java.util.Date
     * 
     * @since 1.0
     */
    public Exame(Docente responsavel, Sala local, Date hora, int tempo){
        
    }
        
    /**
     * Returns the <code><b>Docente</b></code> responsible for the execution of this exam
     * 
     * @return the <code><b>{@link project.Docente}</b></code> overseeing this exam
     * @see project.Docente
     * @since 1.0
     */
    public Docente getDocenteresponsavel() {
        return docenteresponsavel;
    }
        
    /**
     * Changes the <code><b>Docente</b></code> responsible for the execution of this exam
     * 
     * @param docenteresponsavel the <code><b>{@link project.Docente}</b></code>
     * to be made responsible for this exam
     * @see project.Docente
     * @since 1.0
     */
    public void setDocenteresponsavel(Docente docenteresponsavel) {
            this.docenteresponsavel = docenteresponsavel;
    }
    
    /**
     * Generates random values between 0 and 20 for each <code><b>Aluno</b></code>
     * enrolled in this exam which will represent that students grade
     * 
     * @see project.Aluno
     * @since 1.0
     */
    public void createNotas() {
        for(int i = 0; i < alunos.size();i++) {
            double grade = (int) (Math.random()*21);
            notas.add(grade);
        }
    }
    
    /**
     * Outputs to the console all students enrolled in this exam
     * 
     * @see project.Aluno
     * @since 1.0
    */
    public void listAlunos() {
        for(int i = 0;i<alunos.size();i++) {
            System.out.println(alunos.get(i).getName());
        }
    }
    
    /**
     * Outputs to the console all employees associated with this exam
     * in the following order:
     * 
     * <ol>
     *  <li>Teacher overseeing this exam</li>
     *  <li>Teachers watching over this exam</li>
     *  <li>Clerks assisting this exam</li>
     * </ol>
     * 
     * @see project.Docente
     * @see project.NaoDocente
     * @since 1.0
    */
    public void listFunctionaros() {
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
    
    /**
     * Outputs to the console each aluno (and his grades) that is enrolled
     * in this exam
     * 
     * <p>If this exam has not yet been graded it outputs to the console
     * an information message and returns to calling method</p>
     * 
     * @since 1.0
     */
    public void listNotas() {
        if(notas.size() <= 0){
            System.out.println("This exam has not been graded yet");
            return;
        }
        
        for(int i = 0;i<alunos.size();i++) {
            System.out.print("Aluno : "+alunos.get(i).getName()+" | Nota: "+notas.get(i));
        }
    }

    public abstract void addAluno(Aluno a);

    /**
     * Returns the date at which this exam will be performed
     * 
     * @return the date of this exam
     * @see java.util.Date
     * @since 1.0
     */
    public Date getData() {
        return data;
    }

    /**
     * Changes the date of this exam to <code><b>data</b></code> 
     * 
     * @param data the date in which the exam will be performed
     * @see java.util.Date
     * @since 1.0
     */
    public void setData(Date data) {
        this.data = data;
    }
    
    /**
     * Return a list of student's grades of this exam
     * 
     * @return an <code><b>ArrayList</b></code> containing all the student's grades 
     * @see java.util.ArrayList
     * @since 1.0
     */
    public ArrayList<Double> getNotas() {
        return this.notas;
    }

    /**
     * Checks wether this exam has been graded and is therefore unalterable
     * 
     * @return true if and only if there is at least one grade
     * @since 1.0
     */
    protected boolean checkDone(){
        if( this.notas.size() > 0){
            System.out.println("Este Exame ja foi realizado!!!\nNao e possivel altera-lo");
            return true;
        }
        return false;
    }
    
    //<editor-fold defaultstate="collapsed" desc="boolean isAssociatedAluno(Aluno person)">
    /**
     * Checks wether or not an <code><b>Aluno</b></code> is enrolled in this exam
     * 
     * @param student the student to verify if is enrolled in this exam
     * @return true if and only if student is enrolled in this exam
     * @see project.Aluno
     * @since 1.0
     */
    public boolean isAssociatedAluno(Aluno student){
        
        for (int i = 0; i < alunos.size(); i++) {
            Aluno get = alunos.get(i);
            if( get.getNum() == student.getNum()){
                return true;
            }
        }
        
        
        return false;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="boolean isAssociatedDocente(Docente person)">
    /**
     * Checks wether or not a <code><b>Docente</b></code> is overseeing this exam as its
     * responsible or as a vigilant
     * 
     * @param dc the teacher to verify if is associated with this exam
     * @return true if teacher is responsible for this exam or is a vigilant in it
     * @see project.Docente
     * @since 1.0
     */
    public boolean isAssociatedDocente(Docente dc){
        if(dc.getMecano() == getDocenteresponsavel().getMecano()){
            return true;
        }
        
        for (int i = 0; i < vigilantes.size(); i++) {
            Docente get = vigilantes.get(i);
            if(dc.getMecano() == get.getMecano()){
                return true;
            }

        }
        
        return false;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="boolean isAssociatedNaoDocente(NaoDocente person)">
    /**
     * Checks wether or not a <code><b>NaoDocente</b></code> is a vigilant in
     * this exam
     * 
     * @param ndc the clerk to verify if is associated with this exam
     * @return true if and only if clerk is a vigilant in this exam
     * @see project.NaoDocente
     * @since 1.0
     */
    public boolean isAssociatedNaoDocente(NaoDocente ndc){
        for (int i = 0; i < naodocentes.size(); i++) {
            NaoDocente get = naodocentes.get(i);
            if(ndc.getMecano() == get.getMecano()){
                return true;
            }

        }
        
        return false;
    }
//</editor-fold>
}