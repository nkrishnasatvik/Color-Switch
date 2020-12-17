package application;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PausePageController {

    @FXML
    private AnchorPane PausedScreen;

    @FXML
    private Button resumeBT;

    @FXML
    private Button saveBT;

    @FXML
    void resumeBTAction(ActionEvent event) throws IOException {
    	
    	GamePageController.playyy=true;
//    	
//    	Parent GamePageParent = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
    	Main.scene.setRoot(Main.allGames.getCurrentGame());
    	
    	Media buttonClick = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(buttonClick);
        mediaPlayer.play();
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(Main.scene);
    	window.show();
    	
    }

    @FXML
    void saveBTAction(ActionEvent event) throws IOException {
   
    	Parent GamePageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
    	Main.scene.setRoot(GamePageParent);

    	Media buttonClick = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(buttonClick);
        mediaPlayer.play();
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(Main.scene);
    	window.show();
    }

}
