package lr_4and6.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lr_4and6.models.application.App;
import lr_4and6.models.application.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static lr_4and6.models.application.App.users;


public class NotificationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Label SuccessLabel;

    @FXML
    void initialize() {
        String rez = "\t\t\t\tДобавлен новый пользователь!!!\n\n";
        for (User user:users) {
            rez+=user.toString() + '\n';
        }
        SuccessLabel.setText(rez);

        ExitButton.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/lr_4and6/enter-view.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = App.getStage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

}
