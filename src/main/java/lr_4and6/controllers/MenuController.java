package lr_4and6.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lr_4and6.models.application.App;
import lr_4and6.models.application.Order;
import lr_4and6.models.application.User;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exit_btn;

    @FXML
    private Button my_order_btn;

    @FXML
    private Button order_btn;

    @FXML
    void initialize() {
        exit_btn.setOnAction(actionEvent -> {
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
        order_btn.setOnAction(actionEvent -> {
            User.getOnline().setLast_order(new Order());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuController.class.getResource("/lr_4and6/order-view.fxml"));
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
        my_order_btn.setOnAction(actionEvent1 -> {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MenuController.class.getResource("/lr_4and6/myOrders-view.fxml"));
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
