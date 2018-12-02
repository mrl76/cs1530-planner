package cs1530.planner.ui;

import cs1530.planner.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class FXMLParent {
	public static Parent LOGIN, PROFILE, NEWEVENT;
	
	static {
		try {
			LOGIN = FXMLLoader.load(Main.class.getResource("ui/login/login.fxml"));
			PROFILE = FXMLLoader.load(Main.class.getResource("ui/profile/profile.fxml"));
			NEWEVENT = FXMLLoader.load(Main.class.getResource("ui/newevent/newevent.fxml"));
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
