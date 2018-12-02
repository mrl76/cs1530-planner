package cs1530.planner.ui.newevent;

import cs1530.planner.Main;
import cs1530.planner.calendar.event.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NewEventController {
	@FXML private TextField name;
	@FXML private DatePicker date;
	@FXML private ComboBox<Integer> hour, minute;
	@FXML private ComboBox<String> meridian;
	@FXML private TextArea description;
	
	@FXML private void initialize() {
		ObservableList<Integer> hours = FXCollections.observableArrayList();
		for(int i = 1; i <= 12; i++) hours.add(i);
		hour.setItems(hours);
		ObservableList<Integer> minutes = FXCollections.observableArrayList();
		for(int i = 0; i <= 59; i++) minutes.add(i);
		minute.setItems(minutes);
		ObservableList<String> meridians = FXCollections.observableArrayList("AM", "PM");
		meridian.setItems(meridians);
	}
	
	public void onConfirm() {
		String eventName = name.getText();
		Date eventDate = Date.from(Instant.from(date.getValue().atStartOfDay(ZoneId.systemDefault())));
		int eventHour = hour.getValue();
		int eventMinute = minute.getValue();
		String eventMer = meridian.getValue();
		String eventDesc = description.getText();
		Calendar c = new GregorianCalendar();
		c.setTime(eventDate);
		c.set(Calendar.HOUR, eventHour % 12);
		c.set(Calendar.MINUTE, eventMinute);
		c.set(Calendar.AM_PM, eventMer.equals("AM") ? Calendar.AM : Calendar.PM);
		Appointment a = new Appointment(eventName, eventDesc, c.getTime());
		Main.getOpenProfile().getCalendar().addAppointment(a);
	}
}
