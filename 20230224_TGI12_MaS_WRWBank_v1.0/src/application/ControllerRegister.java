package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerRegister {
	
	@FXML
	Stage stage = new Stage();
	
	@FXML
	private Button cancelButton;
	
	
	public void closeButtonOnAction(ActionEvent e)  {
		
		
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You´re about to logout");
		alert.setContentText("Do you want to save?");
		
		
		if(alert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage) cancelButton.getScene().getWindow();
			System.out.println("You logged out!");
			stage.close();
		}
		
	}
	
}
