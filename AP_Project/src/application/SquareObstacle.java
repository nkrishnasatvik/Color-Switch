package application;

import javafx.scene.Group;

public class SquareObstacle extends Obstacle {

	SquareObstacle(Group group) {
		super(group);
		this.colors=4;
	}

	@Override
	public void rotate(int diff) {
		
		this.getGroup().setRotate(this.getGroup().getRotate()+diff);
	}

}
