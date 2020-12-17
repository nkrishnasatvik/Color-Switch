package application;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class SavedGameController {

	@FXML
	private AnchorPane SavedMenu;

	@FXML
	private Button backBT;

	@FXML
	private Button game1Button;

	@FXML
	private Button game2Button;

	@FXML
	private Button game3Button;

	@FXML
	private Label gameScore1;

	@FXML
	private Label gameScore2;

	@FXML
	private Label gameScore3;
	
    @FXML
    private Group savedGame1;
    
    @FXML
    private Group savedGame2;
    
    @FXML
    private Group savedGame3;
	
	@FXML
	void initialize(){
		
		this.savedGame1.setVisible(false);
		this.savedGame2.setVisible(false);
		this.savedGame3.setVisible(false);

		if(Main.currStorage.getListOfGames().size()>0) {
			
			this.savedGame1.setVisible(true);
			this.gameScore1.setText(Integer.toString(Main.currStorage.getListOfGames().get(0).getScore()));
		}
		if(Main.currStorage.getListOfGames().size()>1) {
			this.savedGame2.setVisible(true);
			this.gameScore2.setText(Integer.toString(Main.currStorage.getListOfGames().get(1).getScore()));
		}
		if(Main.currStorage.getListOfGames().size()>2) {
			this.savedGame3.setVisible(true);
			this.gameScore3.setText(Integer.toString(Main.currStorage.getListOfGames().get(2).getScore()));
		}
	}

	@FXML
	void backToMainPage(ActionEvent event) throws IOException {

		Parent GamePageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		Main.scene.setRoot(GamePageParent);

		Media buttonClick = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\buttonClick.wav").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(buttonClick);
		mediaPlayer.play();

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(Main.scene);
		window.show();

	}

	@FXML
	void button1Action(ActionEvent event) throws IOException {

		if(Main.currStorage.getListOfGames().size()>0) {

			GamePlayState savedGame1=Main.currStorage.getListOfGames().get(0);

			Main.currStorage.getListOfGames().remove(0);

			Main.allGames.setHighScore(savedGame1.getHighScore());
			Main.allGames.setTotalStars(savedGame1.getNoOfStars());

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("GamePage.fxml"));
			loader.load();

			GamePageController page = loader.getController();

			page.setGame(savedGame1.getScore(),
					savedGame1.getBallY(),
					savedGame1.getBallColour(),
					savedGame1.getStarY(),
					savedGame1.getSwitcherY(),
					savedGame1.getSquareY(),
					savedGame1.getCirlceY(),
					savedGame1.getPlusY(),
					savedGame1.getTriangleY(),
					savedGame1.getDiffLevel(),
					savedGame1.getSquareAngle(),
					savedGame1.getCircleAngle(),
					savedGame1.getPlusAngle(),
					savedGame1.getTriangleAngle());

			Parent GamePageParent = loader.getRoot();

			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

			Main.scene.setRoot(GamePageParent);
			window.setScene(Main.scene);
			window.show();

			Media buttonClick = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\buttonClick.wav").toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(buttonClick);
			mediaPlayer.play();

			Main.allGames.setCurrentGame(GamePageParent);
		}

		//    	Stage window = (Stage)Main.scene.getWindow();
		//    	window.setScene(Main.scene);
		//    	window.show();
	}

	@FXML
	void button2Action(ActionEvent event) throws IOException {

		if(Main.currStorage.getListOfGames().size()>1) {

			GamePlayState savedGame2=Main.currStorage.getListOfGames().get(1);

			Main.currStorage.getListOfGames().remove(1);

			Main.allGames.setHighScore(savedGame2.getHighScore());
			Main.allGames.setTotalStars(savedGame2.getNoOfStars());

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("GamePage.fxml"));
			loader.load();

			GamePageController page = loader.getController();

			page.setGame(savedGame2.getScore(),
					savedGame2.getBallY(),
					savedGame2.getBallColour(),
					savedGame2.getStarY(),
					savedGame2.getSwitcherY(),
					savedGame2.getSquareY(),
					savedGame2.getCirlceY(),
					savedGame2.getPlusY(),
					savedGame2.getTriangleY(),
					savedGame2.getDiffLevel(),
					savedGame2.getSquareAngle(),
					savedGame2.getCircleAngle(),
					savedGame2.getPlusAngle(),
					savedGame2.getTriangleAngle());

			Parent GamePageParent = loader.getRoot();

			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

			Main.scene.setRoot(GamePageParent);
			window.setScene(Main.scene);
			window.show();

			Media buttonClick = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\buttonClick.wav").toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(buttonClick);
			mediaPlayer.play();

			Main.allGames.setCurrentGame(GamePageParent);
		}
	}

	@FXML
	void button3Action(ActionEvent event) throws IOException {

		if(Main.currStorage.getListOfGames().size()>2) {

			GamePlayState savedGame3=Main.currStorage.getListOfGames().get(2);

			Main.currStorage.getListOfGames().remove(2);

			Main.allGames.setHighScore(savedGame3.getHighScore());
			Main.allGames.setTotalStars(savedGame3.getNoOfStars());

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("GamePage.fxml"));
			loader.load();

			GamePageController page = loader.getController();

			page.setGame(savedGame3.getScore(),
					savedGame3.getBallY(),
					savedGame3.getBallColour(),
					savedGame3.getStarY(),
					savedGame3.getSwitcherY(),
					savedGame3.getSquareY(),
					savedGame3.getCirlceY(),
					savedGame3.getPlusY(),
					savedGame3.getTriangleY(),
					savedGame3.getDiffLevel(),
					savedGame3.getSquareAngle(),
					savedGame3.getCircleAngle(),
					savedGame3.getPlusAngle(),
					savedGame3.getTriangleAngle());

			Parent GamePageParent = loader.getRoot();

			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

			Main.scene.setRoot(GamePageParent);
			window.setScene(Main.scene);
			window.show();

			Media buttonClick = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\buttonClick.wav").toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(buttonClick);
			mediaPlayer.play();

			Main.allGames.setCurrentGame(GamePageParent);

		}
	}

}
