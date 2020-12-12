package application;

import java.io.IOException;

import javafx.animation.AnimationTimer;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GamePageController {

	@FXML
	private AnchorPane anchorPane;

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
	private ImageView star;

	@FXML
	private Group starGroup;

	AnimationTimer timer;

	AnimationTimer infiniteTimer;
	
	RotateTransition rt;

	public void ballDown() {
		
		double dy = -1.5;

		ball.setLayoutY(ball.getLayoutY() - dy);

	}

	public void ballUp() {

		double dy = +2;

		ball.setLayoutY(ball.getLayoutY() - dy);


	}


	@FXML
	public void initialize() {

		timer = new AnimationTimer() {
			@Override
			public void handle(long l) {
				ballDown();
			}

		};

		timer.start();

		infiniteTimer = new AnimationTimer() {
			@Override
			public void handle(long l) {
				try {
					collisions();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};

		infiniteTimer.start();

		this.rt = new RotateTransition();
		rt.setDuration(Duration.millis(50000));
		rt.setNode(SquareObstacle);
		rt.setByAngle(3600);
		rt.setCycleCount(Timeline.INDEFINITE);
		rt.setAutoReverse(false);
		rt.play();



	}

	@FXML
	void displayPausePage(ActionEvent event) throws IOException {

		Parent GamePageParent = FXMLLoader.load(getClass().getResource("PausePage.fxml"));
		Scene GamePageScene = new Scene(GamePageParent);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(GamePageScene);
		window.show();
	}

	private void collisions() throws IOException {

		boolean colorSwitchCollision = false;
		boolean starCollision=false;
		boolean squareObstacleDeath=false;

		for (Node static_bloc : anchorPane.getChildren()) {
			if (static_bloc ==this.ColorSwitcher) {

				if (ball.getBoundsInParent().intersects(static_bloc.getBoundsInParent()) ) {
					colorSwitchCollision = true;
				}
			}
			if(static_bloc==this.starGroup) {
				if (ball.getBoundsInParent().intersects(static_bloc.getBoundsInParent()) ) {
					starCollision = true;
				}
			}
			
			if(static_bloc==this.SquareObstacle) {
				if (ball.getBoundsInParent().intersects(static_bloc.getBoundsInParent()) ) {	
//					

					for(Node line:this.SquareObstacle.getChildren()) {
						
					}
//					
				}
			}

//			System.out.println(this.starGroup.getId()+" "+static_bloc.toString());
		}

		if (colorSwitchCollision) {


			if(ball.getFill()==Color.BLUE) {
				ball.setFill(Color.RED);
			}
			else if(ball.getFill()==Color.RED) {
				ball.setFill(Color.YELLOW);
			}
			else if(ball.getFill()==Color.YELLOW) {
				ball.setFill(Color.PURPLE);
			}
			else {
				ball.setFill(Color.BLUE);
			}
			
			this.ColorSwitcher.setLayoutY(this.ColorSwitcher.getLayoutY()+500);
		}

		if(starCollision) {
			
			int x=Integer.parseInt(scoreLabel.getText());
			
			scoreLabel.setText(Integer.toString(x+1));

			this.starGroup.setLayoutY(this.starGroup.getLayoutY()+500);
		}

		//		System.out.println(starCollision);
	}

	@FXML
	public void ballBounce(ActionEvent event) throws IOException {		

		timer.stop();

		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(300), 
				new KeyValue(ball.layoutYProperty(), ball.getLayoutY()-70)));
		timeline.setCycleCount(1);
		timeline.play();

		timer.start();

	}

}
