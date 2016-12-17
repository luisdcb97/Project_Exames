package project;

import java.io.Serializable;


/**
 * Pessoa is the abstract class for all persons belonging to the university
 * 
 * @author Kwinten Jacobs
 * @author Luis David
 * @version 1.0
 * 
 * 
 * @since 1.0
 */
public abstract class Pessoa implements Serializable{
    /**
    * Defines the <code>serialVersionUID</code> of this Pessoa to prevent
    * errors when reading Object Files after altering class methods or 
    * when using different compilers
    * 
    * @see java.io.Serializable
    */
    private static final long serialVersionUID = 512L;
    
    private String name;
    private String email;
	
    /**
     * Constructs a <code><b>Pessoa</b></code> object and initializes it so that
     * it represents a person named <code><b>nome</b></code> and with an e-mail
     * address <code><b>email</b></code> 
     * 
     * @param nome the name of the person
     * @param email the e-mail of the person
     * 
     * @since 1.0
     */
    public Pessoa(String nome, String email) {
	setName(nome);
	setEmail(email);
    }

    /**
     * Returns the name of this person
     * 
     * @return the name of this person 
     * @since 1.0
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of this person to <code>name</code>
     * 
     * @param name the new name this person will be called by
     * @since 1.0
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the e-mail address of this person
     * 
     * @return the e-mail address of this person 
     * @since 1.0
     */
    public String getEmail() {
    	return email;
    }

    /**
     * Changes the e-mail address of this person to <code>email</code>
     * 
     * @param email the new e-mail address of this person
     * @since 1.0
     */
    public void setEmail(String email) {
	this.email = email;
    }   
	
    
    /**
     * Returns a string representation of this <code>Pessoa</code> 
     * 
     * @return a string representation of this <code>Pessoa</code> 
     * @since 1.0
     */
    @Override
    public String toString() {
        String str = "";
        str += this.getName() + " ";
        str += this.getEmail() + " ";
        return str;
    }
    
    /**
     * Returns a string representation of this <code>Pessoa</code> formatted 
     * in a way to assist splitting of the returned string
     * 
     * @return a string representation of this <code>Pessoa</code>
     * @since 1.0
     */
    public String toText() {
        String str = "";
        str += this.name +"|";
        str += this.email;
        return str;
    }
}
