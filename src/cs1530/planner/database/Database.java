package cs1530.planner.database;

import cs1530.planner.calendar.Course;
import cs1530.planner.calendar.UserProfile;
import cs1530.planner.calendar.event.Appointment;
import cs1530.planner.calendar.event.Assignment;
import cs1530.planner.calendar.event.Exam;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Database {
	public static final String APPOINT_DELIM = ";a;";
	public static final String ASSIGN_DELIM = ";s;";
	public static final String COURSE_DELIM = ";c;";
	public static final String EXAM_DELIM = ";e;";
	public static final String TIMETABLE_DELIM = ";t;";
	
	private Map<String, UserProfile> profiles;
	
	public Database() {
		this.profiles = new HashMap<>();
	}
	
	public void save() {
		for(UserProfile profile : profiles.values())
			saveProfile(profile);
	}
	
	public void saveProfile(UserProfile profile) {
		profile.saveConfig();
		profile.saveCourses();
		profile.saveAppointments();
		profile.saveAssignments();
		profile.saveExams();
	}
	
	public void load() {
		File working = new File(System.getProperty("user.dir"));
		if(!working.exists())
			throw new IllegalStateException("working directory does not exist");
		File[] contents;
		if((contents = working.listFiles()) == null)
			return;
		profiles.clear();
		for(File profileDir : contents) {
			if(!profileDir.isDirectory())
				continue;
			if(!profileDir.getName().startsWith("profile_"))
				continue;
			File[] profileData = profileDir.listFiles();
			if(profileData == null || profileData.length == 0)
				continue;
			//load config first to get password
			Scanner scanner;
			UserProfile next = null;
			for(File f : profileData) {
				try {
					scanner = new Scanner(f);
					if (f.getName().equals("config")) {
						if (scanner.hasNextLine()) {
							next = new UserProfile(profileDir.getName().replaceFirst("profile_", ""), scanner.nextLine());
							profiles.put(next.getUsername(), next);
						}
					}
				} catch(IOException ex) {
					ex.printStackTrace();
				}
			}
			if(next != null) {
				for (File f : profileData) {
					try {
						scanner = new Scanner(f);
						String filename = f.getName();
						switch (filename) {
						case "courses":
							while (scanner.hasNextLine()) {
								String line = scanner.nextLine();
								if (!line.isEmpty())
									next.getCalendar().addCourse(new Course(line));
							}
							break;
						case "appointments":
							while (scanner.hasNextLine()) {
								String line = scanner.nextLine();
								if (!line.isEmpty())
									next.getCalendar().addAppointment(new Appointment(line));
							}
							break;
						case "assignments":
							while (scanner.hasNextLine()) {
								String line = scanner.nextLine();
								if (!line.isEmpty())
									next.getCalendar().addAppointment(new Assignment(line));
							}
							break;
						case "exams":
							while (scanner.hasNextLine()) {
								String line = scanner.nextLine();
								if (!line.isEmpty())
									next.getCalendar().addAppointment(new Exam(line));
							}
							break;
						}
						scanner.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}
	
	public UserProfile getProfile(String username){
		return profiles.get(username);
	}
	
	public UserProfile createProfile(String username, String password) {
		if (profiles.containsKey(username)) {
			return null;
		}
		UserProfile user = new UserProfile(username, password);
		profiles.put(username, user);
		saveProfile(user);
		return user;
	}
}
