/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author METRO
 */
public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {

        Text text = new Text("Hello World");
        text.setId("text");
        /*  text.setFill(Color.RED);
         text.setFont(Font.font("Georgia"));*/
        text.setEffect(new Reflection());
        //  Stop[] stops = { new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
        //      LinearGradient lg1 = new LinearGradient(0, 0.5, 0, 1, true, CycleMethod.REFLECT, stops);

        StackPane stackPane = new StackPane();
        stackPane.setPrefHeight(200);
        stackPane.setPrefWidth(400);
        stackPane.getChildren().addAll(text);
        stackPane.setId("text");

        Scene scene = new Scene(stackPane, Color.LIGHTBLUE);
        scene.getStylesheets().add("CssStyles/StyleeSheet.css");

        primaryStage.setTitle("My Rectangle App");
        //  scene.setFill(lg1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
