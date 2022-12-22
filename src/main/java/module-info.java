module lr_4and6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens lr_4and6 to javafx.fxml;
    exports lr_4and6.controllers;
    opens lr_4and6.controllers to javafx.fxml;
    exports lr_4and6.models.application;
    opens lr_4and6.models.application to javafx.fxml;
}