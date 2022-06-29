package model;

public class Usuario {

	private String user;
	
	private String pass;
	
	
	public Usuario (String user, String pass) {
		this.user = user;
		this.pass = pass;
		
	}


	public String getUserName() {
		return user;
	}


	public String getUserPass() {
		return pass;
	};
	
	
	

}
