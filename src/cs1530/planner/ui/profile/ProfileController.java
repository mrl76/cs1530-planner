package cs1530.planner.ui.profile;

import cs1530.planner.Main;
import cs1530.planner.calendar.UserProfile;
import cs1530.planner.calendar.event.Appointment;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ProfileController {
	@FXML public Label username;
	@FXML public Button addButton, filterButton;
	@FXML public VBox eventBox;
	
	private UserProfile profile;
	
	@FXML private void initialize() {
		this.profile = Main.getOpenProfile();
		username.setText(profile.getUsername());
	}
	
	public void onAddButton() {
		//TODO open new event window
		Appointment event = new Appointment("placeholder"); //new event window returns new event
		profile.getCalendar().addAppointment(event);
		refreshDisplay();
		Main.saveOpenProfile();
	}
	
	public void onFilterButton() {
		//TODO open filter window
		refreshDisplay();
	}
	
	private void refreshDisplay() {
		//TODO create display
	}
}
