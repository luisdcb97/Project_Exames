package project;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Kwinten Jacobs
 * @author Luis David
 */
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
    
    /**
     * Returns a list of all Exams present of the given class.
     * The classe argument must be of type normal, recurso or especial.
     * This method will write a "No exams exist" message to the console if no exams are present to be listed.
     * 
     * @param classe the type of exam requested to be listed
     * @return A list of all exams of type classe
     */
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
        //Checking if any exams exist
        if(exames.isEmpty()) {
        	System.out.println("Nao existem exames");
        	return 0;
        }
        System.out.println("\n------------------- A listar exames da epoca " +classe+" -----------------\n");
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
        System.out.println("\n---------------------------------------\n");
        return count;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="int listExamsOfPessoa(Pessoa person)">
    /**
     * 
     * @param person
     * @param prefix
     * @return
     */
    public int listExamsOfPessoa(Pessoa person, String prefix){
        prefix = prefix.concat("[" + this.getName() + "] ");
        String print;
        int count = 0;
        
        for (int i = 0; i < exames.size(); i++) {
            Exame obtido = exames.get(i);
            print = "";
            
            if(person.getClass() == Aluno.class){
                Aluno al = (Aluno) person;
                if (obtido.isAssociatedAluno(al)){
                    print = prefix + obtido.toString();
                    if(obtido.getNotas().size() > 0){
                        print += obtido.getNotas().get(i);
                    }
                    count++;
                }
            }
            else if(person.getClass() == Docente.class){
                Docente dc = (Docente) person;
                if(obtido.isAssociatedDocente(dc)){
                    print = prefix + obtido.toString();
                    count++;
                }
            }
            else if(person.getClass() == NaoDocente.class){
                NaoDocente ndc = (NaoDocente) person;
                if(obtido.isAssociatedNaoDocente(ndc)){
                    print = prefix + obtido.toString();
                    count++;
                }
            }
            
            System.out.println(print);
            
        }
        return count;
    }
