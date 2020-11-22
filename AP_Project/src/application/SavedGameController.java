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

public class SavedGameController {

    @FXML
    private AnchorPane SavedMenu;

    @FXML
    private Button backBT;

    @FXML
    void backToMainPage(ActionEvent event) throws IOException {
    	
    	Parent GamePageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
    	Scene GamePageScene = new Scene(GamePageParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(GamePageScene);
    	window.show();

    }

}
