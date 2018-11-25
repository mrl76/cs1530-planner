package cs1530.planner.calendar.event;

import cs1530.planner.util.Utils;

import java.util.Date;

public class Appointment implements Comparable<Appointment> {
	private String name, description;
	private Date date;
	
	public Appointment(String name, String description, Date date) {
		this.name = name;
		this.description = description;
		this.date = date;
	}
	
	public Appointment(String name) {
		this(name, "", Utils.now());
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
	
	@Override
	public int compareTo(Appointment o) {
		return (int) (o.date.getTime() - date.getTime());
	}
}