//</editor-fold>
    
    
    /**
     * Returns the name variable of the instance of Disciplina
     * @return Name variable of Disciplina as String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name variable of the instance of Disciplina
     * @param name Name variable to be set for Disciplina 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the Docente responsible for the Disciplina
     * @return Instance of class Docente
     */
    public Docente getDocenteresponsavel() {
        return docenteresponsavel;
    }

    /**
     * Sets docenteresponsavel as the docenteresponsavel variable of Disciplina
     * @param docenteresponsavel The variable to be set for Disciplina
     */
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
    
  //<editor-fold defaultstate="collapsed" desc="void selectExame()">
    /**
     * Requests user input to determine the exam type from the user
     * @return An integer representing the exam type chosen.
     */
    public int selectExame(){
        Scanner scan = new Scanner(System.in);
        String tipo;
        
        
        while(true) {
        	System.out.println("Insira o tipo do novo exame [normal/especial/recurso] :");
            tipo = scan.nextLine();
        	switch(tipo.toLowerCase()) {
        		case "normal":
        			return 1;
        		case "especial":
        			return 2;
        		case "recurso":
        			return 3;
        		default:
        			System.out.println("Insercao invalida");
        	}
        }
    }
  //</editor-fold>      
    
    /**
     * Creates a new instance of Exame in disciplina
     * @param departamento The instance of DEI that encapsulates the instance of disciplina
     * @param disciplina The disciplina which needs to contain the Exame
     */
    public void createExame(DEI departamento, Disciplina disciplina) {
    	Scanner scan = new Scanner(System.in);
    	int tipo,dia,mes,ano,hora,minuto,tempo,docente,sala;
    	tipo = selectExame();
    	
    	while(true) {
    		System.out.println("Insira o ano do exame [YYYY]");
    		
    		while(!scan.hasNextInt()){
                System.out.println("Insercao invalida!\nInsira um inteiro:");
                scan.nextLine();
            }
    		
    		ano = scan.nextInt();
    		
    		if(ano <1000 || ano > 9999) {
    			System.out.println("Insercao invalida");
    		} else {
    			break;
    		}
    	}
    	while(true) {
    		System.out.println("Insira o mes do exame [1-12]");
    		
    		while(!scan.hasNextInt()){
                System.out.println("Insercao invalida!\nInsira um inteiro:");
                scan.nextLine();
            }
    		
    		mes = scan.nextInt();
    		
    		if(mes<1 || mes > 12) {
    			System.out.println("Insercao invalida");
    		}else {
    			break;
    		}
    	}
    	while(true) {
    		System.out.println("Insira o dia do exame");
    		int valid =0;
    		
    		while(!scan.hasNextInt()){
                System.out.println("Insercao invalida!\nInsira um inteiro:");
                scan.nextLine();
            }
    		dia = scan.nextInt();
    		
    		switch(mes) {
    		case 1:
    			if(dia<0 || dia>31){
    				System.out.println("Insercao invalida");
    			} else {
    				valid =1;
    			}
    			break;
    		case 2:
    			if(dia<0 || dia>28){
    				System.out.println("Insercao invalida");
    			} else {
    				valid =1;
    			}
    			break;
    		case 3:
    			if(dia<0 || dia>31){
    				System.out.println("Insercao invalida");
    			}else {
    				valid =1;
    			}
    			break;
    		case 4:
    			if(dia<0 || dia>30){
    				System.out.println("Insercao invalida");
    			}else {
    				valid =1;
    			}
    			break;
    		case 5:
    			if(dia<0 || dia>31){
    				System.out.println("Insercao invalida");
    			}else {
    				valid =1;
    			}
    			break;
    		case 6:
    			if(dia<0 || dia>30){
    				System.out.println("Insercao invalida");
    			}else {
    				valid =1;
    			}
    			break;
    		case 7:
    			if(dia<0 || dia>31){
    				System.out.println("Insercao invalida");
    			}else {
    				valid =1;
    			}
    			break;
    		case 8:
    			if(dia<0 || dia>31){
    				System.out.println("Insercao invalida");
    			}else {
    				valid =1;
    			}
    			break;
    		case 9:
    			if(dia<0 || dia>30){
    				System.out.println("Insercao invalida");
    			}else {
    				valid =1;
    			}
    			break;
    		case 10:
    			if(dia<0 || dia>31){
    				System.out.println("Insercao invalida");
    			}else {
    				valid =1;
    			}
    			break;
    		case 11:
    			if(dia<0 || dia>30){
    				System.out.println("Insercao invalida");
    			}else {
    				valid =1;
    			}
    			break;
    		case 12:
    			if(dia<0 || dia>31){
    				System.out.println("Insercao invalida");
    			}else {
    				valid =1;
    			}
    			break;
    		default:
    			System.out.println("Insercao invalida");
    			break;
    		}
    	if(valid == 1) {
    		break;
    	}
    }
    	
    	while(true) {
    		System.out.println("Insira o hora do exame [0-24]");
    		
    		while(!scan.hasNextInt()){
                System.out.println("Insercao invalida!\nInsira um inteiro:");
                scan.nextLine();
            }
    		hora = scan.nextInt();
    		if(hora<0 ||hora >24) {
    			System.out.println("Insercao invalida!");
    		} else {
    			break;
    		}
    	}
    	while(true) {
    		System.out.println("Insira os minutos  do exame [" + hora+":mm] (0-59)");
    		
    		while(!scan.hasNextInt()){
                System.out.println("Insercao invalida!\nInsira um inteiro:");
                scan.nextLine();
            }
    		minuto = scan.nextInt();
    		if(minuto<0 ||minuto >59) {
    			System.out.println("Insercao invalida!");
    		} else {
    			break;
    		}
    	}
    	while(true) {
    		System.out.println("Insira o duracao do exame (minutos)");
    		while(!scan.hasNextInt()){
                System.out.println("Insercao invalida!\nInsira um inteiro:");
                scan.nextLine();
    		}
    		tempo = scan.nextInt();
    		if(tempo<0) {
    			System.out.println("Insercao invalida");
    		} else {
    			break;
    		}
    	}
    	
    	int data[];
        
        data = checkArguments(dia, mes, ano, hora, minuto);
        
        String str = "";
        str += data[0] + "-";
        str += data[1] + "-";
        str += data[2];
        str += " at ";
        str += data[3] + ":";
        str += data[4];
        
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm");
        Date temp = null;
        try {
            temp = format1.parse(str);
        } catch (ParseException ex) {
            ex.printStackTrace();
            System.out.println("Error parsing string into date");
        }
        
    		
    		int count = departamento.listSalas();
    		if(count == 0) {
    			System.out.println("Returning to previous menu");
    			return;
    		}
    		System.out.println("Escolha uma sala");
    		while(true){
                System.out.println("Insira o numero do sala[1-" +(count)+"]:");
                while (!scan.hasNextInt()) {
                    System.out.println("Insercao invalida");
                    scan.nextLine();
                }
                sala = scan.nextInt();
                if(sala>=0 && sala <= count) {
                	if(departamento.getSala(sala-1).reserveSala(temp, tempo)){
                		break;
                	} else {
                    	System.out.println("Sala is already occupied at that time");
                	}
            	} else {
            		System.out.println("Insercao invalida");
            }
    		}

            
        count = departamento.listPessoa("docente");
            
        if(count == 0){
            System.out.println("Nao existem docentes para colocar como responsaveis desta disciplina");
            System.out.println("Crie um docente no Menu de Pessoas!!!");
            return;
        } 
        while(true){
            System.out.println("Insira o Docente que deseja ser o responsavel da disciplina[0-" +(count-1)+"]:");
            while (!scan.hasNextInt()) {
                System.out.println("Insercao invalida");
                scan.nextLine();
            }
            docente = scan.nextInt();
                
            if(docente >= 0 && docente <= count){
                break;
            }
            System.out.println("Insercao invalida!!!!!!");
            if(docente ==0) {
            	System.out.println("A cancelar criacao de exame...");
            	departamento.getSala(sala-1).freeSala(temp,tempo);
            	return;
            }
        }
        
        switch(tipo) {
        	case 1:
        		ExameNormal novoNormal = new ExameNormal((Docente)departamento.getPessoa("docente",docente),departamento.getSala(sala-1), temp, tempo);
        	    exames.add(novoNormal);
        		break;
        	case 2:
        		ExameEspecial novoEspecial = new ExameEspecial((Docente)departamento.getPessoa("docente",docente),departamento.getSala(sala-1), temp, tempo);
        	    exames.add(novoEspecial);
        		break;
        	case 3:
        		ExameRecurso novoRecurso = new ExameRecurso((Docente)departamento.getPessoa("docente",docente),departamento.getSala(sala-1), temp, tempo);
        		exames.add(novoRecurso);
        		break;
        }
	    System.out.println("Exame creation succesful!");
    }
    
  //<editor-fold defaultstate="collapsed" desc="void removeExame()">
    /**
     * Requests user input to remove an exam from the exames ArrayList
     * @return Integer necessary to free the sala where the exam was (See freeSala(int slot) in the Sala class for more info)
     */
    public int removeExame(){
    	Scanner scan = new Scanner(System.in);
    	String tipo ="x";
    	while(true) {
    		
    		
    		System.out.println("Insira o tipo do exame a remover");
    		System.out.println("[1] Exame normal");
    		System.out.println("[2] Exame especial");
    		System.out.println("[3] Exame recurso");   		
    		
    		while (!scan.hasNextInt()) {
            	System.out.println("Insercao invalida");
            	scan.nextLine();
        	}
    		int input = scan.nextInt();
    		switch(input) {
    			case 1:
    				tipo = "normal";
    				break;
    			case 2:
    				tipo = "especial";
    				break;
    			case 3:
    				tipo = "recurso";
    			default:
    				System.out.println("Insercao invalida");
    		}
    		if(!tipo.equals("x")){
    			break;
    		}
    	}
		int count = listExams(tipo);
        
        if(count == 0){
            System.out.println("Nao existem exames para remover");
            return 0;
        }
        
        int escolha;
        while(true){
            System.out.println("Insira a exame a remover[1-" +count+"]:");
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
            System.out.println("Cancelling exam removal...");
            return 0;
        }
        
        exames.remove(escolha-1);
        
        System.out.println("Exame removida!");
        return escolha-1;
    }
