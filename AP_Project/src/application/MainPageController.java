package application;

import java.io.File;
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;

public class MainPageController {

    @FXML
    private AnchorPane MainPage;

    @FXML
    private Button savedGamesButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button newGameButton;
    
    public AnchorPane getMainPage() {
		return MainPage;
	}

	public void setMainPage(AnchorPane mainPage) {
		this.MainPage = mainPage;
	}

    @FXML
    public void startGamePage(ActionEvent event) throws IOException {
    	
    	Parent GamePageParent = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
    	Main.scene.setRoot(GamePageParent);
    	
    	Media buttonClick = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(buttonClick);
        mediaPlayer.play();
    	
    	Main.allGames.setCurrentGame(GamePageParent);
    	
    	Stage window = (Stage)Main.scene.getWindow();
    	window.setScene(Main.scene);
    	window.show();
    	
    }

	@FXML
    void displaySavedPage(ActionEvent event) throws IOException {

    	Parent GamePageParent = FXMLLoader.load(getClass().getResource("SavedGamesPage.fxml"));
    	Scene GamePageScene = new Scene(GamePageParent);
    	
    	Media buttonClick = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(buttonClick);
        mediaPlayer.play();
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(GamePageScene);
    	window.show();
    }
	
	@FXML
	void exitGame(ActionEvent e) throws IOException {
		
		Media buttonClick = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(buttonClick);
        mediaPlayer.play();
        
        Main.serialize();
        
		Platform.exit();
		System.exit(0);
	}
}
