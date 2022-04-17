package team4.tictactoe.backend.models;

public class NewUser {
	String username;
	String name;
	String password;
	public NewUser(String username, String name, String password) {
		this.username = username;
		this.name = name;
		this.password = password;
	}
	public NewUser() {

	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
}
