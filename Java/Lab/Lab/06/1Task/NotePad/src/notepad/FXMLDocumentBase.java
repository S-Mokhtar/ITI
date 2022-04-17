package notepad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FXMLDocumentBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu fileMenu;
    protected final MenuItem newItem;
    protected final MenuItem openItem;
    protected final MenuItem saveItem;
    protected final MenuItem saveAsItem;
    protected final MenuItem closeItem;
    protected final Menu editMenu;
    protected final MenuItem copyItem;
    protected final MenuItem cutItem;
    protected final MenuItem pasteItem;
    protected final MenuItem selectAllItem;
    protected final MenuItem deleteItem;
    protected final Menu helpMenu;
    protected final MenuItem aboutItem;
    protected final MenuItem cliboardItem;
    protected final TextArea textArea;
    protected final Stage stage;
    String currentText = null;
    String currentPath = null;
    String noteName = null;
    ObservableList<String> cliboardList = FXCollections.observableArrayList();
    // List<String> cliboardList = new ArrayList<>();
    ObservableList<String> observalList;
    ListView<String> listView = null;
    boolean isNew = false;
    static Stage s = new Stage();

    public FXMLDocumentBase(Stage stage) {
        this.stage = stage;
        menuBar = new MenuBar();
        fileMenu = new Menu();
        newItem = new MenuItem();
        openItem = new MenuItem();
        saveItem = new MenuItem();
        saveAsItem = new MenuItem();
        closeItem = new MenuItem();
        editMenu = new Menu();
        copyItem = new MenuItem();
        cutItem = new MenuItem();
        pasteItem = new MenuItem();
        selectAllItem = new MenuItem();
        deleteItem = new MenuItem();
        helpMenu = new Menu();
        cliboardItem = new MenuItem();
        aboutItem = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        // File Menue
        fileMenu.setMnemonicParsing(false);
        fileMenu.setText("File");

        newItem.setMnemonicParsing(false);
        newItem.setText("new");
        newItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

        // lambda Expression
        /*  newItem.setOnAction((ActionEvent e) -> {
            textArea.clear();
            isNew = true;
        });*/
        textArea.setText("djjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        newItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                textArea.clear();
                isNew = true;

            }
        });

        openItem.setMnemonicParsing(false);
        openItem.setText("open");
        openItem.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN));
        openItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select File");
                System.out.println("---------------------------------------------------------------------------------------------");
                File selectedFile = fileChooser.showOpenDialog(stage);

                if (selectedFile != null) {
                    String path = selectedFile.getPath();
                    currentPath = path;
                    try {
                        FileInputStream fileInputStream = new FileInputStream(path);
                        byte[] text = new byte[fileInputStream.available()];
                        fileInputStream.read(text);
                        textArea.setText(new String(text));
                        currentText = textArea.getText();
                        noteName = selectedFile.getName();
                        stage.setTitle(noteName);
                        fileInputStream.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        saveItem.setMnemonicParsing(false);
        saveItem.setText("save");
        saveItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        saveItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (currentPath == null) {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Save File");
                    File selectedFile = fileChooser.showSaveDialog(stage);
                    if (selectedFile != null) {
                        String path = selectedFile.getPath();
                        currentPath = path;
                        noteName = selectedFile.getName();
                        stage.setTitle(noteName);
                    }
                }
                if (currentPath != null) {
                    try {
                        try (FileOutputStream fileOutputStream = new FileOutputStream(currentPath)) {
                            byte[] text = textArea.getText().getBytes();
                            fileOutputStream.write(text);
                            textArea.setText(new String(text));
                            currentText = textArea.getText();
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        saveAsItem.setMnemonicParsing(false);
        saveAsItem.setText("saveAs");
        saveAsItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        saveAsItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save File As");
                File selectedFile = fileChooser.showSaveDialog(stage);
                if (selectedFile != null) {
                    String path = selectedFile.getPath();
                    currentPath = path;
                    noteName = selectedFile.getName();
                    stage.setTitle(noteName);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(currentPath);
                        byte[] text = textArea.getText().getBytes();
                        fileOutputStream.write(text);
                        textArea.setText(new String(text));
                        currentText = textArea.getText();
                        fileOutputStream.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });

        closeItem.setMnemonicParsing(false);
        closeItem.setText("exit");
        closeItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        closeItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ButtonType save = new ButtonType("Save");//ButtonType.OK;
                ButtonType cancel = new ButtonType("Donot Save");//ButtonType.CANCEL;
                ButtonType close = new ButtonType("Close");//ButtonType.CLOSE;
                String text = textArea.getText();
                if ((text.isEmpty() == true && currentText == null) || text.equals(currentText) == true) {
                    System.exit(0);
                } else {
                    Alert alert = new Alert(AlertType.WARNING, "Do you want to save changes??", save, cancel, close);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == save) {
                        if (currentPath == null) {
                            FileChooser fileChooser = new FileChooser();
                            fileChooser.setTitle("Save File");
                            File selectedFile = fileChooser.showSaveDialog(stage);
                            if (selectedFile != null) {
                                String path = selectedFile.getPath();
                                currentPath = path;
                            }
                        }
                        try {
                            if (currentPath != null) {
                                FileOutputStream fileOutputStream = new FileOutputStream(currentPath);
                                byte[] textArray = textArea.getText().getBytes();
                                fileOutputStream.write(textArray);
                                textArea.setText(new String(textArray));
                                currentText = textArea.getText();
                                fileOutputStream.close();
                            } else {
                                System.err.println("You did not choose file to save\nPlease save the file to close");
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        if (result.get() == cancel) {
                            //System.exit(0);
                            stage.close();
                        }
                    }
                }

            }
        });
        // Edit Menue
        editMenu.setMnemonicParsing(false);
        editMenu.setText("Edit");

        copyItem.setMnemonicParsing(false);
        copyItem.setText("copy");
        copyItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        copyItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cliboardList.add(textArea.getSelectedText());
                textArea.copy();
            }
        });
        cutItem.setMnemonicParsing(false);
        cutItem.setText("cut");
        cutItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        cutItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                cliboardList.add(textArea.getSelectedText());
                textArea.cut();
            }
        });

        pasteItem.setMnemonicParsing(false);
        pasteItem.setText("paste");
        pasteItem.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        pasteItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                textArea.paste();
            }
        });

        selectAllItem.setMnemonicParsing(false);
        selectAllItem.setText("selectAll");
        selectAllItem.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        selectAllItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                textArea.selectAll();
            }
        });

        deleteItem.setMnemonicParsing(false);
        deleteItem.setText("delete");
        deleteItem.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
        deleteItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                cliboardList.add(textArea.getSelectedText());
                textArea.deleteText(textArea.getSelection());
            }
        });
        // done Help Menue
        helpMenu.setMnemonicParsing(false);
        helpMenu.setText("Help");

        aboutItem.setMnemonicParsing(false);
        aboutItem.setText("About");
        aboutItem.setAccelerator(new KeyCodeCombination(KeyCode.B, KeyCombination.CONTROL_DOWN));
        aboutItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Alert alert = new Alert(AlertType.INFORMATION, "You pressed About Item in Help Menu");
                alert.show();
            }
        });

        cliboardItem.setMnemonicParsing(false);
        cliboardItem.setText("Cliboard");
        cliboardItem.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN));
        cliboardItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                observalList = FXCollections.observableArrayList(cliboardList);
                listView = new ListView(observalList);
                listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                Scene scene = new Scene(listView, 595, 200);

                s.setTitle("List View");
                s.setScene(scene);
                s.show();

                listView.getSelectionModel().selectedItemProperty().addListener(
                        (ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                            textArea.setText(textArea.getText() + "\n" + listView.getSelectionModel().getSelectedItems());
                            // System.out.println("dddddsds");
                            int index = listView.getSelectionModel().getSelectedIndex();
                            // textArea.setText(listView.getItems().get(index));
                            System.out.println("index + " + index);
                        });

                listView.getItems().addListener(new ListChangeListener<String>() {
                    @Override
                    public void onChanged(ListChangeListener.Change<? extends String> c) {
                        System.out.println("dddddsds");
                        int index = listView.getSelectionModel().getSelectedIndex();
                        textArea.setText(listView.getItems().get(index));
                        System.out.println("index + " + index);
                    }
                });
                //listView.getSelectionModel().getSelectedItems().get(0)
                // textArea.setText(/*listView.getSelectionModel().getSelectedItems().get(0)*/"Hello" );
                //listView.getItems().get(0));
                //listView.getSelectionModel().getSelectedItem()
                /*   TitledPane titledPane = new TitledPane();
                titledPane.setText("Your cliboard");               
                 VBox content = new VBox();
                 int counter = 0;
                 Label label = null;
                 for(String text : cliboardList){
                     counter++;
                     label = new Label(counter + "- " + text);
                     content.getChildren().add(label);
                 }

                titledPane.setContent(content);
                if(label != null)
                    textArea.setText( label.getText());
                Scene scene = new Scene(new Group(), 250, 200);
                Group roo = (Group) scene.getRoot();
                roo.getChildren().add(titledPane);
                Stage s = new Stage();
                s.setTitle("TitledPane (o7planning.org)");
                s.setScene(scene);
                s.show();*/
            }
        }
        );

        stage.setOnCloseRequest(
                new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event
            ) {
                ButtonType save = new ButtonType("Save");//ButtonType.OK;
                ButtonType cancel = new ButtonType("Donot Save");//ButtonType.CANCEL;
                ButtonType close = new ButtonType("Close");//ButtonType.CLOSE;
                String text = textArea.getText();
                if ((text.isEmpty() == true && currentText == null) || text.equals(currentText) == true || isNew == true) {
                    close();

                } else {
                    Alert alert = new Alert(AlertType.WARNING, "Do you want to save changes??", save, cancel, close);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == save) {
                        if (currentPath == null) {
                            FileChooser fileChooser = new FileChooser();
                            fileChooser.setTitle("Save File");
                            File selectedFile = fileChooser.showSaveDialog(stage);
                            if (selectedFile != null) {
                                String path = selectedFile.getPath();
                                currentPath = path;
                            }
                        }
                        try {
                            if (currentPath != null) {
                                FileOutputStream fileOutputStream = new FileOutputStream(currentPath);
                                byte[] textArray = textArea.getText().getBytes();
                                fileOutputStream.write(textArray);
                                textArea.setText(new String(textArray));
                                currentText = textArea.getText();
                                fileOutputStream.close();
                            } else {
                                System.err.println("You did not choose file to save\nPlease save the file to close");
                            }
                            //System.exit(0);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            event.consume();
                        }
                    } else {
                        if (result.get() == cancel) {
                            stage.close();
                        } else if (result.get() == close) {
                            System.out.println("You pressed cancel");
                            event.consume();
                        }
                    }
                }
            }

        }
        );
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);

        textArea.setPrefHeight(
                200.0);
        textArea.setPrefWidth(
                200.0);
        setCenter(textArea);

        fileMenu.getItems()
                .add(newItem);
        fileMenu.getItems()
                .add(openItem);
        fileMenu.getItems()
                .add(saveItem);
        fileMenu.getItems()
                .add(saveAsItem);
        fileMenu.getItems()
                .add(closeItem);
        menuBar.getMenus()
                .add(fileMenu);
        editMenu.getItems()
                .add(copyItem);
        editMenu.getItems()
                .add(cutItem);
        editMenu.getItems()
                .add(pasteItem);
        editMenu.getItems()
                .add(selectAllItem);
        editMenu.getItems()
                .add(deleteItem);
        menuBar.getMenus()
                .add(editMenu);
        helpMenu.getItems()
                .add(aboutItem);
        helpMenu.getItems()
                .add(cliboardItem);
        menuBar.getMenus()
                .add(helpMenu);

    }

    private void close() {
        s.close();
        stage.close();
        System.exit(0);
        Platform.exit();
    }
}
