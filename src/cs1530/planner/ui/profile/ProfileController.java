package cs1530.planner.ui.profile;

import cs1530.planner.Main;
import cs1530.planner.calendar.UserProfile;
import cs1530.planner.calendar.event.EventType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ProfileController {
	@FXML public Label username;
	@FXML public ChoiceBox<String> addBox;
	@FXML public VBox eventBox;
	
	private UserProfile profile;
	
	@FXML private void initialize() {
		ObservableList<String> choices = FXCollections.observableArrayList("Appointment", "Assignment", "Exam", "Course");
		addBox.setItems(choices);
		addBox.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> {
					if((oldValue == null || oldValue.isEmpty()) && newValue != null && !newValue.isEmpty())
						onAdd();
				}
		);
	}
	
	public void init(UserProfile profile) {
		this.profile = profile;
		username.setText(profile.getUsername());
		refreshDisplay();
	}
	
	private void onAdd() {
		if(addBox.getValue() != null) {
			EventType type = EventType.valueOf(addBox.getValue().toUpperCase());
			if(type == EventType.COURSE)
				Main.getUIManager().showNewCourse(profile);
			else
				Main.getUIManager().showNewEvent(profile, type);
			refreshDisplay();
		}
	}
	
	private void refreshDisplay() {
		//TODO create display
	}
}
