module main {
    requires javafx.controls;
    requires javafx.fxml;

    opens hw to javafx.fxml;
    exports hw;
}
