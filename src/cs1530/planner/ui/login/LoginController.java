package cs1530.planner.ui.login;

import cs1530.planner.Main;
import cs1530.planner.calendar.UserProfile;
import cs1530.planner.login.Login;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	public TextField username;
	public PasswordField password;
	public Button createNew, confirm;
	public Label error;
	
	private Main main;
	
	public LoginController(Main main) {
		this.main = main;
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
			error.setText("Username or password is invalid.");
		else {
			error.setText("");
			main.openProfile(user);
		}
	}
}
