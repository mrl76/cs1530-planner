package cs1530.planner.database;

import cs1530.planner.calendar.Calendar;
import cs1530.planner.calendar.Course;
import cs1530.planner.calendar.UserProfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Database {
	private Set<UserProfile> profiles;
	
	public Database() {
		this.profiles = new HashSet<>();
	}
	
	public void save() {
		for(UserProfile profile : profiles) {
			File profileDir = new File(profile.getUsername());
			while(!profileDir.exists()) {
				if(!profileDir.mkdir()) {
					System.out.println("Could not save profile \'" + profile.getUsername() + "\'");
					break;
				}
			}
			Calendar calendar = profile.getCalendar();
			File courseFile = new File(profileDir + File.separator + "courses.txt");
			FileWriter writer;
			try {
				writer = new FileWriter(courseFile, false);
				for(Course c : calendar.getCourses())
					writer.write(c.getName() + ";c;" + c.getDescription() + ";c;" + c.getTimetable());
				writer.close();
			} catch(IOException ex) {
				System.out.println("Could not save profile \'" + profile.getUsername() + "\'");
			}
		}
	}
}
