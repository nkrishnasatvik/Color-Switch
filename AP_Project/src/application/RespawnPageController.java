package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RespawnPageController {
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
	
	private static int noOfStars;
	private static int highScoreVal;
	private int scoreVal;
	

	// Event Listener on Button[#mainMenuButton].onAction
	@FXML
	public void mainMenuBTAction(ActionEvent event) throws IOException {
		
		Parent GamePageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
    	Scene GamePageScene = new Scene(GamePageParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(GamePageScene);
    	window.show();
    	
	}
	
	// Event Listener on Button[#respawnButton].onAction
	@FXML
	public void respawnBTAction(ActionEvent event) throws IOException {
		
	}
	
	// Event Listener on Button[#restartButton].onAction
	@FXML
	public void restartBTAction(ActionEvent event) throws IOException {
		
		Parent GamePageParent = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
    	Scene GamePageScene = new Scene(GamePageParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(GamePageScene);
    	window.show();
    	
	}
	
	public void setLabels(int gamescore) {
		
		this.score.setText(Integer.toString(gamescore));
		
		noOfStars += gamescore;
		this.totalStars.setText(Integer.toString(noOfStars));
		
		if(highScoreVal < gamescore) {
			highScoreVal = gamescore;
			this.highScore.setText(Integer.toString(highScoreVal));
		}
		
	}
}
