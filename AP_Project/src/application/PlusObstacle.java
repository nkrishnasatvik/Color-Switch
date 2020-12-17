package application;

import javafx.scene.Group;

public class PlusObstacle extends Obstacle {

	PlusObstacle(Group group) {
		super(group);
		this.colors=4;
	}
	
	@Override
	public void rotate(int diff) {
		
		this.getGroup().setRotate(this.getGroup().getRotate()+diff);
	}

}
