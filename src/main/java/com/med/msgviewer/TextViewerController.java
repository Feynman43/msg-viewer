package com.med.msgviewer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TextViewerController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}