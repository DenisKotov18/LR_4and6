package lr_4and6.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lr_4and6.models.application.*;


public class AuthorizationController implements Observer {
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enter_button;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button register_button;

    @FXML
    private Label wrong_label;

    @FXML
    private void canselClick(MouseEvent event) {
        register_button.setTextFill(Paint.valueOf("black"));
    }
    @FXML
    private void pre_click(MouseEvent event) {
            register_button.setTextFill(Paint.valueOf("blue"));
    }

    @FXML
    void eraseEvent(MouseEvent event) {
        wrong_label.setVisible(false);
    }

    @FXML
    void initialize() {
        register_button.setOnAction(actionEvent -> {
            FXMLLoader register_loader = new FXMLLoader(AuthorizationController.class.getResource("/lr_4and6/register-view.fxml"));
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
            if(Autorization.entry(login_field.getText(), password_field.getText())){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MenuController.class.getResource("/lr_4and6/menu-view.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = App.getStage();
                stage.setScene(new Scene(root));
                stage.show();
            }else {
                wrong_label.setVisible(true);
            }
        });
    }

    @Override
    public void handleEvent() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/lr_4and6/New_User.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = App.getStage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
