package cs1530.planner.ui;

import cs1530.planner.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class FXMLParent {
	public static Parent LOGIN, PROFILE;
	
	static {
		try {
			LOGIN = FXMLLoader.load(Main.class.getResource("login/login.fxml"));
			PROFILE = FXMLLoader.load(Main.class.getResource("profile/profile.fxml"));
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
