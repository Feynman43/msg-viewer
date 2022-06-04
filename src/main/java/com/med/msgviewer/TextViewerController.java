package com.med.msgviewer;

import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;

public class TextViewerController {
    public Label PathOfFile;
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

        //loading the file content
        //TODO: add validation for file formatting
        String fileContent = "";
        while (scanner.hasNextLine()) {
            fileContent += scanner.nextLine() + "\n";
        }

        for (String[] message : MessageFormatter.formatter(fileContent)){
            Text Time = new Text("[" + message[0] + "]");

            Text Name = new Text(message[1] + ":");
            Name.setStyle("-fx-font-weight: bold");
            Name.setFill(Color.BLUE);

            Text Message = new Text(message[2]);
            Message.setFill(Color.BLACK);

            ColoredViewer.getChildren().addAll(Time, Name);
            if (Message.getText().contains(":)")) {
                ColoredViewer.getChildren().addAll(MessageFormatter.emojiHandlerHappy(Message));
                ColoredViewer.getChildren().add(new Text("\n"));

            }

/*            if (Message.getText().contains(":(")) {
                ColoredViewer.getChildren().addAll(MessageFormatter.emojiHandlerSad(Message));
                ColoredViewer.getChildren().add(new Text("\n"));
            } */

            else {
                ColoredViewer.getChildren().add(Message);
                ColoredViewer.getChildren().add(new Text("\n"));
            }
/*            for (Object msgChunk: MessageFormatter.emojiHandler(Message)) {
                ColoredViewer.getChildren().addAll(msgChunk);
            }*/



        }
    }
}