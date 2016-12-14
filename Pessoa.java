package project;


//DONE
abstract class Pessoa {
    private String name;
    private String email;
	
    public Pessoa(String nome, String email) {
	setName(nome);
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
