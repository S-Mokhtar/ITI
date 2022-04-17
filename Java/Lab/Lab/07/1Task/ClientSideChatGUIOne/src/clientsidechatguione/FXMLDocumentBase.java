package clientsidechatguione;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FXMLDocumentBase extends BorderPane {

    protected final TextArea textArea;
    protected final FlowPane flowPaneContaier;
    protected final TextField textField;
    protected final Button sendButton;
    private Stage stage;
    Socket socket;
    DataInputStream dataInputStream;
    PrintStream printStream;
    String mess;
    String x = "";

    public FXMLDocumentBase(Stage stage) {
        this.stage = stage;
        textArea = new TextArea();
        flowPaneContaier = new FlowPane();
        textField = new TextField();
        sendButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setEditable(false);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        BorderPane.setAlignment(flowPaneContaier, javafx.geometry.Pos.CENTER);
        flowPaneContaier.setPrefHeight(58.0);
        flowPaneContaier.setPrefWidth(600.0);

        textField.setPrefHeight(55.0);
        textField.setPrefWidth(499.0);

        sendButton.setMnemonicParsing(false);
        sendButton.setPrefHeight(50.0);
        sendButton.setPrefWidth(94.0);
        sendButton.setText("Send");

        setBottom(flowPaneContaier);

        flowPaneContaier.getChildren().add(textField);
        flowPaneContaier.getChildren().add(sendButton);

        try {
            socket = new Socket("127.0.0.1", 5005);
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());

            sendButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String message = textField.getText();
                    printStream.println(message);
                    System.err.println("x >>>>>>>>>>>> " + x);

                }
            });

            new Thread() {
                @Override
                public void run() {
                    while (true) {

                        try {
                            String message = dataInputStream.readLine();
                            mess = message;
                            x = "true";
                            textArea.appendText(message + "\n");
                            Platform.runLater(() -> {
                                if (x.equals("true")) {
                                    textField.clear();
                                    textField.setText("from server >>> " + mess);
                                    textArea.appendText("from server >>> " + mess + "\n");
                                } else {
                                    new Alert(Alert.AlertType.ERROR, "error x = " + x).show();
                                }
                            });
                        } catch (IOException ex) {
                            //Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                            try {
                                if (dataInputStream != null) {
                                    dataInputStream.close();
                                }
                                if (printStream != null) {
                                    printStream.close();
                                }
                                System.exit(0);

                                //   Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex1);
                            } catch (Exception ex2) {
                                // Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex2);
                            }
                        }
                    }
                }
            }.start();
        } catch (IOException ex) {

            try {
                if (printStream != null) {
                    printStream.close();
                }
                System.exit(0);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
            } catch (IOException ex1) {
                Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex1);
            }

            // Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    socket.close();
                    dataInputStream.close();
                    printStream.close();
                    System.exit(0);

                    //  Platform.runLater();
                    //  Platform.exit();
                } catch (IOException ex) {
                    //     Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
}
