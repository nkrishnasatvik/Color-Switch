package application;

import java.util.*;

import javafx.scene.Parent;

public class database {
	
	private ArrayList<Parent> savedGames;
	private Parent currentGame;
	
	private int highScore;
	private int totalStars;
	
	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public int getTotalStars() {
		return totalStars;
	}

	public void setTotalStars(int totalStars) {
		this.totalStars = totalStars;
	}

	database(){
		this.savedGames=new ArrayList<Parent>();
	}
	
	public ArrayList<Parent> getSavedGames() {
		return savedGames;
	}

	public void setSavedGames(ArrayList<Parent> savedGames) {
		this.savedGames = savedGames;
	}

	public void setCurrentGame(Parent currentGame) {
		this.currentGame = currentGame;
	}

	public Parent getCurrentGame(){
		return this.currentGame;
	}
	
}
