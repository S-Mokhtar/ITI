package team4.tictactoe.controllers.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import team4.tictactoe.TicTacToeApplication;
import team4.tictactoe.config.Connection;
import team4.tictactoe.config.Navigator;
import team4.tictactoe.config.RequestFormatter;
import team4.tictactoe.models.NewUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class SignupController {

	@FXML
	private TextField fullNameField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private TextField usernameField;
	@FXML
	private ListView<String> listView;
	@FXML
	private Button signupButton;
	@FXML
	void onLoginButtonClick(ActionEvent event) throws IOException {
		System.out.println("Navigate to login");
		Navigator.Navigate((Button) event.getSource(), "login");
	}

	@FXML
	void onSignupButtonClick(ActionEvent event) throws IOException {
		String username = usernameField.getText();
		String name = fullNameField.getText();
		String password = passwordField.getText();
		NewUser newUser = new NewUser(username, name, password);
		System.out.println("Send new user data to server");
		String messageText = RequestFormatter.formatMessage(newUser, "register");
		System.out.println(messageText);
		Connection connection = TicTacToeApplication.getConnection();
		PrintStream printStream = connection.getPrintStream();
		printStream.println(messageText);
		BufferedReader bufferedReader = connection.getDataInputStream();
		String message = bufferedReader.readLine();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(message);
		String type = jsonNode.get("type").toString().replaceAll("\"", "");
		if (type.equals("register")) {
			boolean success = jsonNode.get("success").asBoolean();
			if (success) {
				JsonNode data = jsonNode.get("data");
				Navigator.Navigate(signupButton, "home");
			} else {
				TypeFactory typeFactory = objectMapper.getTypeFactory();
				String errorsJson = jsonNode.get("errors").toString();
				System.out.println(errorsJson);
				ArrayList<String> errorsArray = objectMapper.readValue(errorsJson, typeFactory.constructCollectionType(ArrayList.class, String.class));
				listView.getItems().clear();
				for(String error : errorsArray) {
					listView.getItems().add(error);
				}
			}
		}

		System.out.println("returned message " + message);
		event.consume();
	}

}
