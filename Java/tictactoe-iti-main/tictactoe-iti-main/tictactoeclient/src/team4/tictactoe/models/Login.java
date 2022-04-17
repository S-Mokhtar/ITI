package team4.tictactoe.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Login {
	private String username;
	private String password;
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
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

	public String toJsonString() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String str =  objectMapper.writeValueAsString(this);
		return str;
//		ObjectNode dataNode = objectMapper.createObjectNode();
//		dataNode.putPOJO("data", this);
//		return dataNode.toString();
	}

	@Override
	public String toString() {
		return "{" +
				"\"username\":\"" + username + '\"' +
				", \"password\":\"" + password + '\"' +
				'}';
	}
}
