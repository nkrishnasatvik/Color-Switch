package application;

import javafx.scene.Group;

public class TriangleObstacle extends Obstacle {

	TriangleObstacle(Group group) {
		super(group);
		this.colors=3;
	}

	@Override
	public void rotate() {
		
		this.getGroup().setRotate(this.getGroup().getRotate()+3);
	}
}
