package application;
	
import java.io.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public static database allGames;
	public static Scene scene;
	public static StoredGames currStorage = new StoredGames();
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			
			Main.deserialize();
			
			Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
			
			allGames=new database();
			String s=root.toString();

			scene = new Scene(root);	
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void serialize() throws IOException {
    	
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream (new FileOutputStream("StoredGames.txt"));
            out.writeObject(currStorage);
        }
        finally {
            out.close();
            System.exit(0);
        }
    }
    
    public static void deserialize() throws IOException, ClassNotFoundException {
    	
    	ObjectInputStream in = null;
    	try {
    		in = new ObjectInputStream(new FileInputStream("StoredGames.txt"));
    		currStorage = (StoredGames) in.readObject();
    	}
    	catch (FileNotFoundException e) {
    		currStorage = new StoredGames();
    	}
    	catch (NullPointerException e) {
    		currStorage = new StoredGames();
    	}
    	finally {
//    		in.close();
    	}
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
