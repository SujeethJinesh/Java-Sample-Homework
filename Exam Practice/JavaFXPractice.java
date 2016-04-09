import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXPractice extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label l1 = new Label("This is my label");
        stage.setTitle("This is the title");
        VBox layout1 = new VBox(20);
        Scene scene1 = new Scene(layout1);

        Button button1 = new Button("go to scene 2");
        layout1.getChildren().addAll(l1, button1);


        Label l2 = new Label("This is scene 2");
        Stage stage2 = new Stage();
        StackPane layout2Pane = new StackPane();
        Scene layout2 = new Scene(layout2Pane);
        Button button2 = new Button("Hit me to go back to scene 1");
        layout2Pane.getChildren().addAll(l2, button2);
        stage2.setScene(layout2);

        button1.setOnAction(e -> stage.setScene(layout2));
        button2.setOnAction(e -> stage.setScene(scene1));

        stage.setScene(scene1);
        stage.show();
    }
}
