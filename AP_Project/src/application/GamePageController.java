package application;

import java.io.IOException;
import java.util.*;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
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

	private AnimationTimer timer;

	private AnimationTimer infiniteTimer;

	private ArrayList<Group> obstacles;

	RotateTransition rt1;
	RotateTransition rt2;
	RotateTransition rt3;
	RotateTransition rt4;

	public void ballDown() {

		double dy = -1.5;
		ball.setLayoutY(ball.getLayoutY() - dy);

	}
	
	
	public void obstaclesUp() {
		if(this.SquareObstacle.getLayoutY()>500) {
			this.SquareObstacle.setLayoutY(this.SquareObstacle.getLayoutY()-1200);
		}
		
		else if(this.Triangle.getLayoutY()>500) {
			this.Triangle.setLayoutY(this.Triangle.getLayoutY()-1200);
		}
		
		else if(this.Plus.getLayoutY()>500) {
			this.Plus.setLayoutY(this.Plus.getLayoutY()-1200);
		}
		
		else if(this.Circle.getLayoutY()>500) {
			this.Circle.setLayoutY(this.Circle.getLayoutY()-1200);
		}
	}
//
//	public void ballUp() {
//
//		double dy = +1.5;
//		ball.setLayoutY(ball.getLayoutY() - dy);
//
//	}
	
	public void stopGame(){
		
	}

	@FXML
	public void initialize() {

		obstacles=new ArrayList<Group>();
		obstacles.add(this.SquareObstacle);
		obstacles.add(this.Circle);
		obstacles.add(this.Plus);
		obstacles.add(this.Triangle);

		this.Circle.setLayoutY(this.Circle.getLayoutY()-300);
		this.Plus.setLayoutY(this.Plus.getLayoutY()-600);
		this.Triangle.setLayoutY(this.Triangle.getLayoutY()-900);

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
					moveup();
					obstaclesUp();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		};

		infiniteTimer.start();

		rotate();
		
	}

	public void rotate() {

		this.rt1 = new RotateTransition();
		rt1.setDuration(Duration.millis(50000));
		rt1.setNode(this.SquareObstacle);
		rt1.setByAngle(3600);
		rt1.setCycleCount(Timeline.INDEFINITE);
		rt1.setAutoReverse(false);
		rt1.play();

		this.rt2 = new RotateTransition();
		rt2.setDuration(Duration.millis(50000));
		rt2.setNode(this.Triangle);
		rt2.setByAngle(3600);
		rt2.setCycleCount(Timeline.INDEFINITE);
		rt2.setAutoReverse(false);
		rt2.play();

		this.rt3 = new RotateTransition();
		rt3.setDuration(Duration.millis(50000));
		rt3.setNode(this.Plus);
		rt3.setByAngle(3600);
		rt3.setCycleCount(Timeline.INDEFINITE);
		rt3.setAutoReverse(false);
		rt3.play();

		this.rt4 = new RotateTransition();
		rt4.setDuration(Duration.millis(50000));
		rt4.setNode(this.Circle);
		rt4.setByAngle(3600);
		rt4.setCycleCount(Timeline.INDEFINITE);
		rt4.setAutoReverse(false);
		rt4.play();
	}

	public void moveup() {

		if(this.ball.getLayoutY()<350) {
			for(Node node:this.anchorPane.getChildren()) {
				node.setLayoutY(node.getLayoutY()+1);
			}
		}
		
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

			this.ColorSwitcher.setLayoutY(this.ColorSwitcher.getLayoutY()-300);
		}

		if(starCollision) {

			int x=Integer.parseInt(scoreLabel.getText());

			scoreLabel.setText(Integer.toString(x+1));

			this.starGroup.setLayoutY(this.starGroup.getLayoutY()-300);
		}

		//		System.out.println(starCollision);
	}

	@FXML
	public void ballBounce(ActionEvent event) throws IOException {		

		timer.stop();

		double initialpos=this.ball.getLayoutY();

		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), 
				new KeyValue(ball.layoutYProperty(), ball.getLayoutY()-50)));
		timeline.setCycleCount(1);
		timeline.play();

		timer.start();

	}

}
