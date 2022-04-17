package team4.tictactoe.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import team4.tictactoe.TicTacToeApplication;

import java.io.IOException;
import java.util.HashMap;

public class Navigator {
    private static final HashMap<String, Parent> screens = new HashMap<>();
    public static void loadScenes() throws IOException {
        screens.put("welcome", new FXMLLoader(TicTacToeApplication.class.getResource("views/hello-view.fxml")).load());
        screens.put("login", new FXMLLoader(TicTacToeApplication.class.getResource("views/auth/login.fxml")).load());
        screens.put("signup", new FXMLLoader(TicTacToeApplication.class.getResource("views/auth/signup.fxml")).load());
        screens.put("home", new FXMLLoader(TicTacToeApplication.class.getResource("views/home/home.fxml")).load());
        screens.put("waiting", new FXMLLoader(TicTacToeApplication.class.getResource("views/waiting.fxml")).load());
        screens.put("guest-home", new FXMLLoader(TicTacToeApplication.class.getResource("views/home/guest-home.fxml")).load());
        screens.put("players-list", new FXMLLoader(TicTacToeApplication.class.getResource("views/players/players-list.fxml")).load());
    }
    public static void Navigate(Button button, String next) {
        Stage stage = (Stage) button.getScene().getWindow();
        Group group = new Group();
        group.getChildren().add(screens.get(next));
        Scene scene = new Scene(group, 600, 600);
        stage.setScene(scene);
    }
    public static Parent get(String screen) {
        return screens.get(screen);
    }
}
