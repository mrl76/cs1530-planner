package cs1530.planner.calendar;

import cs1530.planner.calendar.event.Appointment;
import cs1530.planner.calendar.event.Assignment;
import cs1530.planner.calendar.event.Exam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//User profile class for holding username password and calendar
public class UserProfile {
	private String username;
	private String password;
	private Calendar calendar;
	
	//constructors
	public UserProfile(String name, String password){
		this.username = name;
		this.password = password;
		this.calendar = new Calendar(this);
	}
	
	public UserProfile(String name) {
		this(name, null);
	}
	
	//returns the calendar for the user
	public Calendar getCalendar(){
		return calendar;
	}
	
	//gets the users username
	public String getUsername(){
		return username;
	}
	
	//used to verify password for login
	public boolean verifyPassword(String attempt){
		return attempt.equals(password);
	}
	
	private File getProfileDir() {
		File profileDir = new File("profile_" + username);
		while(!profileDir.exists()) {
			if(!profileDir.mkdir()) {
				System.out.println("Could not save profile \'" + username + "\'");
				return null;
			}
		}
		return profileDir;
	}
	
	public void saveConfig() {
		File profileDir = getProfileDir();
		if(profileDir == null)
			return;
		File dataFile = new File(profileDir + File.separator + "config");
		try {
			FileWriter writer = new FileWriter(dataFile, false);
			writer.write(password + System.lineSeparator());
			writer.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void saveCourses() {
		File profileDir = getProfileDir();
		if(profileDir == null)
			return;
		File dataFile = new File(profileDir + File.separator + "courses");
		try {
			FileWriter writer = new FileWriter(dataFile, false);
			for(Course c : calendar.getCourses()) {
				writer.write(c.toString());
				writer.write(System.lineSeparator());
			}
			writer.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void saveAppointments() {
		File profileDir = getProfileDir();
		if(profileDir == null)
			return;
		File dataFile = new File(profileDir + File.separator + "appointments");
		try {
			FileWriter writer = new FileWriter(dataFile, false);
			for (Appointment a : calendar.getAppointments()) {
				writer.write(a.toString());
				writer.write(System.lineSeparator());
			}
			writer.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void saveAssignments() {
		File profileDir = getProfileDir();
		if(profileDir == null)
			return;
		File dataFile = new File(profileDir + File.separator + "assignments");
		try {
			FileWriter writer = new FileWriter(dataFile, false);
			for(Assignment s : calendar.getAssignments()) {
				writer.write(s.toString());
				writer.write(System.lineSeparator());
			}
			writer.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void saveExams() {
		File profileDir = getProfileDir();
		if(profileDir == null)
			return;
		File dataFile = new File(profileDir + File.separator + "exams");
		try {
			FileWriter writer = new FileWriter(dataFile, false);
			for(Exam e : calendar.getExams()) {
				writer.write(e.toString());
				writer.write(System.lineSeparator());
			}
			writer.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof UserProfile)
			return username.equals(((UserProfile) obj).username);
		return false;
	}
	
	@Override
	public int hashCode() {
		return username.hashCode();
	}
	
}