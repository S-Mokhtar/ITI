package nottepad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.IndexRange;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UIBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem new1;
    protected final MenuItem open;
    protected final MenuItem save;
    protected final SeparatorMenuItem separatorMenuItem;
    protected final MenuItem exit;
    protected final Menu menu0;
    protected final MenuItem undo;
    protected final SeparatorMenuItem separatorMenuItem0;
    protected final MenuItem cut;
    protected final MenuItem copy;
    protected final MenuItem paste;
    protected final MenuItem delete;
    protected final SeparatorMenuItem separatorMenuItem1;
    protected final MenuItem selectall;
    protected final Menu menu1;
    protected final TextArea textArea;
    protected final MenuItem about;
    boolean isnew = false;
    static Stage stage = new Stage();
    String cpath;
    String ctext;

    public UIBase() {
menu1 = new Menu();
        textArea = new TextArea();
        menuBar = new MenuBar();
        menu = new Menu();
        new1 = new MenuItem();
        new1.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        new1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea.clear();
                isnew = true;
            }
        });
        open = new MenuItem();
        open.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        open.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().add(
                        new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt")
                );
                File fileToLoad = fileChooser.showOpenDialog(stage);
                if (fileToLoad != null) {
                    String path = fileToLoad.getPath();
                    try {
                        FileInputStream fileInputStream = new FileInputStream(path);
                        byte[] text = new byte[fileInputStream.available()];
                        fileInputStream.read(text);
                        textArea.setText(new String(text));
                        ctext = textArea.getText();
                        fileInputStream.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(UIBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(UIBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        save = new MenuItem();
        save.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (cpath == null) {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.getExtensionFilters().add(
                            new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt")
                    );
                    fileChooser.setTitle("Save File");
                    File selectedFile = fileChooser.showSaveDialog(stage);
                    if (selectedFile != null) {
                        String path = selectedFile.getPath();
                        cpath = path;
                    }
                }
                if (cpath != null) {
                    try {
                        try (FileOutputStream fileOutputStream = new FileOutputStream(cpath)) {
                            byte[] text = textArea.getText().getBytes();
                            fileOutputStream.write(text);
                            textArea.setText(new String(text));
                            ctext = textArea.getText();
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(UIBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(UIBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        separatorMenuItem = new SeparatorMenuItem();
        exit = new MenuItem();
        exit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        menu0 = new Menu();
        undo = new MenuItem();
        undo.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN));
        undo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
//                IndexRange s=textArea.getSelection();
//                String st=s.toString();
//               String str= textArea.getText();
//               str.undo();
                textArea.undo();
            }
        });
        separatorMenuItem0 = new SeparatorMenuItem();
        cut = new MenuItem();
        cut.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        cut.setOnAction((ActionEvent event) -> {
            textArea.cut();
});
        copy = new MenuItem();
        copy.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        copy.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea.copy();
            }
        });
        paste = new MenuItem();
        paste.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
        paste.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea.paste();
            }
        });
        delete = new MenuItem();
        delete.setAccelerator(new KeyCodeCombination(KeyCode.DELETE));
        delete.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea.deleteText(textArea.getSelection());
            }
        });
        separatorMenuItem1 = new SeparatorMenuItem();
        selectall = new MenuItem();
        selectall.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        selectall.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea.selectAll();
            }
        });
        
        about = new MenuItem();
        about.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("It is a NotePad Help");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        });
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        menu.setMnemonicParsing(false);
        menu.setText("File");

        new1.setMnemonicParsing(false);
        new1.setText("New");

        open.setMnemonicParsing(false);
        open.setText("Open...");

        save.setMnemonicParsing(false);
        save.setText("Save");

        separatorMenuItem.setMnemonicParsing(false);

        exit.setMnemonicParsing(false);
        exit.setText("Exit");

        menu0.setMnemonicParsing(false);
        menu0.setText("Edit");

        undo.setMnemonicParsing(false);
        undo.setText("Undo");

        separatorMenuItem0.setMnemonicParsing(false);

        cut.setMnemonicParsing(false);
        cut.setText("Cut");

        copy.setMnemonicParsing(false);
        copy.setText("Copy");

        paste.setMnemonicParsing(false);
        paste.setText("Paste");

        delete.setMnemonicParsing(false);
        delete.setText("Delete");

        separatorMenuItem1.setMnemonicParsing(false);

        selectall.setMnemonicParsing(false);
        selectall.setText("Select All");

        menu1.setMnemonicParsing(false);
        menu1.setText("Help");

        about.setMnemonicParsing(false);
        about.setText("About Notepad");
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setId("textarea");
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        menu.getItems().add(new1);
        menu.getItems().add(open);
        menu.getItems().add(save);
        menu.getItems().add(separatorMenuItem);
        menu.getItems().add(exit);
        menuBar.getMenus().add(menu);
        menu0.getItems().add(undo);
        menu0.getItems().add(separatorMenuItem0);
        menu0.getItems().add(cut);
        menu0.getItems().add(copy);
        menu0.getItems().add(paste);
        menu0.getItems().add(delete);
        menu0.getItems().add(separatorMenuItem1);
        menu0.getItems().add(selectall);
        menuBar.getMenus().add(menu0);
        menu1.getItems().add(about);
        menuBar.getMenus().add(menu1);

    }
}
