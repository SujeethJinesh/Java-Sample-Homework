import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by lab on 4/12/2016.
 */
public class ToDoList extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane borderPane = new BorderPane();
        TextField tf = new TextField("Input here:");
        Button go = new Button("Go");

        HBox hBox = new HBox();
        ArrayList<HBox> arr = new ArrayList<>();
        Observable
        hBox.getChildren().addAll(tf, go);

        borderPane.setLeft(hBox);

        go.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String n = tf.getText();
                tf.clear();
                Text text = new Text(n);
                Button check = new Button("Check");
                HBox hBox1 = new HBox();
                hBox1.getChildren().addAll(text, check);
            }
        });

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
