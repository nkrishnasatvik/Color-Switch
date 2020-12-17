package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class respawnPageController {

	@FXML
	private AnchorPane PausedScreen;
	@FXML
	private Button mainMenuButton;
	@FXML
	private Button respawnButton;
	@FXML
	private Label totalStars;
	@FXML
	private Label score;
	@FXML
	private Label highScore;

	@FXML
	private Button restartButton;

	@FXML
	public void mainMenuBTAction(ActionEvent event) throws IOException {

		Parent GamePageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		
		
		Media buttonClick = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(buttonClick);
        mediaPlayer.play();

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Main.scene.setRoot(GamePageParent);
		window.setScene(Main.scene);
		window.show();

	}

	@FXML
	public void respawnBTAction(ActionEvent event) throws IOException {

		if(Main.allGames.getTotalStars()>=3) {
	        
			Main.allGames.setTotalStars(Main.allGames.getTotalStars()-3);
			GamePageController.playyy=true;

			Main.scene.setRoot(Main.allGames.getCurrentGame());
			
			Media respawn = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\touchRespawn.wav").toURI().toString());
	        MediaPlayer mediaPlayer = new MediaPlayer(respawn);
	        mediaPlayer.play();

			Stage window = (Stage)Main.scene.getWindow();
			window.setScene(Main.scene);
			window.show();
		}

	}

	@FXML
	public void restartBTAction(ActionEvent event) throws IOException {

		Parent GamePageParent = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
		Main.scene.setRoot(GamePageParent);

		Main.allGames.setCurrentGame(GamePageParent);
		
		Media buttonClick = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\buttonClick.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(buttonClick);
        mediaPlayer.play();

		Stage window = (Stage)Main.scene.getWindow();
		window.setScene(Main.scene);
		window.show();

	}

	public void setLabels(int gamescore,int tempscore) {

		this.score.setText(Integer.toString(gamescore));
		
		Main.allGames.setTotalStars(Main.allGames.getTotalStars()+tempscore);
		this.totalStars.setText(Integer.toString(Main.allGames.getTotalStars()));

		if(Main.allGames.getHighScore() < gamescore) {
			Main.allGames.setHighScore(gamescore);
		}

		this.highScore.setText(Integer.toString(Main.allGames.getHighScore()));

	}

}