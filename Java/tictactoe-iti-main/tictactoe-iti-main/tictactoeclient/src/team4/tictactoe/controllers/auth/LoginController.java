package team4.tictactoe.controllers.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import team4.tictactoe.TicTacToeApplication;
import team4.tictactoe.config.Connection;
import team4.tictactoe.config.Navigator;
import team4.tictactoe.config.RequestFormatter;
import team4.tictactoe.models.Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class LoginController {

	@FXML
	private PasswordField passwordField;
	@FXML
	private Text error;
	@FXML
	private TextField usernameField;
	@FXML
	private Button loginBtn;
	@FXML
	void onLoginButtonClick(ActionEvent event) throws IOException {
		String username = usernameField.getText();
		String password = passwordField.getText();
		Login login = new Login(username, password);
		String messageText = RequestFormatter.formatMessage(login, "login");
		System.out.println(messageText);
		Connection connection = TicTacToeApplication.getConnection();
		PrintStream printStream = connection.getPrintStream();
		printStream.println(messageText);
		BufferedReader bufferedReader = connection.getDataInputStream();
		String message = bufferedReader.readLine();

		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println("message " + message);
		JsonNode jsonNode = objectMapper.readValue(message, JsonNode.class);
		String type = jsonNode.get("type").toString().replaceAll("\"", "");
		if (type.equals("login")) {
			boolean success = jsonNode.get("success").asBoolean();
			if (success) {
				JsonNode data = jsonNode.get("data");
				Navigator.Navigate(loginBtn, "home");
			} else {
				TypeFactory typeFactory = objectMapper.getTypeFactory();
				String errorsJson = jsonNode.get("errors").toString();
				System.out.println(errorsJson);
				ArrayList<String> errorsArray = objectMapper.readValue(errorsJson, typeFactory.constructCollectionType(ArrayList.class, String.class));
				error.setText(errorsArray.get(0));
			}
		}
		System.out.println("returned message " + message);
		event.consume();
	}
	@FXML
	void onSignupButtonClick(ActionEvent event) throws IOException {
		System.out.println("Navigate to Signup");
		Navigator.Navigate((Button) event.getSource(), "signup");
	}

}
