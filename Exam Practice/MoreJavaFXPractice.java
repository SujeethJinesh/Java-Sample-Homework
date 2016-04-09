import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MoreJavaFXPractice extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Stage window = stage;

        TextField input = new TextField();
        input.setPromptText("enter r or t or c");

        Button submit = new Button("submit");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        grid.setConstraints(input, 0, 0);
        grid.setConstraints(submit, 1, 0);
        grid.getChildren().addAll(input, submit);
        submit.setOnAction(e -> draw(input.getText(), grid));
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.show();
    }

    public void draw(String input, GridPane grid) {
        switch (input) {
            case "t":
                Label text = new Label("this is text");
                grid.getChildren().add(text);
                grid.setConstraints(text, 2, 0);
                break;
            case "r":
                Rectangle rect = new Rectangle(100, 200);
                grid.getChildren().add(rect);
                grid.setConstraints(rect, 2, 0);
                break;
            case "c":
                Circle circ = new Circle(300);
                grid.getChildren().addAll(circ);
                grid.setConstraints(circ, 2, 0);
                break;
            default:
                break;
        }
    }
}
