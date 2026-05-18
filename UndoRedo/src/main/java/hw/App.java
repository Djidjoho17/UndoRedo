package hw;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));
        Parent p = fxmlLoader.load();
        scene = new Scene(p);
        stage.setScene(scene);
        stage.setTitle("HW2 - Undo/Redo");
        stage.show();
        Controller controller = (Controller) fxmlLoader.getController();
        scene.setOnKeyPressed(e -> {
            controller.keyHandler(e);
        });
    }

    public static void main(String[] args) {
        launch();
    }

}