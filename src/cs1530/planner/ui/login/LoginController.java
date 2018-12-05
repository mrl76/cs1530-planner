package cs1530.planner.ui.login;

import cs1530.planner.Main;
import cs1530.planner.calendar.UserProfile;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {
	@FXML public TextField username;
	@FXML public PasswordField password;
	@FXML public Button createNew, confirm;
	@FXML public Label error;
	
	public void onCreateClick() {
		if(username.getText().isEmpty() || password.getText().isEmpty()) {
			error.setText("Please fill out username and password.");
			return;
		}
		if(Main.getDatabase().getProfile(username.getText()) != null)
			error.setText("A profile under that username already exists.");
		else {
			UserProfile user = Main.getDatabase().createProfile(username.getText(), password.getText());
			Main.getUIManager().showProfile(user);
		}
	}
	
	public void onConfirmClick() {
		if(username.getText().isEmpty() || password.getText().isEmpty()) {
			error.setText("Please fill out username and password.");
			return;
		}
		UserProfile user = Main.getDatabase().getProfile(username.getText());
		if(user != null && user.verifyPassword(password.getText())) {
			error.setText("");
			Main.getUIManager().showProfile(user);
		}
		else
			error.setText("Username or password is incorrect.");
	}
}
