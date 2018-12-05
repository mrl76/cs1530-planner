package cs1530.planner.ui;

import cs1530.planner.Main;
import cs1530.planner.calendar.UserProfile;
import cs1530.planner.calendar.event.Appointment;
import cs1530.planner.calendar.event.EventType;
import cs1530.planner.ui.event.EventController;
import cs1530.planner.ui.newcourse.NewCourseController;
import cs1530.planner.ui.newevent.NewEventController;
import cs1530.planner.ui.profile.ProfileController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class UIManager {
	public static Image BELL, BELL_OFF;
	
	private static final String LOGIN = "login/login.fxml";
	private static final String PROFILE = "profile/profile.fxml";
	private static final String NEWEVENT = "newevent/newevent.fxml";
	private static final String NEWCOURSE = "newcourse/newcourse.fxml";
	private static final String EVENT = "event/event.fxml";
	
	private ProfileController currentController;
	
	public UIManager() {
		try {
			BELL = new Image(Main.getResource("util/bell.png").openStream());
			BELL_OFF = new Image(Main.getResource("util/bell_off.png").openStream());
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void showLogin() {
		try {
			FXMLLoader l = new FXMLLoader(getClass().getResource(LOGIN));
			Pane p = l.load();
			Scene s = new Scene(p);
			Main.setScene(s, "Login");
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void showProfile(UserProfile profile) {
		try {
			FXMLLoader l = new FXMLLoader(getClass().getResource(PROFILE));
			Platform.runLater(() -> {
				ProfileController c = l.getController();
				c.init(profile);
				currentController = c;
			});
			Pane p = l.load();
			Scene s = new Scene(p);
			Main.setScene(s, "Planner");
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void showNewEvent(UserProfile profile, EventType type) {
		try {
			FXMLLoader l = new FXMLLoader(getClass().getResource(NEWEVENT));
			Platform.runLater(() -> {
				NewEventController c = l.getController();
				c.init(profile, type);
			});
			Pane p = l.load();
			Scene s = new Scene(p);
			Stage g = new Stage();
			g.setTitle("Add New Event");
			g.setScene(s);
			g.showAndWait();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void showNewCourse(UserProfile profile) {
		try {
			FXMLLoader l = new FXMLLoader(getClass().getResource(NEWCOURSE));
			Platform.runLater(() -> {
				NewCourseController c = l.getController();
				c.init(profile);
			});
			Pane p = l.load();
			Scene s = new Scene(p);
			Stage g = new Stage();
			g.setTitle("Add New Course");
			g.setScene(s);
			g.showAndWait();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public Pane getEventPane(UserProfile profile, Appointment event) {
		try {
			FXMLLoader l = new FXMLLoader(getClass().getResource(EVENT));
			Platform.runLater(() -> {
				EventController c = l.getController();
				c.init(event);
			});
			Pane p = l.load();
			p.setOnMouseClicked((mouseEvent) -> {
				if(mouseEvent.getClickCount() == 2) {
					try {
						FXMLLoader l2 = new FXMLLoader(getClass().getResource(NEWEVENT));
						Platform.runLater(() -> {
							NewEventController c = l2.getController();
							c.init(profile, event);
						});
						Pane p2 = l2.load();
						Scene s = new Scene(p2);
						Stage g = new Stage();
						g.setTitle("Edit Event");
						g.setScene(s);
						g.showAndWait();
					} catch(IOException ex) {
						ex.printStackTrace();
					}
				}
			});
			return p;
		} catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public void refreshCurrentProfile() {
		currentController.refreshDisplay();
	}
}
