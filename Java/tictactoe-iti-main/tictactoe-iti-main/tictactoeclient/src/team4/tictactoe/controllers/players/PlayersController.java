/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team4.tictactoe.controllers.players;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
//import static java.awt.SystemColor.window;
//import java.awt.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Window;
import javafx.util.Callback;
import team4.tictactoe.TicTacToeApplication;
import team4.tictactoe.config.Navigator;
import team4.tictactoe.models.Client;
import team4.tictactoe.models.User;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author elkrnk 1
 */
public class PlayersController implements Initializable {
    ObservableList<User> userList = FXCollections.observableArrayList();
    String s = "";
    String requestUser;
    Alert alert;
    ButtonType reject;
    private Label label;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> colUsername;
    /*
     * private void handleButtonAction(ActionEvent event) {
     * System.out.println("You clicked me!");
     * label.setText("Hello World!");
     * }
     */
    @FXML
    private TableColumn<User, String> colScore;
    @FXML
    private TableColumn<User, String> colStatus;
    @FXML
    private TableColumn<User, String> colRequest;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    void hello() {
        System.out.println("hello");
    }
    public void loadUsers(ObservableList<User> userList) {
        tableView.setItems(userList);
        colUsername.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        Callback<TableColumn<User, String>, TableCell<User, String>> cellFoctory = (TableColumn<User, String> param) -> {
            // make cell containing buttons
            final TableCell<User, String> cell = new TableCell<User, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    // that cell created only on non-empty rows
                    if (empty) {
                        // setGraphic(null);
                        // setText(null);
                    } else {
                        Button bt1 = new Button();
                        bt1.setText("   send   ");
                        // FontAwesomeIconView deleteIcon = new
                        // FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        HBox managebtn = new HBox(bt1);
                        managebtn.setStyle("-fx-color:green");
                        setGraphic(managebtn);
                        bt1.setOnAction((ActionEvent event) -> {
                            User u = getTableView().getItems().get(getIndex());
                            String s = u.getStatus();
                            if (s.equals("offline"))
                            // System.out.println(u.getUserName());
                            {
                                managebtn.setStyle("-fx-color:red");
                                Alert error = new Alert(Alert.AlertType.ERROR, u.getUserName() + "" + "is  offline ");
                                error.show();
                            } else {
                                System.out.println(u.getUserName());
                                requestUser = u.getUserName();
                                try {
                                    waitResponse();
                                } catch (IOException ex) {
                                    Logger.getLogger(PlayersController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                Client.client.requestGame(requestUser);
                            }
                        });
                    }
                }
            };
            return cell;
        };
        colRequest.setCellFactory(cellFoctory);
        tableView.setItems(userList);
    }
    public String acceptGame(String player) {
        // Update UI here.
        ButtonType accept = new ButtonType("accept");
        reject = new ButtonType("reject");
        alert = new Alert(Alert.AlertType.CONFIRMATION, "", accept, reject);
        Window window = alert.getDialogPane().getScene().getWindow();
        window.setOnCloseRequest(e -> {
            //if(!valid())
            s = "cancel";
        });
        alert.setTitle("new request");
        alert.setHeaderText(player + "" + "sent Request to start new game");
        alert.setResizable(false);
        alert.setContentText("accept or reject");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == accept) {
            s = "ok";
        } else if (result.isPresent() && result.get() == reject) {
            s = "cancel";
        }
        System.out.println("2" + s);
        return s;
    }
    void waitResponse() throws IOException {
        Scene scene = new Scene(Navigator.get("waiting"));
        // Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        // Stage stage=Javaproject.stage;
        TicTacToeApplication.stage.setScene(scene);
        TicTacToeApplication.stage.show();
    }
    public void cancelAlert() {
        Button close = (Button) alert.getDialogPane().lookupButton(reject);
        close.fire();
    }
}
