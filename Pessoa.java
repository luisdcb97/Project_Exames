package project;
/*
 * @author Kwinten Jacobs
 * @author Luis David
 * @version 1.0
 */
abstract class Pessoa {

	private String name;
	private String email;
	Pessoa(String a, String b) {
		setName(name);
		setEmail(email);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
