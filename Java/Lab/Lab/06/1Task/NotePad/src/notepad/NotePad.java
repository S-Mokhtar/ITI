/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author METRO
 */
public class NotePad extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new FXMLDocumentBase(stage);
        stage.setTitle("Untitled NotePad");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void stop() {
       System.out.println("Stage is closing");
       FXMLDocumentBase.s.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
