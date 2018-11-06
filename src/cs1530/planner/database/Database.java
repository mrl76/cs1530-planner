package cs1530.planner.database;

import cs1530.planner.calendar.Calendar;
import cs1530.planner.calendar.Course;
import cs1530.planner.calendar.UserProfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Database {
	private Set<UserProfile> profiles;
	
	public Database() {
		this.profiles = new HashSet<>();
	}
	
	public void save() {
		for(UserProfile profile : profiles) {
			File profileDir = new File("profile_" + profile.getUsername());
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
				for(Course c : calendar.getCourses()) {
					writer.write(c.getName() + ";c;" + c.getDescription() + ";c;" + c.getTimetable());
					writer.write(System.lineSeparator());
				}
				//TODO write the other properties of user profiles to other files
				writer.close();
			} catch(IOException ex) {
				System.out.println("Could not save profile \'" + profile.getUsername() + "\'");
			}
		}
	}
	
	public void load() {
		File working = new File(System.getProperty("user.dir"));
		if(!working.exists())
			throw new IllegalStateException("working directory does not exist");
		File[] contents;
		if((contents = working.listFiles()) == null)
			return;
		for(File profileDir : contents) {
			if(!profileDir.isDirectory())
				continue;
			if(!profileDir.getName().startsWith("profile_"))
				continue;
			File[] profileData = profileDir.listFiles();
			if(profileData == null)
				continue;
			Scanner scanner;
			for(File f : profileData) {
				try {
					scanner = new Scanner(f);
					switch (f.getName()) {
					case "courses.txt":
						//TODO add courses to profile based on parsed file strings
						break;
						//TODO add more cases, one for each file type
					}
				} catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
