package project;

import java.util.ArrayList;
/*
 * @author Kwinten Jacobs
 * @author Luis David
 * @version 1.0
 */
public class DEI {

	protected ArrayList<Curso> cursos = new ArrayList<Curso>();
	protected ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
	
	ArrayList<Functionario> listFunctionarios() {
		ArrayList<Functionario> temp = new ArrayList<Functionario>();
		int a =1;
		for(int i = 0;i<pessoa.size();i++) {
			if(Aluno.class != pessoa.get(i).getClass()) {
				Functionario func = (Functionario)pessoa.get(i);
				temp.add(func);
				System.out.print(a+". ");
				System.out.print(func.getName());
				System.out.println(func.getMecano());
				a++;
			}
		}
		return temp;
	}
	
	void listExamsofFunctionario(){
		listFunctionarios();
		
		//Ask for index of functionario (index given is (index -1) of arraylist
	}
	void listExamsofAluno(){
		
	}
	/*readFile(File a) {
		
	}*/
	/*writeFile(Default file){
		
	}*/
}
