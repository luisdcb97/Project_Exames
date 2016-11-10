package project;
/*
 * @author Kwinten Jacobs
 * @author Luis David
 * @version 1.0
 */
public class Aluno extends Pessoa {
	
	private int num;
	private int ano;
	private String regime;
	
	Aluno(String a, String b, int c, int d, String e) {
		super(a,b);
		setNum(c);
		setAno(d);
		setRegime(e);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

}
