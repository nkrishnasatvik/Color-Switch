package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
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
    	Main.scene.setRoot(GamePageParent);

    	Stage window = (Stage)Main.scene.getWindow();
    	window.setScene(Main.scene);
    	window.show();

	}
	
	@FXML
	public void respawnBTAction(ActionEvent event) throws IOException {

	}

	@FXML
	public void restartBTAction(ActionEvent event) throws IOException {

		Parent GamePageParent = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
    	Main.scene.setRoot(GamePageParent);

    	Stage window = (Stage)Main.scene.getWindow();
    	window.setScene(Main.scene);
    	window.show();

	}

	public void setLabels(int gamescore) {

		this.score.setText(Integer.toString(gamescore));
		
		Main.allGames.setTotalStars(Main.allGames.getTotalStars()+gamescore);
		this.totalStars.setText(Integer.toString(Main.allGames.getTotalStars()));

		if(Main.allGames.getHighScore() < gamescore) {
			Main.allGames.setHighScore(gamescore);
		}
		
		this.highScore.setText(Integer.toString(Main.allGames.getHighScore()));

	}

}