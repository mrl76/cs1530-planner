package cs1530.planner.ui.login;

import cs1530.planner.Main;
import cs1530.planner.calendar.UserProfile;
import cs1530.planner.login.Login;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML public TextField username;
	@FXML public PasswordField password;
	@FXML public Button createNew, confirm;
	@FXML public Label error;
	
	private Main main;
	
	@FXML private void initialize() {
		this.main = Main.getInstance();
	}
	
	public void onCreateClick() {
		if(username.getText().isEmpty() || password.getText().isEmpty()) {
			error.setText("Please fill out username and password.");
			return;
		}
		main.openProfile(main.getDatabase().createProfile(username.getText(), password.getText()));
	}
	
	public void onConfirmClick() {
		if(username.getText().isEmpty() || password.getText().isEmpty()) {
			error.setText("Please fill out username and password.");
			return;
		}
		UserProfile user = Login.userLogin(username.getText(), password.getText(), main.getDatabase());
		if(user == null)
			error.setText("Username or password is incorrect.");
		else {
			error.setText("");
			main.openProfile(user);
			((Stage) username.getScene().getWindow()).close();
		}
	}
}
