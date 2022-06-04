package com.med.msgviewer;

import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextViewerController {
    public Label PathOfFile;
    public TextArea FormattedTextArea;
    public TextFlow ColoredViewer;

    public void onMenuOpen(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(Main.stage);
        if (file == null) {
            return;
        }

        Scanner scanner;
        try {
            scanner = new Scanner(new FileInputStream(file));
            PathOfFile.setText(String.valueOf(file));
        } catch (FileNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage());
            return;
        }

        String fileContent = "";
        while (scanner.hasNextLine()) {
            fileContent += scanner.nextLine() + "\n";
        }


        FormattedTextArea.setText(MessageFormatter.formatter(fileContent));
        FormattedTextArea.setEditable(false);

        Text text1=new Text(fileContent);
        text1.setStyle("-fx-font-weight: bold");
        text1.setFill(Color.RED);

        ColoredViewer.getChildren().add(text1);
    }
}