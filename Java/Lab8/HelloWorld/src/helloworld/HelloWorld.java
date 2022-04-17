package helloworld;


import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Text txt= new Text("Hello World");
        Text ref=new Text("Hello World");
        txt.setId("text");
        ref.setId("ref");
        StackPane root = new StackPane();
        root.setId("r");
        root.getChildren().add(txt);
        root.getChildren().add(ref);
        Scene scene = new Scene(root, 300, 250);
        
       // scene.getStylesheets().add(getClass().getResource("MyStyle.css").toString());
        
        
        txt.setFill(Color.RED);
        txt.setFont(Font.font("SANS-SERIF", FontWeight.BOLD, 25));
        Reflection reflection = new Reflection();
        txt.setEffect(reflection);
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(0.5, Color.WHITE), new Stop(1, Color.BLACK)};
        LinearGradient linear_gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.REFLECT, stops);
        scene.setFill(linear_gradient);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
