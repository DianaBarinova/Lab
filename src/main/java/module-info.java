module com.example.tttttttttt {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.tttttttttt to javafx.fxml;
    exports com.example.tttttttttt;
}