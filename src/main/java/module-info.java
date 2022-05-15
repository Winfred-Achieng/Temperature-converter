module com.example.tempconve {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tempconve to javafx.fxml;
    exports com.example.tempconve;
}