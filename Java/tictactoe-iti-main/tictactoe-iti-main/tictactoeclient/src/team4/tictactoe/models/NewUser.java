package team4.tictactoe.models;

public class NewUser {
	String username;
	String name;
	String password;
	public NewUser(String username, String name, String password) {
		this.username = username;
		this.name = name;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "NewUser{" +
				"username='" + username + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
