/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Luis David
 */



public class Main {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dei departamento = new Dei();
        Scanner scan = new Scanner(System.in);
        
        while(true){
            menu_main(departamento);
        }
    }  
    
    @SuppressWarnings("empty-statement")
    private static void menu_main(Dei departamento){
        int choice;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("=================== MENU PRINCIPAL =======================\n");
        System.out.println("[1] Gerir Cursos");
        System.out.println("[2] Gerir Pessoas");
        System.out.println("[3] Convocar funcionários");
        System.out.println("[4] Inscrever alunos num exame");
        System.out.println("[5] Lancar notas");
        System.out.println("[6] Listar Exames");
        System.out.println("[7] Listar alunos inscritos");
        System.out.println("[8] Listar exames do aluno");
        System.out.println("[9] Listar funcionarios associados");
        System.out.println("[10] Listar exames do funcionario");
        System.out.println("[11] Listar notas do exame");
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
            case 3:
                System.out.println(choice);
                break;
            case 4:
                System.out.println(choice);
                break;
            case 5:
                System.out.println(choice);
                break;
            case 6:
                System.out.println(choice);
                break;
            case 7:
                System.out.println(choice);
                break;
            case 8:
                System.out.println(choice);
                break;
            case 9:
                System.out.println(choice);
                break;
            case 10:
                System.out.println(choice);
                break;
            case 11:
                System.out.println(choice);
                break;
            case 0:
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
    
    private static int menu_curso(Dei departamento){
        int choice;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("=================== MENU CURSOS =======================\n");
        System.out.println("[1] Criar Curso");
        System.out.println("[2] Remover Curso");
        System.out.println("[3] Listar Cursos");
        System.out.println("[4] Adicionar Disciplina");
        System.out.println("[5] Remover Disciplina");
        System.out.println("[6] Listar Disciplinas");
        System.out.println("[7] Alterar Duracao");
        System.out.println("[8] Alterar Grau");
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
                departamento.listCursos();
                break;
            case 4:
                System.out.println(choice);
                break;
            case 5:
                System.out.println(choice);
                break;
            case 6:
                System.out.println(choice);
                break;
            case 7:
                departamento.alteraDados("grau");
                break;
            case 8:
                departamento.alteraDados("duracao");
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
    
    private static int menu_pessoas(Dei departamento){
        int choice;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("=================== MENU PESSOAS =======================\n");
        System.out.println("[1] Criar Aluno");
        System.out.println("[2] Criar Docente");
        System.out.println("[3] Criar Nao-Docente");
        System.out.println("[4] Matar Aluno");
        System.out.println("[5] Matar Docente");
        System.out.println("[6] Matar Nao-Docente");
        System.out.println("[7] Listar Alunos");
        System.out.println("[8] Listar Docentes");
        System.out.println("[9] Listar Nao-Docentes");
        System.out.println("[10] Listar Funcionarios");
        System.out.println("[11] Listar Pessoas");
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
                System.out.println(choice);
                break;
            case 5:
                System.out.println(choice);
                break;
            case 6:
                System.out.println(choice);
                break;
            case 7:
                departamento.listPessoa("aluno");
                break;
            case 8:
                departamento.listPessoa("docente");
                break;
            case 9:
                departamento.listPessoa("nao docente");
                break;
            case 10:
                departamento.listPessoa("aluno");
                break;
            case 11:
                departamento.listPessoa("todos");
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
    
    
}
