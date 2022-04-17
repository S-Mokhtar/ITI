package team4.tictactoe.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import team4.tictactoe.config.Navigator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
	@FXML
	Button login;
	@FXML
	public void onLoginButtonClick(ActionEvent event) throws IOException {
		System.out.println("Navigate to login");
		Navigator.Navigate(login, "login");
		event.consume();
	}
	@FXML
	public void onGuestLoginClick(ActionEvent event) throws IOException {
		System.out.println("Login as a guest");
		Navigator.Navigate(login, "guest-home");
		event.consume();
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		System.out.println("Initialized");
	}
}