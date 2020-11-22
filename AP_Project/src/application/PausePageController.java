package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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
    	
    	Parent GamePageParent = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
    	Scene GamePageScene = new Scene(GamePageParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(GamePageScene);
    	window.show();
    }

    @FXML
    void saveBTAction(ActionEvent event) throws IOException {
    	
    	Parent GamePageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
    	Scene GamePageScene = new Scene(GamePageParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(GamePageScene);
    	window.show();
    }

}
