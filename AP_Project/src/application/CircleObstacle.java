package application;

import javafx.scene.Group;

public class CircleObstacle extends Obstacle {

	CircleObstacle(Group group) {
		super(group);
		this.colors=4;
	}
	
	@Override
	public void rotate() {
		
		this.getGroup().setRotate(this.getGroup().getRotate()+1);
	}

}
