package cs1530.planner.ui.newcourse;

import cs1530.planner.Main;
import cs1530.planner.calendar.Course;
import cs1530.planner.calendar.time.Interval;
import cs1530.planner.calendar.time.Timetable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NewCourseController {
	@FXML private TextField name;
	@FXML private DatePicker date;
	@FXML private ComboBox<Integer> hour, minute;
	@FXML private ComboBox<String> meridian;
	@FXML private CheckBox repeatBox;
	@FXML private TextField intervalSizeField;
	@FXML private ComboBox<String> intervalBox;
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
		ObservableList<String> intervals = FXCollections.observableArrayList("Days", "Weeks", "Months", "Years");
		intervalBox.setItems(intervals);
	}
	
	public void onConfirm() {
		String courseName = name.getText();
		Date startDate = Date.from(Instant.from(date.getValue().atStartOfDay(ZoneId.systemDefault())));
		int startHour = hour.getValue();
		int startMinute = minute.getValue();
		String startMer = meridian.getValue();
		String courseDesc = description.getText();
		Calendar c = new GregorianCalendar();
		c.setTime(startDate);
		c.set(Calendar.HOUR, startHour % 12);
		c.set(Calendar.MINUTE, startMinute);
		c.set(Calendar.AM_PM, startMer.equals("AM") ? Calendar.AM : Calendar.PM);
		int intervalSize = Integer.valueOf(intervalSizeField.getText());
		Interval interval = Interval.valueOf(intervalBox.getValue().toUpperCase());
		Timetable t = new Timetable(startDate, startDate, null, startDate, repeatBox.isSelected(), intervalSize, interval, false);
		Course r = new Course(courseName, courseDesc, t);
		Main.getOpenProfile().getCalendar().addCourse(r);
	}
}
