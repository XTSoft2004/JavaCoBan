package bean;

public class Accountbean {
	public int idUser;
	public String username;
	public String password;
	public String fullname;
	
	public Accountbean(int idUser, String username, String password, String fullname) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return idUser + ";" + username + ";" + password + ";" + fullname; 
	}
	
}
