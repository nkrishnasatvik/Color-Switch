package application;

import javafx.scene.Group;

public class PlusObstacle extends Obstacle {

	PlusObstacle(Group group) {
		super(group);
		this.colors=4;
	}
	
	@Override
	public void rotate() {
		
		this.getGroup().setRotate(this.getGroup().getRotate()+1);
	}

}
