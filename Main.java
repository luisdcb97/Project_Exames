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
    
    private static void menu_main(Dei departamento){
        int choice;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("=================== MENU PRINCIPAL =======================\n");
        System.out.println("[1] Gerir Cursos");
        System.out.println("[2] Reservar salas");
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
                menu_curso(departamento);
                break;
            case 2:
                System.out.println(choice);
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
    
    private static void menu_curso(Dei departamento){
        int choice;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("=================== MENU CURSOS =======================\n");
        System.out.println("[1] Criar Cursos");
        System.out.println("[2] Adicionar Disciplina");
        System.out.println("[3] Remover Disciplina");
        System.out.println("[3] Alterar Duracao");
        System.out.println("[4] Alterar Grau");
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
                System.out.println(choice);
                break;
            case 3:
                System.out.println(choice);
                break;
            case 4:
                System.out.println(choice);
                break;
            case 0:
                break;
            default:
                System.out.println("Escolha Invalida!");
                break;
        }
        
        System.out.println("Returning to Main Menu...\nPrima ENTER para continuar");
        scan.nextLine();
    }
    
}
