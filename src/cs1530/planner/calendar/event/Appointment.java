package cs1530.planner.calendar.event;

import cs1530.planner.calendar.Alarm;
import cs1530.planner.database.Database;
import cs1530.planner.util.Utils;

import java.util.Date;

public class Appointment implements Comparable<Appointment> {
	protected String name, description;
	protected Date date;
	protected Alarm alarm = null;
	
	public Appointment(String name, String description, Date date) {
		this.name = name;
		this.description = description;
		this.date = date;
	}
	
	public Appointment(String dataString) {
		String[] data = dataString.split(Database.APPOINT_DELIM);
		if(data.length == 3) {
			name = data[0];
			description = data[1];
			date = new Date(Long.valueOf(data[2]));
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Alarm getAlarm() {
		return alarm;
	}
	
	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
		this.alarm.setEnabled(true);
	}
	
	@Override
	public int compareTo(Appointment o) {
		return (int) (date.getTime() - o.date.getTime());
	}
	
	@Override
	public String toString() {
		return Utils.toFileString(Database.APPOINT_DELIM, name, description, date.getTime());
	}
}
