package cs1530.planner.ui;

import cs1530.planner.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class FXMLParent {
	private static final String LOGIN = "ui/login/login.fxml";
	private static final String PROFILE = "ui/profile/profile.fxml";
	private static final String NEWEVENT = "ui/newevent/newevent.fxml";
	private static final String NEWCOURSE = "ui/newcourse/newcourse.fxml";
	
	public static Parent getLogin() {
		try {
			return FXMLLoader.load(Main.class.getResource(LOGIN));
		} catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static Parent getProfile() {
		try {
			return FXMLLoader.load(Main.class.getResource(PROFILE));
		} catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static Parent getNewEvent() {
		try {
			return FXMLLoader.load(Main.class.getResource(NEWEVENT));
		} catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static Parent getNewCourse() {
		try {
			return FXMLLoader.load(Main.class.getResource(NEWCOURSE));
		} catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
