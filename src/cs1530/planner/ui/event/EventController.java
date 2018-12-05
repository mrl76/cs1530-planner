package cs1530.planner.ui.event;

import cs1530.planner.calendar.event.Appointment;
import cs1530.planner.calendar.event.Assignment;
import cs1530.planner.calendar.event.Exam;
import cs1530.planner.ui.UIManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.text.SimpleDateFormat;

public class EventController {
	@FXML private Label nameLabel, dateLabel, courseLabel;
	@FXML private Button alarmButton;
	@FXML private ImageView alarmStatus;
	
	private Appointment event;
	
	public void init(Appointment event) {
		this.event = event;
		nameLabel.setText(event.getName());
		dateLabel.setText((new SimpleDateFormat("MMM d, yy | h:mm a")).format(event.getDate()));
		if(event instanceof Assignment)
			courseLabel.setText(((Assignment) event).getCourse());
		else if(event instanceof Exam)
			courseLabel.setText(((Exam) event).getCourse());
		else
			courseLabel.setText("");
		alarmButton.setDisable(event.getAlarm() == null);
	}
	
	public void onAlarmClick() {
		if(event.getAlarm() != null) {
			if(event.getAlarm().isEnabled()) {
				event.getAlarm().setEnabled(false);
				alarmStatus.setImage(UIManager.BELL_OFF);
			}
			else {
				event.getAlarm().setEnabled(true);
				alarmStatus.setImage(UIManager.BELL);
			}
		}
	}
}
