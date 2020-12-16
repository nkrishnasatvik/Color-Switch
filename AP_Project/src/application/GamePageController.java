package application;

import java.io.IOException;
import java.util.*;

import javafx.animation.*;
import javafx.event.*;
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
	
	private Ball classBall;
	
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

	private ArrayList<Obstacle> obstacles;

	@FXML
	public void initialize() {
		
		this.classBall=new Ball(this.ball);
		
		obstacles=new ArrayList<Obstacle>();
		obstacles.add(new SquareObstacle(this.SquareObstacle));
		obstacles.add(new CircleObstacle(this.Circle));
		obstacles.add(new PlusObstacle(this.Plus));
		obstacles.add(new TriangleObstacle(this.Triangle));

		int count=0;
		for(Obstacle obs:obstacles) {
			obs.getGroup().setLayoutY(obs.getGroup().getLayoutY()-count*300);
			count++;
			if(count==4) count=0;
		}

		this.timer = new AnimationTimer() {
			@Override
			public void handle(long l) {
				ballDown();
			}

		};

		this.timer.start();

		this.infiniteTimer = new AnimationTimer() {

			@Override
			public void handle(long l) {
				try {
					collisions();
					moveup();
					obstaclesUp();
					stopGame(false);
					rotate();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		infiniteTimer.start();

		rotate();

	}
	
	public void stopGame(boolean check) throws IOException{
		
		if(this.ball.getLayoutY()>500 || check) {
			
			int gamescore = Integer.parseInt(scoreLabel.getText());
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("RespawnPage.fxml"));
			loader.load();
			
			RespawnPageController page = loader.getController();
			page.setLabels(gamescore);
			
			Parent GamePageParent = loader.getRoot();
			Scene GamePageScene = new Scene(GamePageParent);

			Stage window = (Stage)(this.anchorPane).getScene().getWindow();
			window.setScene(GamePageScene);
			window.show();

			this.timer.stop();
			this.infiniteTimer.stop();
		}
	}
	
	public void ballDown() {
		
		double dy = -1.5;
		this.classBall.getBall().setLayoutY(this.classBall.getBall().getLayoutY() - dy);

	}

	public void obstaclesUp() {
		
		for(Obstacle obs:obstacles) {
			if(obs.getGroup().getLayoutY()>600) {
				obs.getGroup().setLayoutY(obs.getGroup().getLayoutY()-1200);
			}
		}
	}


	public void rotate() {
		
		for(Obstacle obs:obstacles) {
			obs.rotate();
		}
	}

	public void moveup() {

		if(this.classBall.getBall().getLayoutY()<350) {
			for(Node node:this.anchorPane.getChildren()) {
				node.setLayoutY(node.getLayoutY()+1);
			}
		}

	}
	
	public void stopAllActivities() {
		this.timer.stop();
		this.infiniteTimer.stop();
	}
	
	public void startAllActivities() {
		this.timer.start();
		this.infiniteTimer.start();
	}

	@FXML
	void displayPausePage(ActionEvent event) throws IOException {
		
		stopAllActivities();
		playyy=false;
		
		Parent GamePageParent = FXMLLoader.load(getClass().getResource("PausePage.fxml"));
		Scene GamePageScene = new Scene(GamePageParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(GamePageScene);
		window.show();
	}

	private void collisions() throws IOException {

		boolean colorSwitchCollision = false;
		boolean starCollision=false;

		for (Node static_bloc : anchorPane.getChildren()) {

			if (static_bloc ==this.ColorSwitcher) {

				if (this.classBall.getBall().getBoundsInParent().intersects(static_bloc.getBoundsInParent()) ) {
					colorSwitchCollision = true;
				}
			}
			if(static_bloc==this.starGroup) {
				if (this.classBall.getBall().getBoundsInParent().intersects(static_bloc.getBoundsInParent()) ) {
					starCollision = true;
				}
			}
			
			if(static_bloc==this.obstacles.get(0).getGroup()) {
				if (this.classBall.getBall().getBoundsInParent().intersects(static_bloc.getBoundsInParent()) ) {	

					for(Node line:this.obstacles.get(0).getGroup().getChildren()) {
						if(((Path)Shape.intersect(this.classBall.getBall(), (Line)line)).getElements().size() > 5) {
							if(((Line)line).getFill() != this.classBall.getBall().getFill()) {
								stopGame(true);
							}
						}
					}					
				}
			}
			
			if(static_bloc==this.obstacles.get(1).getGroup()) {
				if (this.classBall.getBall().getBoundsInParent().intersects(static_bloc.getBoundsInParent()) ) {	

					for(Node arc:this.obstacles.get(1).getGroup().getChildren()) {
						if(((Path)Shape.intersect(this.classBall.getBall(), (Arc)arc)).getElements().size() > 5) {
							if(((Arc)arc).getStroke()!= this.classBall.getBall().getFill()) {
								stopGame(true);
							}
						}
					}					
				}
			}
			
			if(static_bloc==this.obstacles.get(2).getGroup()) {
				if (this.classBall.getBall().getBoundsInParent().intersects(static_bloc.getBoundsInParent()) ) {	

					for(Node line:this.obstacles.get(2).getGroup().getChildren()) {
						if(((Path)Shape.intersect(this.classBall.getBall(), (Line)line)).getElements().size() > 5) {
							if(((Line)line).getFill() != this.classBall.getBall().getFill()) {
								stopGame(true);
							}
						}
					}					
				}
			}
			
			if(static_bloc==this.obstacles.get(3).getGroup()) {
				if (this.classBall.getBall().getBoundsInParent().intersects(static_bloc.getBoundsInParent()) ) {	

					for(Node line:this.obstacles.get(3).getGroup().getChildren()) {
						if(((Path)Shape.intersect(this.classBall.getBall(), (Line)line)).getElements().size() > 5) {
							if(((Line)line).getFill() != this.classBall.getBall().getFill()) {
								stopGame(true);
							}
						}
					}					
				}
			}
		}

		if (colorSwitchCollision) {


			if(this.classBall.getBall().getFill()==Color.BLUE) {
				this.classBall.getBall().setFill(Color.RED);
			}
			else if(this.classBall.getBall().getFill()==Color.RED) {
				this.classBall.getBall().setFill(Color.YELLOW);
			}
			else if(this.classBall.getBall().getFill()==Color.YELLOW) {
				this.classBall.getBall().setFill(Color.PURPLE);
			}
			else {
				this.classBall.getBall().setFill(Color.BLUE);
			}

			this.ColorSwitcher.setLayoutY(this.ColorSwitcher.getLayoutY()-300);
		}

		if(starCollision) {

			int x=Integer.parseInt(scoreLabel.getText());

			scoreLabel.setText(Integer.toString(x+1));

			this.starGroup.setLayoutY(this.starGroup.getLayoutY()-300);
		}
	}
	
	public static boolean playyy;
	
	@FXML
	void mouseClickAction(MouseEvent event) {
		
		if(playyy) {
			playyy=false;
			this.timer.start();
			this.infiniteTimer.start();
		}
		timer.stop();

		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), 
				new KeyValue(this.classBall.getBall().layoutYProperty(), this.classBall.getBall().getLayoutY()-50)));
		timeline.setCycleCount(1);
		timeline.play();

		timer.start();
	}

}
