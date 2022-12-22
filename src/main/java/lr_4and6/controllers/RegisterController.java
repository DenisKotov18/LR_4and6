package lr_4and6.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lr_4and6.models.application.*;

public class RegisterController {

    @FXML
    private Button enter_button;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button back_button;

    @FXML
    private void canselClick(MouseEvent event) {
        back_button.setTextFill(Paint.valueOf("black"));
    }
    @FXML
    private void pre_click(MouseEvent event) {
        back_button.setTextFill(Paint.valueOf("blue"));
    }

    @FXML
    void initialize() {
        back_button.setOnAction(actionEvent -> {
            FXMLLoader register_loader = new FXMLLoader(RegisterController.class.getResource("/lr_4and6/enter-view.fxml"));
            try {
                register_loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = App.getStage();
            stage.setScene(new Scene(register_loader.getRoot()));
            stage.show();
        });
        enter_button.setOnAction(actionEvent -> {
            User user = new User(login_field.getText(),password_field.getText());
            (new Notifier()).addObserver(user);
        });
    }


}
