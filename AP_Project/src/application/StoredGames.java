package application;

import java.io.Serializable;
import java.util.ArrayList;

public class StoredGames implements Serializable {
	
	private static final long serialVersionUID = 42L;
	private ArrayList<GamePlayState> listOfGames;
	
	public StoredGames() {
		listOfGames = new ArrayList<GamePlayState>(3);
	}

	public ArrayList<GamePlayState> getListOfGames() {
		return listOfGames;
	}
	
	public void addGamePlay(GamePlayState st) {
		if(listOfGames.size() == 3) {
			listOfGames.remove(0);
			listOfGames.add(st);
		}
		else {
			listOfGames.add(st);
		}
	}

}