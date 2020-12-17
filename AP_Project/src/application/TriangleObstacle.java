package application;

import javafx.scene.Group;

public class TriangleObstacle extends Obstacle {

	TriangleObstacle(Group group) {
		super(group);
		this.colors=3;
	}

	@Override
	public void rotate(int diff) {
		
		this.getGroup().setRotate(this.getGroup().getRotate()+diff);
	}
}