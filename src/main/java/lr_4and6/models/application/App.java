package lr_4and6.models.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lr_4and6.models.database.MySerialize;

import java.io.IOException;
import java.util.ArrayList;

public class App extends Application {
    static Stage stage;
    public static ArrayList<User> users = MySerialize.readUsers();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/lr_4and6/enter-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 654, 437);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        App.stage = stage;
    }

    public static Stage getStage(){
        return stage;
    }
    public static void main(String[] args) {
        launch();
    }
}