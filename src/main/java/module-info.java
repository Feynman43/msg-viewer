module com.med.msgviewer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.med.msgviewer to javafx.fxml;
    exports com.med.msgviewer;
}