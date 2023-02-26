package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Scene1(login).fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			stage.setOnCloseRequest(event -> {
				event.consume();
				logout(stage);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout(Stage stage) {							// Logout notification bei rotem X / Alt + F4
		
		Alert alert = new Alert(AlertType.CONFIRMATION);	
		alert.setTitle("Logout");
		alert.setHeaderText("You´re about to logout");
		alert.setContentText("Do you want to save?");
		
		
		if(alert.showAndWait().get() == ButtonType.OK) {
			System.out.println("You logged out!");
			stage.close();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
