package cs1530.planner.ui;

import cs1530.planner.Main;
import cs1530.planner.calendar.UserProfile;
import cs1530.planner.calendar.event.EventType;
import cs1530.planner.ui.newevent.NewEventController;
import cs1530.planner.ui.profile.ProfileController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UIManager {
	private static final String LOGIN = "login/login.fxml";
	private static final String PROFILE = "profile/profile.fxml";
	private static final String NEWEVENT = "newevent/newevent.fxml";
	private static final String NEWCOURSE = "newcourse/newcourse.fxml";
	private static final String EVENT = "event/event.fxml";
	
	private Map<Pane, FXMLLoader> loaders;
	
	public UIManager() {
		this.loaders = new HashMap<>();
	}
	
	public FXMLLoader getLoader(Pane pane) {
		return loaders.get(pane);
	}
	
	public void showLogin() {
		try {
			FXMLLoader l = new FXMLLoader(getClass().getResource(LOGIN));
			Pane p = l.load();
			loaders.put(p, l);
			Scene s = new Scene(p);
			Main.setScene(s, "Login");
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void showProfile(UserProfile profile) {
		try {
			FXMLLoader l = new FXMLLoader(getClass().getResource(PROFILE));
			ProfileController c = l.getController();
			c.init(profile);
			Pane p = l.load();
			loaders.put(p, l);
			Scene s = new Scene(p);
			Main.setScene(s, profile.getUsername() + ": Calendar");
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void showNewEvent(UserProfile profile, EventType type) {
		try {
			FXMLLoader l = new FXMLLoader(getClass().getResource(NEWEVENT));
			NewEventController c = l.getController();
			c.init(profile, type);
			Pane p = l.load();
			loaders.put(p, l);
			Scene s = new Scene(p);
			Main.setScene(s, "Create new event");
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
