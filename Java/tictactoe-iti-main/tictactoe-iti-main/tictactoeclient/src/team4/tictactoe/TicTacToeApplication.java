package team4.tictactoe;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import team4.tictactoe.config.Connection;
import team4.tictactoe.config.Navigator;
import team4.tictactoe.controllers.players.PlayersController;
import team4.tictactoe.controllers.GameController;

import java.io.IOException;
import java.util.Objects;

/**
 * @author elkrnk 1
 */
public class TicTacToeApplication extends Application {
    public static int userId;
    private static boolean loading;
    private static Connection connection;
    public static Stage stage;
    public static FXMLLoader loader;
    public static Parent window;
    public static PlayersController t;
    public static GameController controller;
    public static Parent window2;
    public static Scene mainScene;
    public static Scene gameScene;


    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        TicTacToeApplication.userId = userId;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static boolean isLoading() {
        return loading;
    }

    public static void setLoading(boolean loading) {
        TicTacToeApplication.loading = loading;
    }

    @Override
    public void start(Stage stage) throws Exception {
        window2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/game.fxml")));
        TicTacToeApplication.stage = stage;

        loader = new FXMLLoader(getClass().getResource("views/players/players-list.fxml"));
        t = loader.<PlayersController>getController();
        Scene welcomeScene = new Scene(Navigator.get("welcome"), 500, 500);
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
        stage.setScene(welcomeScene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Navigator.loadScenes();
        TicTacToeApplication.connection = new Connection();
        launch(args);
    }

}
