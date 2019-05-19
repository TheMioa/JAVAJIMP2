package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	BlockThread blockThread = new BlockThread();
    @Override
	public void start(Stage primaryStage) throws Exception{
			Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
			
			Scene scene = new Scene(root);

			scene.setOnKeyPressed(tankController());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Strzelaj¹ce czo³gi");
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	private Tank leftPlayer;
	private Tank rightPlayer;
	private KeyControl tankController() {
		return new KeyControl(leftPlayer, rightPlayer);
	}
}
