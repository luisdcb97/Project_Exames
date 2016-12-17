package project;

import java.io.Serializable;

/**
 * @author Kwinten Jacobs
 * @author Luis David
 */
//DONE
public abstract class Pessoa implements Serializable{
    private static final long serialVersionUID = 512L;
    private String name;
    private String email;
	
    public Pessoa(String nome, String email) {
	setName(nome);
	setEmail(email);
    }

    /**Returns the name of the Pessoa
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**Sets name as the name of the Pessoa
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**Returns the email of the Pessoa
     * @return String email
     */
    public String getEmail() {
    	return email;
    }

    /**Sets email as the email of the Pessoa
     * @param email
     */
    public void setEmail(String email) {
	this.email = email;
    }   
	
    @Override
    public String toString() {
        String str = "";
        str += this.getName() + " ";
        str += this.getEmail() + " ";
        return str;
    }
    
    public String toText() {
        String str = "";
        str += this.name +"|";
        str += this.email;
        return str;
    }
}
