import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

/**
 * This is the driver class for the Twitter assignment.
 * Worked on this assignment with Ying Ying Choi, and
 * used Java API.
 * @author Sujeeth Jinesh
 * @version 1.0
 **/
public class Twitter extends Application {

    private ArrayList<Tweet> allTweets = new ArrayList<Tweet>();
    private ArrayList<Boolean> allLikes = new ArrayList<Boolean>();
    private HBox hbox = new HBox(20);

    /**
     * This is the start method
     * @param stage Takes in the stage/window
     * @throws Exception Throws Exception
     */
    @Override
    public void start(final Stage stage) throws Exception {

        TwitterServer ts = new TwitterServer();

        String name = "";
        String twitterHandle = "";
        String imageFile = "";
        String description = "";
        String message = "";

        allTweets.add(ts.randTweet());
        allLikes.add(false);

        name = allTweets.get(allTweets.size() - 1).getUser().getName();
        twitterHandle = allTweets.get(allTweets.size()
                - 1).getUser().getTwitterHandle();
        imageFile = allTweets.get(allTweets.size() - 1).getUser().getImage();
        description = allTweets.get(allTweets.size()
                - 1).getUser().getDescription();
        message = ts.randMessage();

        final User currentUser = new User(name,
                twitterHandle, imageFile, description);

        final VBox tweetBox = new VBox(20);
        final ScrollPane sp = new ScrollPane();

        VBox userBox = new VBox(20);
        ImageView userim = new ImageView();
        userim.setImage(new Image(currentUser.getImage()));

        Text nameText = new Text(currentUser.getName());
        Text descriptionText = new Text(currentUser.getDescription());

        final TextField userSpace = new TextField();
        userSpace.setPromptText("Enter text here!");

        Button tweetButton = new Button("Tweet");
        tweetButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                tweet(userSpace.getText(), currentUser, tweetBox);
            }
        });

        final Button refresh = new Button("Refresh");
        refresh.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                refresh(tweetBox, currentUser);
            }
        });

        userBox.getChildren().addAll(refresh, userim,
                nameText, descriptionText,
                userSpace, tweetButton);

        hbox.getChildren().addAll(userBox, tweetBox);
        Scene scene = new Scene(hbox, 1500, 1000);
        stage.setTitle("Twitter");
        stage.setScene(scene);
        stage.show();

        Button delete = new Button("Delete");
        Button like = new Button("Like");
    }

    /**
     * This is to refresh the page
     * @param vBox This is the pane
     * @param currentUser This is the current user
     */
    public void refresh(final VBox vBox, User currentUser) {
        TwitterServer ts = new TwitterServer();

        String name = "";
        String twitterHandle = "";
        String imageFile = "";
        String description = "";
        String message = "";

        Random rand = new Random();

        for (int i = 0; i < rand.nextInt(4) + 2; i++) {
            allTweets.add(ts.randTweet());
            allLikes.add(false);

            name = allTweets.get(allTweets.size() - 1).getUser().getName();
            twitterHandle = allTweets.get(allTweets.size()
                    - 1).getUser().getTwitterHandle();
            imageFile = allTweets.get(allTweets.size()
                    - 1).getUser().getImage();
            description = allTweets.get(allTweets.size()
                    - 1).getUser().getDescription();
            message = ts.randMessage();

            User tempUser = new User(name,
                    twitterHandle,
                    imageFile,
                    description);

            final Tweet tempTweet = new Tweet(tempUser, message);

            vBox.getChildren().add(tempTweet);
            if (tempUser.equals(currentUser)) {
                Button delete = new Button("delete");
                vBox.getChildren().add(delete);
                delete.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        delete(tempTweet, vBox);
                    }
                });
            }
        }
    }

    /**
     * Deletes the tweet at the given index.
     * @param tweet this is the tweet
     * @param vbox this is the pane
     */
    public void delete(Tweet tweet, VBox vbox) {
        for (int i = 0; i < allTweets.size(); i++) {
            if (allTweets.get(i).equals(tweet)) {
                vbox.getChildren().remove(allTweets.get(i));
                allTweets.remove(i);
            }
        }
    }

    /**
     * Makes the tweet for the current user.
     * @param message Message the user typed out
     * @param currentUser the current user of the account
     * @param vBox the pane we will be updating
     */
    public void tweet(String message, User currentUser, VBox vBox) {
        Tweet newTweet = new Tweet(currentUser, message);
        allTweets.add(0, newTweet);
        vBox.getChildren().add(allTweets.get(0));
    }
}
