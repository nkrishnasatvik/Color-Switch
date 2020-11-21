package application;
	
import java.awt.Insets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		
		
//		Circle ball=new Circle();
//		
//		ball.setRadius(10);
//		ball.setFill(Color.PURPLE);
//		ball.setCenterX(160);
//		ball.setCenterY(450);
//		
//		Button pause=new Button("Pause");
//		Button resume=new Button("Resume");
////		pause.setMinSize(10, 20);
//		
//		pause.setLayoutX(5);
//		pause.setLayoutY(5);
		
//		pause.setStyle("-fx-background-radius: 0; -fx-padding: 0; -fx-background-color: rgb(100,0,0);");
//		pause.set
		
		try {
//			BorderPane pane = new BorderPane();
			
			AnchorPane anchor;
			
			FXMLLoader fxmlload=new FXMLLoader();
			fxmlload.setLocation(Main.class.getResource("FxMl.fxml"));
			
			anchor=fxmlload.load();
			
//			Group root=new Group();
//			pane.setStyle("-fx-background-color: rgb(45,45,45);");
			
			Scene scene = new Scene(anchor,1000,1000);
//			
//			pane.getChildren().add(root);
//			root.getChildren().add(pause);
//			root.getChildren().add(ball);
//			
////			root.getChildren().
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
