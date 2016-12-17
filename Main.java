/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;


import java.util.Scanner;
/**
 * @author Kwinten Jacobs
 * @author Luis David
 */



public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DEI departamento = new DEI();
        
        departamento.readPessoasFromTXT();
        departamento.readCursosToOBJ();
        Sala sala = new Sala("kek");
    	departamento.addSala(sala);
        while(true){
            menu_main(departamento);
        }
    }  
    
    
    private static void menu_main(DEI departamento){
        int choice;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("=================== MENU PRINCIPAL =======================\n");
        System.out.println("[1] Gerir Cursos");
        System.out.println("[2] Gerir Pessoas");
        System.out.println("[0] Sair");
        System.out.println("\nInsira a sua escolha:");

        while(!scan.hasNextInt()){
            System.out.println("Insercao invalida!\nInsira um inteiro:");
            scan.nextLine();
        }
        choice = scan.nextInt();

        scan.nextLine(); // clears input

        switch (choice) {
            case 1:
                while(menu_curso(departamento) != 0);
                break;
            case 2:
                while(menu_pessoas(departamento) != 0);
                break;
            case 0:
                System.out.println("Writing to Files...");
                departamento.writePessoasToTXT();
                departamento.writeCursosToOBJ();
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Escolha Invalida! Tem de inserir um inteiro entre 0 e 11");
                System.out.println("Prima ENTER para continuar");
                scan.nextLine();
                break;
        }
        
    }
    
    private static int menu_curso(DEI departamento){
        int choice;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("=================== MENU CURSOS =======================\n");
        System.out.println("[1] Criar Curso");
        System.out.println("[2] Remover Curso");
        System.out.println("[3] Listar Cursos");
        System.out.println("[4] Gerir curso");
        System.out.println("[0] Voltar");
        System.out.println("\nInsira a sua escolha:");

        while(!scan.hasNextInt()){
            System.out.println("Insercao invalida!\nInsira um inteiro:");
            scan.nextLine();
        }
        choice = scan.nextInt();

        scan.nextLine(); // clears input

        switch (choice) {
            case 1:
                departamento.createCurso();
                break;
            case 2:
                departamento.removeCurso();
                break;
            case 3:
                departamento.writeListaCursosToLIST();
                break;
            case 4:
                int escolha = departamento.escolheCurso();

                if(escolha == -1){
                    System.out.println("Nao existem cursos");
                    break;
                }
                else if (escolha == 0) {
                    System.out.println("A cancelar...");
                    break;
                }
                
                Curso altera = departamento.getCurso(escolha-1);
                
                while(menu_disciplinas(departamento, altera, escolha-1) != 0);
                    
                
                break;
            case 0:
                System.out.println("Returning to Main Menu...");
                return 0;
            default:
                System.out.println("Escolha Invalida!");
        }
        
        System.out.println("Prima ENTER para continuar");
        scan.nextLine();
        return choice;
    }
    
    private static int menu_pessoas(DEI departamento){
        int choice;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("=================== MENU PESSOAS =======================\n");
        System.out.println("[1] Criar Aluno");
        System.out.println("[2] Criar Docente");
        System.out.println("[3] Criar Nao-Docente");
        System.out.println("[4] Listar Alunos");
        System.out.println("[5] Listar Docentes");
        System.out.println("[6] Listar Nao-Docentes");
        System.out.println("[7] Listar Funcionarios");
        System.out.println("[8] Listar Pessoas");
        System.out.println("[9] Listar Exames do Aluno");
        System.out.println("[10] Listar Exames do Docente");
        System.out.println("[11] Listar Exames do Nao-Docente");
        System.out.println("[0] Voltar");
        System.out.println("\nInsira a sua escolha:");

        while(!scan.hasNextInt()){
            System.out.println("Insercao invalida!\nInsira um inteiro:");
            scan.nextLine();
        }
        choice = scan.nextInt();

        scan.nextLine(); // clears input

        switch (choice) {
            case 1:
                departamento.createPessoa("aluno");
                break;
            case 2:
                departamento.createPessoa("docente");
                break;
            case 3:
                departamento.createPessoa("nao docente");
                break;
            case 4:
                departamento.writeListaPessoasToLIST("aluno");
                break;
            case 5:
                departamento.writeListaPessoasToLIST("docente");
                break;
            case 6:
                departamento.writeListaPessoasToLIST("nao docente");
                break;
            case 7:
                departamento.writeListaPessoasToLIST("funcionario");
                break;
            case 8:
                departamento.writeListaPessoasToLIST("todos");
                break;
            case 0:
                System.out.println("Returning to Main Menu...");
                return 0;
            default:
                System.out.println("Escolha Invalida!");
        }
        
        System.out.println("Prima ENTER para continuar");
        scan.nextLine();
        return choice;
    }
    
    private static int menu_disciplinas(DEI departamento, Curso curso, int index){
        int choice;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("=================== MENU DE " +curso.toString().toUpperCase()+ " =======================\n");
        System.out.println("[1] Adicionar Disciplina");
        System.out.println("[2] Remover Disciplina");
        System.out.println("[3] Listar Disciplinas");
        System.out.println("[4] Alterar Duracao");
        System.out.println("[5] Alterar Grau");
        System.out.println("[6] Gerir Exames");
        System.out.println("[7] Adicionar Docente");
        System.out.println("[8] Adicionar Aluno");
        System.out.println("[9] Listar Docentes");
        System.out.println("[10] Listar Alunos");
        System.out.println("[0] Voltar");
        System.out.println("\nInsira a sua escolha:");

        while(!scan.hasNextInt()){
            System.out.println("Insercao invalida!\nInsira um inteiro:");
            scan.nextLine();
        }
        choice = scan.nextInt();

        scan.nextLine(); // clears input

        switch (choice) {
            case 1:
                curso.createDisciplina(departamento);
                break;
            case 2:
                curso.removeDisciplina();
                break;
            case 3:
                curso.writeListaDisciplinasToLIST();
                break;
            case 4:
                curso.alteraDados("duracao");
                break;
            case 5:
                curso.alteraDados("grau");
                break;
            case 6:case 7:case 8:case 9:case 10:
            	int escolha = curso.escolheDisciplina();

                if(escolha == -1){
                    System.out.println("Nao existem cursos");
                    break;
                }
                else if (escolha == 0) {
                    System.out.println("A cancelar...");
                    break;
                }
                
                Disciplina altera = curso.getDisciplina(escolha-1);
                
                switch (choice) {
                case 6:
                    while(menu_exames(departamento, altera) != 0);  
                    break;
                case 7:
                    altera.addDocente(departamento);
                    break;
                case 8:
                    altera.addAluno(departamento);
                    break;
                case 9:
                    altera.listDocentes();
                    break;
                case 10:
                    altera.listAlunos();
                    break;
                case 0:
                	return 0;
                default:
                    break;
                }
        }
        return 1;
    }
    
    private static int menu_exames(DEI departamento, Disciplina disciplina) {
    	int choice;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("=================== MENU DE " +disciplina.toString().toUpperCase()+ " =======================\n");
        System.out.println("[1] Adicionar exame");
        System.out.println("[2] Remover exame");
        System.out.println("[3] Listar exames");
        System.out.println("[4] Adicionar vigilantes");
        System.out.println("[5] Adicionar naodocentes");
        System.out.println("[6] Adicionar alunos");
        System.out.println("[7] Alterar notas (RNG)");
        System.out.println("[8] Alterar Sala");
        System.out.println("[9] Alterar docente responsavel");
        System.out.println("[10] Alterar data");
        System.out.println("[11] Alterar duracao");
        System.out.println("\nInsira a sua escolha:");

        while(!scan.hasNextInt()){
            System.out.println("Insercao invalida!\nInsira um inteiro:");
            scan.nextLine();
        }
        choice = scan.nextInt();

        scan.nextLine(); // clears input
    	
        switch (choice) {
        case 1:
            disciplina.createExame(departamento, disciplina);
            break;
        case 2:
        	int sala =	disciplina.removeExame();
        	departamento.getSala(sala).freeSala(sala);
            break;
        case 3:
        	//Checks if any exams exist
        	if(disciplina.listExams("normal")!= 0) {
        	disciplina.listExams("Especial");
        	disciplina.listExams("recurso");
        	}
            break;
        case 4:
        	System.out.println("Adicionar vigilantes");
            break;
        case 5:
        	System.out.println("Adicionar naodocentes");
        	break;
        case 6:
        	System.out.println("Adicionar alunos");
        	break;
        case 7:
        	System.out.println("Alterar notas (RNG)");
        	break;
        case 8:
        	System.out.println("Alterar Sala");
        	break;
        case 9:
        	disciplina.changeDocente(departamento);
        	break;
        case 10:
        	System.out.println("Alterar data");
        	break;
        case 11:
        	System.out.println("Alterar duracao");
        	break;
        case 0:
            System.out.println("Returning to Main Menu...");
            return 0;
        default:
            System.out.println("Escolha Invalida!");
            break;
    } 
        return choice;
    }
}
