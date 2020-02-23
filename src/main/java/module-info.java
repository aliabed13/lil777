module lil7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens lil7 to javafx.fxml;
    exports lil7;
}