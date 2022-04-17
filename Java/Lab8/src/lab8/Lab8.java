package lab8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Lab8 extends Application {
    
    public Lab8(){
        String name = Thread.currentThread().getName();
        System.out.println("Constructor current thread: "+name);
    }
    
    public void init() throws Exception{
      String name = Thread.currentThread().getName();
      System.out.println("Init current thread: "+name);
      super.init();
    }
    
    @Override
    public void start(Stage primaryStage) {
        String name = Thread.currentThread().getName();
        System.out.println("Start current thread: "+name);
        StackPane root = new StackPane();
        root.getChildren().add(new Text("Hello life cycle"));
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void stop() throws Exception{
        String name = Thread.currentThread().getName();
        System.out.println("Stop current thread: "+name);
        super.stop();
    }
   
    public static void main(String[] args) {
        launch(args);
    }
    
}
