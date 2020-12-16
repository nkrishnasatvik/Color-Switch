package application;

import javafx.scene.shape.Circle;

public class Ball {
	
	Circle ball;
	
	Ball(Circle ball){
		this.ball=ball;
	}
	
	public Circle getBall() {
		return this.ball;
	}

}
