package application;

import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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

    @FXML
    public void startGamePage(ActionEvent event) throws IOException {
    	
    	Parent GamePageParent = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
    	Scene GamePageScene = new Scene(GamePageParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(GamePageScene);
    	window.show();
    	
    	
    }
    

    public AnchorPane getMainPage() {
		return MainPage;
	}


	public void setMainPage(AnchorPane mainPage) {
		MainPage = mainPage;
	}


	@FXML
    void displaySavedPage(ActionEvent event) throws IOException {

    	Parent GamePageParent = FXMLLoader.load(getClass().getResource("SavedGamesPage.fxml"));
    	Scene GamePageScene = new Scene(GamePageParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(GamePageScene);
    	window.show();
    }
    
    

}
