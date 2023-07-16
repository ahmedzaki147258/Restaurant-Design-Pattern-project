module com.example.restrant {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.restrant to javafx.fxml;
    exports com.example.restrant;
}