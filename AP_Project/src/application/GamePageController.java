package application;

import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
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
	 private Label scoreLabel;

	@FXML
	private Button bounce;

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

	@FXML
	public void ballBounce(ActionEvent event) {
		
		int x=Integer.parseInt(scoreLabel.getText());
		
		scoreLabel.setText(Integer.toString(x+1));
		
		double initialpos= ball.getLayoutY();
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), 
				new EventHandler<ActionEvent>() {

					double dy = 3; //Step on y

					@Override
					public void handle(ActionEvent t) {
						
						
						ball.setLayoutY(ball.getLayoutY() - dy);

						Bounds bounds = ball.getParent().getBoundsInLocal();

						if(ball.getLayoutY() <= (initialpos-70 + ball.getRadius())){

//							if(dy>0);
//							else 
								dy = -dy;

						}
					}
				}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		//    		   } 
		//    		};   
		//    		//Adding event Filter 
		//    		Circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
	}



}
