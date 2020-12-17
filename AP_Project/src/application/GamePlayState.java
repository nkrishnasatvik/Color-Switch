package application;

import java.io.Serializable;
import java.util.ArrayList;

public class GamePlayState implements Serializable{

	private static final long serialVersionUID = 42L;
	private int score;
	private int noOfStars;
	private int highScore;
	private double ballY;
	private int ballColour;
	private double starY;
	private double switcherY;
	private double squareY;
	private double cirlceY;
	private double plusY;
	private double triangleY;
	private int diffLevel;
	private double squareAngle;
	private double circleAngle;
	private double plusAngle;
	private double triangleAngle;
	
//	private ArrayList<Double> obstaclePositions=new ArrayList<Double>();
	
	public GamePlayState(int score, int noOfStars, int highScore, double ballY, int ballColour, 
			double starY, double switcherY, double squareY, double cirlceY, double plusY, double triangleY, int diffLevel,
			double squareAngle, double circleAngle, double plusAngle, double triangleAngle) {

		this.diffLevel=diffLevel;
		this.score = score;
		this.noOfStars = noOfStars;
		this.highScore = highScore;
		this.ballY = ballY;
		this.ballColour = ballColour;
		this.starY = starY;
		this.switcherY = switcherY;
		this.squareY=squareY;
		this.triangleY=triangleY;
		this.plusY=plusY;
		this.cirlceY=cirlceY;
		this.squareAngle=squareAngle;
		this.circleAngle=circleAngle;
		this.plusAngle=plusAngle;
		this.triangleAngle=triangleAngle;

	}
	
	public double getSquareAngle() {
		return squareAngle;
	}

	public void setSquareAngle(double squareAngle) {
		this.squareAngle = squareAngle;
	}

	public double getCircleAngle() {
		return circleAngle;
	}

	public void setCircleAngle(double circleAngle) {
		this.circleAngle = circleAngle;
	}

	public double getPlusAngle() {
		return plusAngle;
	}

	public void setPlusAngle(double plusAngle) {
		this.plusAngle = plusAngle;
	}

	public double getTriangleAngle() {
		return triangleAngle;
	}

	public void setTriangleAngle(double triangleAngle) {
		this.triangleAngle = triangleAngle;
	}

	public int getDiffLevel() {
		return diffLevel;
	}

	public void setDiffLevel(int diffLevel) {
		this.diffLevel = diffLevel;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNoOfStars() {
		return noOfStars;
	}

	public void setNoOfStars(int noOfStars) {
		this.noOfStars = noOfStars;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public double getBallY() {
		return ballY;
	}

	public void setBallY(double ballY) {
		this.ballY = ballY;
	}

	public int getBallColour() {
		return ballColour;
	}

	public void setBallColour(int ballColour) {
		this.ballColour = ballColour;
	}

	public double getStarY() {
		return starY;
	}

	public void setStarY(double starY) {
		this.starY = starY;
	}

	public double getSwitcherY() {
		return switcherY;
	}

	public void setSwitcherY(double switcherY) {
		this.switcherY = switcherY;
	}

	public double getSquareY() {
		return squareY;
	}

	public void setSquareY(double squareY) {
		this.squareY = squareY;
	}

	public double getCirlceY() {
		return cirlceY;
	}

	public void setCirlceY(double cirlceY) {
		this.cirlceY = cirlceY;
	}

	public double getPlusY() {
		return plusY;
	}

	public void setPlusY(double plusY) {
		this.plusY = plusY;
	}

	public double getTriangleY() {
		return triangleY;
	}

	public void setTriangleY(double triangleY) {
		this.triangleY = triangleY;
	}
	
}