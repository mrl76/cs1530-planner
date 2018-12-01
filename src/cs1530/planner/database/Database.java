package cs1530.planner.database;

import cs1530.planner.calendar.Calendar;
import cs1530.planner.calendar.Course;
import cs1530.planner.calendar.UserProfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Database {
	private Map<String, UserProfile> profiles;
	
	public Database() {
		this.profiles = new HashMap<>();
	}
	
	public void save() {
		for(UserProfile profile : profiles.values())
			saveProfile(profile);
	}
	
	public void saveProfile(UserProfile profile) {
		File profileDir = new File("profile_" + profile.getUsername());
		while(!profileDir.exists()) {
			if(!profileDir.mkdir()) {
				System.out.println("Could not save profile \'" + profile.getUsername() + "\'");
				return;
			}
		}
		Calendar calendar = profile.getCalendar();
		File courseFile = new File(profileDir + File.separator + "courses.txt");
		FileWriter writer;
		try {
			writer = new FileWriter(courseFile, false);
			for(Course c : calendar.getCourses()) {
				writer.write(c.toString());
				writer.write(System.lineSeparator());
			}
			//TODO write the other properties of user profiles to other files
			writer.close();
		} catch(IOException ex) {
			System.out.println("Could not save profile \'" + profile.getUsername() + "\'");
		}
	}
	
	public void load() {
		File working = new File(System.getProperty("user.dir"));
		
		//TODO remove test code
		System.out.println(working);
		
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
			Scanner scanner;
			UserProfile next = new UserProfile(profileDir.getName().replaceFirst("profile_", ""));
			for(File f : profileData) {
				try {
					scanner = new Scanner(f);
					String filename = f.getName();
					if(filename.equals("courses.txt")) {
						//add all courses in courses.txt
						while(scanner.hasNextLine()) {
							String line = scanner.nextLine();
							if(!line.isEmpty())
								next.getCalendar().addCourse(new Course(line));
						}
						//TODO add more cases, one for each file type
					}
				} catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	public UserProfile getProfile(String username){
		return profiles.get(username);
	}
	
	public UserProfile createProfile(String username, String password) {
		UserProfile user = new UserProfile(username, password);
		profiles.put(username, user);
		saveProfile(user);
		return user;
	}
}
