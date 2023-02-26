package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerScene1 {
	
	@FXML
	private Button cancelButton;	

	@FXML
	private AnchorPane scenePane;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Label loginMessageLabel;
	
	@FXML
	private TextField usernameTextField;
	
	@FXML
	private PasswordField passwordPasswordField;
	
	
	public void loginButtonOnAction(ActionEvent e) {;
		
		if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
			//loginMessageLabel.setText("You try to log in");
			validateLogin();
		} else {
			loginMessageLabel.setText("Please enter username and Password.");
		}
	}
		
		
	public void cancelButtonOnAction(ActionEvent e) {
		
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
	
	public void validateLogin() {
		
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		String verifyLogin = "SELECT count(1) FROM UserAccounts WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";
		
		
		try {
			
			Statement statement = connectDB.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);
			
			while(queryResult.next()) {
				
				if(queryResult.getInt(1) == 1) {
					loginMessageLabel.setText("Welcome");
					createAcoountForm();
				} else {
					loginMessageLabel.setText("Invalid Login!");
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void createAcoountForm() {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Scene2(signUp).fxml"));
			Stage registerStage = new Stage();
			registerStage.initStyle(StageStyle.UNDECORATED);
			registerStage.setScene(new Scene(root));
			registerStage.show();
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
		
	}
	

}
