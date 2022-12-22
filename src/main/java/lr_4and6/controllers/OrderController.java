package lr_4and6.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lr_4and6.models.application.App;

import lr_4and6.models.application.User;

public class OrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton1;

    @FXML
    private Button bascket_button;

    @FXML
    void appleAction(MouseEvent event) {
        User.getOnline().getLast_order().addApple();
    }

    @FXML
    void cakeAction(MouseEvent event) {
        User.getOnline().getLast_order().addCake();
    }

    @FXML
    void coffeeAction(MouseEvent event) {
        User.getOnline().getLast_order().addCoffee();
    }

    @FXML
    void teaAction(MouseEvent event) {
        User.getOnline().getLast_order().addTea();

    }

    @FXML
    void initialize() {
        ExitButton1.setOnAction(actionEvent -> {
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
        });
        bascket_button.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuController.class.getResource("/lr_4and6/bascket-view.fxml"));
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
