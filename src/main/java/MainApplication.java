import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {

    public void start(Stage myStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("GUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        myStage.setTitle("Calculator");
        myStage.setScene(scene);
        myStage.show();
    }
}

