package team4.tictactoe.controllers.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import team4.tictactoe.config.Navigator;

import java.io.IOException;

public class HomeController {
    @FXML
    private void showPlayersList(ActionEvent event) throws IOException {
        Navigator.Navigate((Button) event.getSource(), "players-list");
        event.consume();
    }
}
