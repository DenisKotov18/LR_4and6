package lr_4and6.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import lr_4and6.models.application.App;
import lr_4and6.models.application.Order;
import lr_4and6.models.application.Product;
import lr_4and6.models.application.User;

public class MyOrdersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private TableView<Order> my_orders_table;

    @FXML
    private TableColumn<Order, Integer> order_cost;

    @FXML
    private TableColumn<Order, Integer> order_num;

    @FXML
    void initialize() {
        ObservableList<Order> orders = FXCollections.observableArrayList(User.getOnline().getOrders());

        order_num.setCellFactory( new Callback<>()
        {
            @Override
            public TableCell call( TableColumn p )
            {
                return new TableCell()
                {
                    @Override
                    public void updateItem( Object item, boolean empty )
                    {
                        super.updateItem( item, empty );
                        setGraphic( null );
                        setText( empty ? null : getIndex() + 1 + "" );
                    }
                };
            }
        });
        order_num.setSortable(false);
        order_cost.setCellValueFactory(new PropertyValueFactory<>("price"));
        my_orders_table.setItems(orders);
        ExitButton.setOnAction(actionEvent -> {
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

    }

}
