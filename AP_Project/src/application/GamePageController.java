package application;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
	private Group ColorSwitcher;

	@FXML
	private Label scoreLabel;

	private int tempscore;

	@FXML
	private Button bounce;

	@FXML
	private ImageView star;

	@FXML
	private Group starGroup;

	private AnimationTimer timer;

	private AnimationTimer infiniteTimer;

	private ArrayList<Obstacle> obstacles;

	boolean savedGame;

	private int difficultyLevel;

	boolean respawnBoolean;

	public void setGame(int score, 
			double ballY,
			int ballColor,
			double starY,
			double switcherY,
			double squareY,
			double circleY,
			double plusY,
			double triangleY,
			int diffLevel,
			double squareAngle, 
			double circleAngle,
			double plusAngle,
			double triangleAngle) {
		
		savedGame=true;
		
		this.scoreLabel.setText(Integer.toString(score));
		this.difficultyLevel=diffLevel;
		this.classBall=new Ball(this.ball);
		
		if(ballColor==1) {
			this.classBall.getBall().setFill(Color.BLUE);
		}
		else if(ballColor==2) {
			this.classBall.getBall().setFill(Color.RED);
		}
		else if(ballColor==3) {
			this.classBall.getBall().setFill(Color.YELLOW);
		}
		else if(ballColor==4) {
			this.classBall.getBall().setFill(Color.PURPLE);
		}
		
		this.starGroup.setLayoutY(starY);
		this.ColorSwitcher.setLayoutY(switcherY);
		
		obstacles=new ArrayList<Obstacle>();
		obstacles.add(new SquareObstacle(this.SquareObstacle));
		obstacles.add(new CircleObstacle(this.Circle));
		obstacles.add(new PlusObstacle(this.Plus));
		obstacles.add(new TriangleObstacle(this.Triangle));
		
		obstacles.get(0).getGroup().setLayoutY(squareY);
		obstacles.get(1).getGroup().setLayoutY(circleY);
		obstacles.get(2).getGroup().setLayoutY(plusY);
		obstacles.get(3).getGroup().setLayoutY(triangleY);
		
		obstacles.get(0).getGroup().setRotate(squareAngle);
		obstacles.get(1).getGroup().setRotate(circleAngle);
		obstacles.get(2).getGroup().setRotate(plusAngle);
		obstacles.get(3).getGroup().setRotate(triangleAngle);

		this.difficultyLevel=diffLevel;

	}

	@FXML
	public void initialize() {

		if(!savedGame) {
			this.difficultyLevel=1;

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
		}

		this.timer = new AnimationTimer() {
			@Override
			public void handle(long l) {
				ballDown();
			}

		};

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

	}

	public void stopGame(boolean check) throws IOException{
		if(this.ball.getLayoutY()>500 || check) {

			this.timer.stop();
			this.infiniteTimer.stop();

			int gamescore = Integer.parseInt(scoreLabel.getText());
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("RespawnPage.fxml"));
			loader.load();

			Media gameOver = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\gameOver.wav").toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(gameOver);
			mediaPlayer.play();

			respawnPageController page = loader.getController();
			page.setLabels(gamescore,tempscore);

			Parent GamePageParent = loader.getRoot();

			Stage window = (Stage)(this.anchorPane).getScene().getWindow();

			Main.scene.setRoot(GamePageParent);
			window.setScene(Main.scene);
			window.show();

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
			obs.rotate(this.difficultyLevel);
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

	public int colorToInteger() {

		if(this.classBall.getBall().getFill() == Color.BLUE) {
			return 1;
		}
		else if(this.classBall.getBall().getFill() == Color.RED) {
			return 2;
		}
		else if(this.classBall.getBall().getFill() == Color.YELLOW) {
			return 3;
		}
		else {
			return 4;
		}
	}



	@FXML
	void displayPausePage(ActionEvent event) throws IOException {

		stopAllActivities();
		playyy=false;

		int gamescore = Integer.parseInt(scoreLabel.getText());
		int colorVal = colorToInteger();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("PausePage.fxml"));
		loader.load();
		
		PausePageController pause = loader.getController();
		pause.initData(gamescore, this.classBall.getBall().getLayoutY(), 
				colorVal, starGroup.getLayoutY(),
				ColorSwitcher.getLayoutY(), 
				obstacles.get(0).getGroup().getLayoutY(), 
				obstacles.get(1).getGroup().getLayoutY(), 
				obstacles.get(2).getGroup().getLayoutY(), 
				obstacles.get(3).getGroup().getLayoutY(),
				this.difficultyLevel, 
				obstacles.get(0).getGroup().getRotate(), 
				obstacles.get(1).getGroup().getRotate(), 
				obstacles.get(2).getGroup().getRotate(), 
				obstacles.get(3).getGroup().getRotate());
		
		System.out.println(obstacles.get(0).getGroup().getRotate()+" "+obstacles.get(2).getGroup().getRotate());

		Parent GamePageParent = loader.getRoot();
		Scene GamePageScene = new Scene(GamePageParent);



		Media buttonClick = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\buttonClick.wav").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(buttonClick);
		mediaPlayer.play();

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
								this.obstacles.get(0).getGroup().setLayoutY(this.obstacles.get(0).getGroup().getLayoutY()-1200);
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
								this.obstacles.get(1).getGroup().setLayoutY(this.obstacles.get(1).getGroup().getLayoutY()-1200);
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
								this.obstacles.get(2).getGroup().setLayoutY(this.obstacles.get(2).getGroup().getLayoutY()-1200);
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
							if(((Line)line).getFill() != this.classBall.getBall().getFill() && ((Line)line).getFill()!=Color.WHITE) {
								this.obstacles.get(3).getGroup().setLayoutY(this.obstacles.get(3).getGroup().getLayoutY()-1200);
								stopGame(true);
							}
						}
					}					
				}
			}
		}

		if (colorSwitchCollision) {

			Media touchCS = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\touchCS.wav").toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(touchCS);
			mediaPlayer.play();

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

			Media touchStar = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\touchStar.wav").toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(touchStar);
			mediaPlayer.play();

			tempscore++;

			int x=Integer.parseInt(scoreLabel.getText())+1;

			scoreLabel.setText(Integer.toString(x));

			this.starGroup.setLayoutY(this.starGroup.getLayoutY()-300);

			if(x>=3) this.difficultyLevel=2;

			if(x>=6) this.difficultyLevel=3;
		}
	}

	public static boolean playyy;

	@FXML
	void mouseClickAction(MouseEvent event) {

		this.startAllActivities();

		Media ballTap = new Media(new File("C:\\Users\\Krishna Satvik\\Downloads\\ballTap.wav").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(ballTap);
		mediaPlayer.play();

		if(playyy) {

			if(ball.getLayoutY()>=500) ball.setLayoutY(ball.getLayoutY()-50);
			tempscore=0;
			playyy=false;
			respawnBoolean=true;
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
