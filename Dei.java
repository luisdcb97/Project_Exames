/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luis David
 */
public class Dei {
    private ArrayList<Curso> cursos;
    private ArrayList<Pessoa> pessoa;

    public Dei(){
        this.cursos = new ArrayList<>();
        this.pessoa = new ArrayList<>();
    }
    
    public void listAllFunctionarios() {
        ArrayList<Functionario> lista = new ArrayList<>();
        
        for(int i = 0;i<pessoa.size();i++) {
            Pessoa pes = pessoa.get(i);
            if(pes.getClass() != Aluno.class) {
                Functionario func = (Functionario) pes;
                lista.add(func);
            }
        }
        
        if(lista.isEmpty()){
            System.out.println("\nNo funcionarios to list\n");
        }
        else{
            System.out.println("\nListing all funcionarios");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
            }
            System.out.println("\n End of list\n");
            
        }
        
        
    }

    public void listCursos(){
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(cursos.get(i));
        }
    }
    
    void listExamsofFunctionario(){

        //Ask for index of functionario (index given is (index -1) of arraylist
    }
    void listExamsofAluno(){

    }
    
    // <editor-fold defaultstate="collapsed" desc="void createCurso()">
    public void createCurso(){
        Scanner scan = new Scanner(System.in);
        String novo_nome;
        String novo_grau;
        int nova_dur;
       
        System.out.println("Insira o nome do novo curso:");
        novo_nome = scan.nextLine();
       
        while(true){
            System.out.println("Insira o grau do novo curso[ Licenciatura | Mestrado | Doutoramento]:");
            novo_grau = scan.nextLine();
            if(novo_grau.equals("Licenciatura") || novo_grau.equals("Mestrado") || novo_grau.equals("Doutoramento")){
                break;
            }
            
            System.out.println("Insercao invalida!!!");
        }
        
        while(true){
            System.out.println("Insira a duracao do novo curso em anos [3-9]:");
            while(!scan.hasNextInt()){
                System.out.println("Insercao invalida! Insira um inteiro entre 3 e 9");
                scan.nextLine();
            }
            nova_dur = scan.nextInt();
            if(nova_dur >=3 && nova_dur <= 9){
                break;
            }
            
            System.out.println("Insercao invalida!!!");
        }
        
        Curso novo = new Curso(novo_nome, nova_dur, novo_grau);
        
        this.cursos.add(novo);
        
        System.out.print("Curso ");
        System.out.print(novo);
        System.out.println(" " + "adicionado ao departamento");
       
    } //</editor-fold>
}
