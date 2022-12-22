package lr_4and6.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lr_4and6.models.application.App;
import lr_4and6.models.application.Product;
import lr_4and6.models.application.User;

public class BascketController {

    @FXML
    private ResourceBundle resources;

    private ObservableList<Product> products = FXCollections.observableArrayList(User.getOnline().getLast_order().getProducts());
    @FXML
    private URL location;

    @FXML
    private Button exit_button;

    @FXML
    private Button order_button;

    @FXML
    void revertClick() {
            User.revertOrder();
            column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            products = FXCollections.observableArrayList(User.getOnline().getLast_order().getProducts());
            orders_table.setItems(products);
    }

    @FXML
    private TableColumn<Product, String> column_name;

    @FXML
    private TableView<Product> orders_table;

    @FXML
    private Button revert_button;

    @FXML
    void initialize() {
        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        orders_table.setItems(products);
        order_button.setOnAction(actionEvent -> {
            User.saveOrder();
            User.getOnline().saveOrderToList();
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
        exit_button.setOnAction(actionEvent -> {
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

    }

}
