package application;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.util.Duration;

public abstract class Obstacle {
	
	protected int colors;
	protected Group group;
	
	Obstacle(Group group) {
		this.group=group;
	}

	public int getColors() {
		return colors;
	}

	public Group getGroup() {
		return group;
	}

	public abstract void rotate(int difficultyLevel);

}
