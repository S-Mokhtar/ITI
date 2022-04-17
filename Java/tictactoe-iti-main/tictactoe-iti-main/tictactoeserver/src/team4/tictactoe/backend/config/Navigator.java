package team4.tictactoe.backend.config;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Navigator {
    private static final HashMap<String, Parent> screens = new HashMap<>();
    public static void loadScenes() throws IOException {
    }
    public static void Navigate(Button button, String next) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        Scene scene = new Scene(screens.get(next), 600, 600);
        stage.setScene(scene);
    }
    public static Parent get(String screen) {
        return screens.get(screen);
    }
}
