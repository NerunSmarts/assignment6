module com.nerunsmarts {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.nerunsmarts to javafx.fxml;
    exports com.nerunsmarts;
}
