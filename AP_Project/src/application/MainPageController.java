package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    

    @FXML
    void displaySavedPage(ActionEvent event) throws IOException {

    	Parent GamePageParent = FXMLLoader.load(getClass().getResource("SavedGamesPage.fxml"));
    	Scene GamePageScene = new Scene(GamePageParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(GamePageScene);
    	window.show();
    }
    
    

}
