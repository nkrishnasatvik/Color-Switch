package application;

import java.io.IOException;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GamePageController {


    @FXML
    private Button pauseBT;
    
    @FXML
    private Circle ball;

    @FXML
    private Group SquareObstacle;

    @FXML
    private Group Triangle;

    @FXML
    private Group Plus;

    @FXML
    private Group Circle;

    @FXML
    private Button startBT;
    
    @FXML
    private Group ColorSwitcher;

    @FXML
    public void startGame(ActionEvent event) {
    	
    	RotateTransition rT = new RotateTransition();
    	rT.setDuration(Duration.millis(3000));
    	rT.setNode(SquareObstacle);
    	rT.setByAngle(360);
    	rT.setCycleCount(Timeline.INDEFINITE);
    	rT.setAutoReverse(false);
    	rT.play();
    	
    }
    
    @FXML
    void displayPausePage(ActionEvent event) throws IOException {
    	
    	Parent GamePageParent = FXMLLoader.load(getClass().getResource("PausePage.fxml"));
    	Scene GamePageScene = new Scene(GamePageParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(GamePageScene);
    	window.show();
    }
    
    

}
