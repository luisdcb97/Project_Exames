package project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

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
    	int tipo,dia,mes,ano,hora,minuto,tempo,docente;
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
    	//data = checkArguments(dia, mes, ano, hora, minuto);
    	
    		
    		//DD/MM/YYYY/H/MIN
    		//Check if valid
    		
    		//calculate duration
    		
    		System.out.println("Escolha uma sala");
    		
    		//Check if valid
    		
    		//if occupied, repeat process
    		
    		//else
    		
    		//List docentes
    		
    	System.out.println("Escolha o Docente que deseja ser o responsavel do exame");
            
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
        
        switch(tipo) {
        	case 1:
        	//	ExameNormal novo = new ExameNormal(departamento.getPessoa("docente",docente),Sala sala, date data, tempo);
        		break;
        	case 2:
        	//	ExameEspecial novo = new ExameEspecial(departamento.getPessoa("docente",docente),Sala sala, date data, tempo);
        		break;
        	case 3:
        	//	ExameRecurso novo = new ExameRecurso(departamento.getPessoa("docente",docente),Sala sala, date data, tempo);
        		break;
        }
      //  exames.add(novo);
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
}

