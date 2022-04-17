package databasestudent;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FXMLDocumentBase extends BorderPane {

    protected final FlowPane flowPane;
    protected final Label IDLabel;
    protected final Label firstNameLabel;
    protected final Label lastNameLabel;
    protected final Label emailLabel;
    protected final Label phoneLabel;
    protected final FlowPane flowPane0;
    protected final Button NewButton;
    protected final Button updateButton;
    protected final Button deleteButton;
    protected final Button firstButton;
    protected final Button perButton;
    protected final Button nextButton;
    protected final Button lastButton;
    protected final FlowPane flowPane1;
    protected final TextField IDTextField;
    protected final TextField fNameTextField;
    protected final TextField lNameTextField;
    protected final TextField emailTextField;
    protected final TextField phoneTextField;
    private Stage stage;
    private boolean isNew = false;
    private boolean isUpdtaed = false;
    private ArrayList<DTO> arrayList = null;
    private int counter = 0;

    public FXMLDocumentBase(Stage stage) {
        this.stage = stage;
        flowPane = new FlowPane();
        IDLabel = new Label();
        firstNameLabel = new Label();
        lastNameLabel = new Label();
        emailLabel = new Label();
        phoneLabel = new Label();
        flowPane0 = new FlowPane();
        NewButton = new Button();
        updateButton = new Button();
        deleteButton = new Button();
        firstButton = new Button();
        perButton = new Button();
        nextButton = new Button();
        lastButton = new Button();
        flowPane1 = new FlowPane();
        IDTextField = new TextField();
        fNameTextField = new TextField();
        lNameTextField = new TextField();
        emailTextField = new TextField();
        phoneTextField = new TextField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(400.0);
        flowPane.setPrefWidth(131.0);

        IDLabel.setAlignment(javafx.geometry.Pos.CENTER);
        IDLabel.setPrefHeight(24.0);
        IDLabel.setPrefWidth(133.0);
        IDLabel.setText("ID");

        firstNameLabel.setAlignment(javafx.geometry.Pos.CENTER);
        firstNameLabel.setPrefHeight(32.0);
        firstNameLabel.setPrefWidth(133.0);
        firstNameLabel.setText("First Name");

        lastNameLabel.setAlignment(javafx.geometry.Pos.CENTER);
        lastNameLabel.setPrefHeight(34.0);
        lastNameLabel.setPrefWidth(133.0);
        lastNameLabel.setText("Last Name");

        emailLabel.setAlignment(javafx.geometry.Pos.CENTER);
        emailLabel.setPrefHeight(32.0);
        emailLabel.setPrefWidth(133.0);
        emailLabel.setText("Email");

        phoneLabel.setAlignment(javafx.geometry.Pos.CENTER);
        phoneLabel.setPrefHeight(39.0);
        phoneLabel.setPrefWidth(133.0);
        phoneLabel.setText("Phone");
        setLeft(flowPane);

        BorderPane.setAlignment(flowPane0, javafx.geometry.Pos.CENTER);
        flowPane0.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        flowPane0.setPrefHeight(59.0);
        flowPane0.setPrefWidth(600.0);

        NewButton.setMnemonicParsing(false);
        NewButton.setPrefHeight(31.0);
        NewButton.setPrefWidth(69.0);
        NewButton.setText("New");
        FlowPane.setMargin(NewButton, new Insets(0.0, 5.0, 0.0, 0.0));
        NewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isNew == false) {
                    IDTextField.setText("");
                    fNameTextField.setText("");
                    lNameTextField.setText("");
                    phoneTextField.setText("");
                    emailTextField.setText("");
                    IDTextField.setEditable(true);
                    fNameTextField.setEditable(true);
                    lNameTextField.setEditable(true);
                    phoneTextField.setEditable(true);
                    emailTextField.setEditable(true);
                    NewButton.setText("Save");
                    isNew = true;
                    updateButton.setDisable(true);
                    deleteButton.setDisable(true);
                    deleteButton.setDisable(true);
                    firstButton.setDisable(true);
                    lastButton.setDisable(true);
                    nextButton.setDisable(true);
                    perButton.setDisable(true);

                } else {
                    if (!IDTextField.getText().trim().isEmpty() || !fNameTextField.getText().trim().isEmpty()) {
                        int ID = Integer.parseInt(IDTextField.getText());
                        String fname = fNameTextField.getText();
                        String lname = lNameTextField.getText();
                        String email = emailTextField.getText();
                        int phone = Integer.parseInt(phoneTextField.getText());
                        DTO dto = new DTO(ID, phone, fname, lname, email);
                        DAL.addStudent(dto);
                    } else {
                        System.err.println("there are thing empty");
                    }
                    IDTextField.setText("");
                    fNameTextField.setText("");
                    lNameTextField.setText("");
                    phoneTextField.setText("");
                    emailTextField.setText("");
                    IDTextField.setEditable(false);
                    fNameTextField.setEditable(false);
                    lNameTextField.setEditable(false);
                    phoneTextField.setEditable(false);
                    emailTextField.setEditable(false);
                    NewButton.setText("New");
                    isNew = false;
                    updateButton.setDisable(false);
                    deleteButton.setDisable(false);
                    deleteButton.setDisable(false);
                    firstButton.setDisable(false);
                    lastButton.setDisable(false);
                    nextButton.setDisable(false);
                    perButton.setDisable(false);
                    arrayList = DAL.selectStudent();
                }

            }
        });

        updateButton.setMnemonicParsing(false);
        updateButton.setPrefHeight(31.0);
        updateButton.setPrefWidth(80.0);
        updateButton.setText("Update");
        FlowPane.setMargin(updateButton, new Insets(0.0, 5.0, 0.0, 0.0));
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isUpdtaed == false) {
                    IDTextField.setEditable(true);
                    fNameTextField.setEditable(true);
                    lNameTextField.setEditable(true);
                    phoneTextField.setEditable(true);
                    emailTextField.setEditable(true);
                    NewButton.setDisable(true);
                    deleteButton.setDisable(true);
                    deleteButton.setDisable(true);
                    firstButton.setDisable(true);
                    lastButton.setDisable(true);
                    nextButton.setDisable(true);
                    perButton.setDisable(true);
                    isUpdtaed = true;
                } else {
                    if (!IDTextField.getText().trim().isEmpty() || !fNameTextField.getText().trim().isEmpty()) {
                        int ID = Integer.parseInt(IDTextField.getText());
                        String fname = fNameTextField.getText();
                        String lname = lNameTextField.getText();
                        String email = emailTextField.getText();
                        int phone = Integer.parseInt(phoneTextField.getText());
                        DTO dto = new DTO(ID, phone, fname, lname, email);
                        DAL.updateStudent(dto);
                    } else {
                        System.err.println("there are thing empty");
                    }
                    IDTextField.setEditable(false);
                    fNameTextField.setEditable(false);
                    lNameTextField.setEditable(false);
                    phoneTextField.setEditable(false);
                    emailTextField.setEditable(false);
                    isUpdtaed = false;
                    NewButton.setDisable(false);
                    deleteButton.setDisable(false);
                    deleteButton.setDisable(false);
                    firstButton.setDisable(false);
                    lastButton.setDisable(false);
                    nextButton.setDisable(false);
                    perButton.setDisable(false);
                    arrayList = DAL.selectStudent();
                }
            }
        });

        deleteButton.setMnemonicParsing(false);
        deleteButton.setPrefHeight(31.0);
        deleteButton.setPrefWidth(78.0);
        deleteButton.setText("Delete");
        FlowPane.setMargin(deleteButton, new Insets(0.0, 5.0, 0.0, 0.0));
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DAL.deleteStudent(Integer.parseInt(IDTextField.getText()));
                showData();
            }
        });
        firstButton.setMnemonicParsing(false);
        firstButton.setPrefHeight(31.0);
        firstButton.setPrefWidth(66.0);
        firstButton.setText("First");
        FlowPane.setMargin(firstButton, new Insets(0.0, 5.0, 0.0, 0.0));
        firstButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                counter = 0;
                DTO student = arrayList.get(counter); //DAL.firstStudent();
                IDTextField.setText(student.getID() + "");
                fNameTextField.setText(student.getFirstName());
                lNameTextField.setText(student.getLastName());
                phoneTextField.setText(student.getPhoneNumber() + "");
                emailTextField.setText(student.getEmail());

            }
        });

        perButton.setMnemonicParsing(false);
        perButton.setPrefHeight(31.0);
        perButton.setPrefWidth(87.0);
        perButton.setText("Pervoius");
        FlowPane.setMargin(perButton, new Insets(0.0, 5.0, 0.0, 0.0));
        perButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (counter > 0) {
                    counter--;
                }
                DTO student = arrayList.get(counter);
                IDTextField.setText(student.getID() + "");
                fNameTextField.setText(student.getFirstName());
                lNameTextField.setText(student.getLastName());
                phoneTextField.setText(student.getPhoneNumber() + "");
                emailTextField.setText(student.getEmail());
            }
        });

        nextButton.setMnemonicParsing(false);
        nextButton.setPrefHeight(31.0);
        nextButton.setPrefWidth(74.0);
        nextButton.setText("Next");
        FlowPane.setMargin(nextButton, new Insets(0.0, 5.0, 0.0, 0.0));
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (counter < arrayList.size() - 1) {
                    counter++;
                }

                DTO student = arrayList.get(counter);
                IDTextField.setText(student.getID() + "");
                fNameTextField.setText(student.getFirstName());
                lNameTextField.setText(student.getLastName());
                phoneTextField.setText(student.getPhoneNumber() + "");
                emailTextField.setText(student.getEmail());
            }
        });

        lastButton.setMnemonicParsing(false);
        lastButton.setPrefHeight(31.0);
        lastButton.setPrefWidth(65.0);
        lastButton.setText("Last");
        FlowPane.setMargin(lastButton, new Insets(0.0, 5.0, 0.0, 0.0));
        lastButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                counter = arrayList.size() - 1;
                DTO student = arrayList.get(counter);
                // DTO student = DAL.lastSTuendt();
                IDTextField.setText(student.getID() + "");
                fNameTextField.setText(student.getFirstName());
                lNameTextField.setText(student.getLastName());
                phoneTextField.setText(student.getPhoneNumber() + "");
                emailTextField.setText(student.getEmail());
            }
        });
        setBottom(flowPane0);

        BorderPane.setAlignment(flowPane1, javafx.geometry.Pos.CENTER);
        flowPane1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        flowPane1.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane1.setPrefHeight(200.0);
        flowPane1.setPrefWidth(200.0);

        IDTextField.setAlignment(javafx.geometry.Pos.CENTER);
        IDTextField.setPrefHeight(27.0);
        IDTextField.setPrefWidth(187.0);
        FlowPane.setMargin(IDTextField, new Insets(0.0, 0.0, 5.0, 0.0));

        IDTextField.setEditable(false);
        fNameTextField.setEditable(false);
        lNameTextField.setEditable(false);
        phoneTextField.setEditable(false);
        emailTextField.setEditable(false);

        FlowPane.setMargin(fNameTextField, new Insets(0.0, 0.0, 5.0, 0.0));

        FlowPane.setMargin(lNameTextField, new Insets(0.0, 0.0, 5.0, 0.0));

        FlowPane.setMargin(emailTextField, new Insets(0.0, 0.0, 5.0, 0.0));

        FlowPane.setMargin(phoneTextField, new Insets(0.0, 0.0, 5.0, 0.0));
        BorderPane.setMargin(flowPane1, new Insets(0.0));
        flowPane1.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));
        setCenter(flowPane1);

        flowPane.getChildren().add(IDLabel);
        flowPane.getChildren().add(firstNameLabel);
        flowPane.getChildren().add(lastNameLabel);
        flowPane.getChildren().add(emailLabel);
        flowPane.getChildren().add(phoneLabel);
        flowPane0.getChildren().add(NewButton);
        flowPane0.getChildren().add(updateButton);
        flowPane0.getChildren().add(deleteButton);
        flowPane0.getChildren().add(firstButton);
        flowPane0.getChildren().add(perButton);
        flowPane0.getChildren().add(nextButton);
        flowPane0.getChildren().add(lastButton);
        flowPane1.getChildren().add(IDTextField);
        flowPane1.getChildren().add(fNameTextField);
        flowPane1.getChildren().add(lNameTextField);
        flowPane1.getChildren().add(emailTextField);
        flowPane1.getChildren().add(phoneTextField);

        /* arrayList = DAL.selectStudent();
        IDTextField.setText(arrayList.get(0).getID() + "");
        fNameTextField.setText(arrayList.get(0).getFirstName());
        lNameTextField.setText(arrayList.get(0).getLastName());
        phoneTextField.setText(arrayList.get(0).getPhoneNumber() + "");
        emailTextField.setText(arrayList.get(0).getEmail());*/
        showData();
       // IDTextField.setPromptText("ID here");
      //  stage.setOnCloseRequest(new EventHandler<WindowEvent>{);
    }

    void showData() {
        arrayList = DAL.selectStudent();
        IDTextField.setText(arrayList.get(0).getID() + "");
        fNameTextField.setText(arrayList.get(0).getFirstName());
        lNameTextField.setText(arrayList.get(0).getLastName());
        phoneTextField.setText(arrayList.get(0).getPhoneNumber() + "");
        emailTextField.setText(arrayList.get(0).getEmail());

    }
}
