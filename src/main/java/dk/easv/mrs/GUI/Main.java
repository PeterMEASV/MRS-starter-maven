package dk.easv.mrs.GUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/MovieView.fxml"));
        primaryStage.setTitle("MRS");
        primaryStage.setScene(new Scene(root, 340, 422));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
