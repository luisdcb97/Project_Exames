package project;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Disciplina implements Serializable{
    private static final long serialVersionUID = 504L;
    
    private String name;
    private Docente docenteresponsavel;
    ArrayList<Docente> docentes = new ArrayList<Docente>();
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    ArrayList<Exame> exames = new ArrayList<Exame>();
    
    // <editor-fold defaultstate="collapsed" desc="Color variables">
    // final makes the value unchangeable
    // static means all instances share the same variable instead of creating a copy for themselves
    // \n funciona como ANSI_RESET
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    
    private static final String ANSI_BLACK_BKG = "\u001B[40m";
    private static final String ANSI_RED_BKG = "\u001B[41m";
    private static final String ANSI_GREEN_BKG = "\u001B[42m";
    private static final String ANSI_YELLOW_BKG = "\u001B[43m";
    private static final String ANSI_BLUE_BKG = "\u001B[44m";
    private static final String ANSI_PURPLE_BKG = "\u001B[45m";
    private static final String ANSI_CYAN_BKG = "\u001B[46m";
    private static final String ANSI_WHITE_BKG = "\u001B[47m";
    //</editor-fold>


    public Disciplina(String nome, Docente responsavel){
        this.name = nome;
        this.docenteresponsavel = responsavel;
        this.docentes.add(responsavel);
    }
    

    //<editor-fold defaultstate="collapsed" desc="int listExams(String classe)">
    
    //Not working properly!
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
        if(exames.size() ==0) {
        	System.out.println("Nao existem exames");
        	return 0;
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

    //<editor-fold defaultstate="collapsed" desc="int listExamsOfPessoa(Pessoa person)">
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
    
  //<editor-fold defaultstate="collapsed" desc="void selectExame()">
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
                System.out.println("Insira o numero do sala[0-" +(count)+"]:");
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
    		//Check if valid
    		
    		//if occupied, repeat process
    		
    		//else
            
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
    public void removeExame(){
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
            return;
        }
        
        int escolha;
        while(true){
            System.out.println("Insira a exame a remover[0-" +count+"]:");
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
            System.out.println("A cancelar remocao de exame...");
            return;
        }
        
        exames.remove(escolha-1);
        System.out.println("Exame removida!");
    }
//</editor-fold>

 // <editor-fold defaultstate="collapsed" desc="checkArguments(int *5)">
    private int[] checkArguments(int day, int mon, int year, int hour, int min){
        int vec[] = {day,mon,year,hour,min};
        Scanner scan = new Scanner(System.in);
        
        if(day < 1 || day > 31){
            String str = "";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "O valor inserido para dia do exame ";
            str += ANSI_CYAN + "[" + day + "]";
            str += ANSI_WHITE + " e invalido\n";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "Insira um novo valor:\n"+ ANSI_RESET;
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 1 e 31");
                    scan.nextLine();
                }
                vec[0] = scan.nextInt();
            } while(vec[0] < 1 || vec[0] > 31);
            
            System.out.println("Antigo valor: " + ANSI_RED + day + ANSI_RESET);
            System.out.println("\nNovo valor: " + ANSI_GREEN + vec[0] + ANSI_RESET);
        }
        if(mon < 1 || mon > 12){
            String str = "";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "O valor inserido para mes do exame ";
            str += ANSI_CYAN + "[" + mon + "]";
            str += ANSI_WHITE + " e invalido\n";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "Insira um novo valor:\n"+ ANSI_RESET;
            
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 1 e 12");
                    scan.nextLine();
                }
                vec[1] = scan.nextInt();
            } while(vec[1] < 1 || vec[1] > 12);

            System.out.println("Antigo valor: " + ANSI_RED + mon + ANSI_RESET);
            System.out.println("Novo valor: " + ANSI_GREEN + vec[1] + ANSI_RESET);
        }
        if(year < 1 ){
            String str = "";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "O valor inserido para ano do exame ";
            str += ANSI_CYAN + "[" + year + "]";
            str += ANSI_WHITE + " e invalido\n";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "Insira um novo valor:\n"+ ANSI_RESET;
            
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro maior que 1");
                    scan.nextLine();
                }
                vec[2] = scan.nextInt();
            } while(vec[2] < 1 );

            System.out.println("Antigo valor: " + ANSI_RED + year + ANSI_RESET);
            System.out.println("Novo valor: " + ANSI_GREEN + vec[2] + ANSI_RESET);
        }
        if(hour < 0 || hour > 23 ){
            String str = "";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "O valor inserido para hora do exame ";
            str += ANSI_CYAN + "[" + hour + "]";
            str += ANSI_WHITE + " e invalido\n";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "Insira um novo valor:\n"+ ANSI_RESET;
            
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 0 e 23");
                    scan.nextLine();
                }
                vec[3] = scan.nextInt();
            } while(vec[3] < 0 || vec[3] > 23 );

            System.out.println("Antigo valor: " + ANSI_RED + hour + ANSI_RESET);
            System.out.println("Novo valor: " + ANSI_GREEN + vec[3] + ANSI_RESET);
        }
        if(min < 0 || min > 59 ){
            String str = "";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "O valor inserido para minuto do exame ";
            str += ANSI_CYAN + "[" + min + "]";
            str += ANSI_WHITE + " e invalido\n";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "Insira um novo valor:\n"+ ANSI_RESET;
            
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 0 e 59");
                    scan.nextLine();
                }
                vec[4] = scan.nextInt();
            } while(vec[4] < 0 || vec[4] > 59);

            System.out.println("Antigo valor: " + ANSI_RED + min + ANSI_RESET);
            System.out.println("Novo valor: " + ANSI_GREEN + vec[4] + ANSI_RESET);
        }
        return vec;
    }// </editor-fold>
}

