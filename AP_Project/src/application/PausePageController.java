package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
    
	private int score;
	private int noOfStars;
	private int highScore;

	private double ballY;
	private int ballColour;
	private double starY;
	private double switcherY;
	private double squareY;
	private double cirlceY;
	private double plusY;
	private double triangleY;
	private int diffLevel;
	private double squareAngle;
	private double circleAngle;
	private double plusAngle;
	private double triangleAngle;
    
//	private ArrayList<Double> obstaclePositions=new ArrayList<Double>();

    public void initData(int score, double ballY, int ballColour, 
			double starY, double switcherY, double squareY, double cirlceY, double plusY, double triangleY, int diffLevel,
			double squareAngle, double circleAngle, double plusAngle, double triangleAngle) {

		this.diffLevel=diffLevel;
		this.score = score;
		this.ballY = ballY;
		this.ballColour = ballColour;
		this.starY = starY;
		this.switcherY = switcherY;
		this.squareY=squareY;
		this.triangleY=triangleY;
		this.plusY=plusY;
		this.cirlceY=cirlceY;
		this.squareAngle=squareAngle;
		this.circleAngle=circleAngle;
		this.plusAngle=plusAngle;
		this.triangleAngle=triangleAngle;
		
		this.highScore = Main.allGames.getHighScore();
		this.noOfStars = Main.allGames.getTotalStars();

	}

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
    	
    	GamePlayState gs = new GamePlayState(score, noOfStars, highScore, ballY, ballColour, starY
    			, switcherY, squareY, cirlceY, plusY, triangleY, diffLevel,
    			squareAngle, circleAngle, plusAngle, triangleAngle);
    	
    	Main.currStorage.addGamePlay(gs);
   
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