//</editor-fold>

 // <editor-fold defaultstate="collapsed" desc="checkArguments(int *5)">
    private int[] checkArguments(int day, int mon, int year, int hour, int min){
        int vec[] = {day,mon,year,hour,min};
        Scanner scan = new Scanner(System.in);
        
        if(day < 1 || day > 31){
            String str = "";
            str += "O valor inserido para dia do exame ";
            str += "[" + day + "]";
            str += " e invalido\n";
            str += "Insira um novo valor:\n";
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 1 e 31");
                    scan.nextLine();
                }
                vec[0] = scan.nextInt();
            } while(vec[0] < 1 || vec[0] > 31);
            
            System.out.println("Antigo valor: "+day);
            System.out.println("\nNovo valor: "+vec[0]);
        }
        if(mon < 1 || mon > 12){
            String str = "";
            str += "O valor inserido para mes do exame ";
            str += "[" + mon + "]";
            str += " e invalido\n";
            str += "Insira um novo valor:\n";
            
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 1 e 12");
                    scan.nextLine();
                }
                vec[1] = scan.nextInt();
            } while(vec[1] < 1 || vec[1] > 12);

            System.out.println("Antigo valor: "+ mon);
            System.out.println("Novo valor: " +vec[1]);
        }
        if(year < 1 ){
            String str = "";
            str += "O valor inserido para ano do exame ";
            str += "[" + year + "]";
            str += " e invalido\n";
            str += "Insira um novo valor:\n";
            
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro maior que 1");
                    scan.nextLine();
                }
                vec[2] = scan.nextInt();
            } while(vec[2] < 1 );

            System.out.println("Antigo valor: "+ year);
            System.out.println("Novo valor: "+ vec[2]);
        }
        if(hour < 0 || hour > 23 ){
            String str = "";
            str += "O valor inserido para hora do exame ";
            str += "[" + hour + "]";
            str += " e invalido\n";
            str += "Insira um novo valor:\n";
            
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 0 e 23");
                    scan.nextLine();
                }
                vec[3] = scan.nextInt();
            } while(vec[3] < 0 || vec[3] > 23 );

            System.out.println("Antigo valor: "+ hour);
            System.out.println("Novo valor: "+ vec[3]);
        }
        if(min < 0 || min > 59 ){
            String str = "";
            str += "O valor inserido para minuto do exame ";
            str += "[" + min + "]";
            str += " e invalido\n";
            str += "Insira um novo valor:\n";
            
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 0 e 59");
                    scan.nextLine();
                }
                vec[4] = scan.nextInt();
            } while(vec[4] < 0 || vec[4] > 59);

            System.out.println("Antigo valor: "+ min);
            System.out.println("Novo valor: "+ vec[4]);
        }
        return vec;
    }// </editor-fold>
    
    /**
     * Allows the user to change the responsible Docente of an Exame
     * @param departamento The instance of DEI in which the Docente and Exame are present 
     */
    public void changeDocente(DEI departamento) {
    	System.out.println("Insira o tipo do exame a alterar [normal/especial/recurso]");
    	Scanner scan = new Scanner(System.in);
    	
    	int docente;
    	String tipo = scan.nextLine();
    	
    	int exam =listExams(tipo);
    	//Exams need to show a number when listed
    	System.out.println("Insira o número do exame a alterar: [0-"+exam+"]");
    			
    	int count = departamento.listPessoa("docente");
        
        if(count == 0){
            System.out.println("Nao existem docentes para colocar como responsaveis desta disciplina");
            System.out.println("Crie um docente no Menu de Pessoas!!!");
            return;
        } 
        while(true){
            System.out.println("Insira o Docente que deseja ser o responsavel da disciplina[0-" +(count-1)+"]:");
            while (!scan.hasNextInt()) {
                System.out.println("Insercao invalida");
                scan.nextLine();
            }
            docente = scan.nextInt();
                
            if(docente >= 0 && docente <= count){
                break;
            }
            System.out.println("Insercao invalida!!!!!!");
        }
        exames.get(exam).docenteresponsavel = (Docente)departamento.getPessoa("docente", count-1);
        System.out.println("Docente changed succesfully!");
    }
    
    public void addAluno(DEI departamento){
    	         Aluno student = (Aluno) departamento.escolherPessoa("aluno");
    	         
    	         if(student == null){
    	             return;
    	         }
    	         
    	         alunos.add(student);
    	         System.out.println("Aluno "+ student.getName() +" adicionado a disciplina "+ this.getName());
    	     }
    	     
    	     public void addDocente(DEI departamento){
    	         Docente teacher = (Docente) departamento.escolherPessoa("docente");
    	         
    	         if(teacher == null){
    	             return;
    	         }
    	         
    	         this.docentes.add(teacher);
    	         System.out.println("Docente "+ teacher.getName() +" adicionado a disciplina "+ this.getName());
    	     }
    	     
    	     public void listDocentes(){
    	         if(docentes.isEmpty()){
    	             System.out.println("Sem docentes para listar...");
    	             return;
    	         }
    	         System.out.println("\n--------------- Docentes da disciplina " +this.getName()+" -------------\n");
    	         for (int i = 0; i < docentes.size(); i++) {
    	             System.out.println(docentes.get(i));
    	         }
    	         System.out.println("\n-----------------------------------\n");
    	     }
    	     
    	     public void listAlunos(){
    	         if(alunos.isEmpty()){
    	             System.out.println("Sem alunos para listar...");
    	             return;
    	         }
    	         System.out.println("\n--------------- Alunos da disciplina " +this.getName()+" -------------\n");
    	         for (int i = 0; i < alunos.size(); i++) {
    	             System.out.println(alunos.get(i));
    	         }
    	         System.out.println("\n-----------------------------------\n");
    	     }
}

