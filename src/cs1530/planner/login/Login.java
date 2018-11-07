/*
*Back end log in 
*receives loaded profiles from main and username 
*checks if username entered in is pa
*/
package cs1530.planner.login;

import cs1530.planner.calendar.UserProfile;
import cs1530.planner.database.Database;

import java.util.Set;


public final class Login {
	/*
	*static method to take a username password and list of profiles to validate 
	*returns null currently if not found we can change this depending on how we want to handle it
	*/
	public static UserProfile userLogin(String username, String password, Database database) {
		//user is return value exists is flag to find profile
		UserProfile user;
		if((user = database.getProfile(username)) == null)
			return null;
		
		//validate password if correct return user
		return user.verifyPassword(password) ? user : null;
	}
	
	//adds new user to the set then returns said profile so that user is logged in and use their new calendar
	public static UserProfile createProfile(String username, String password, Set<UserProfile> profiles) {
		UserProfile newUser = new UserProfile(username, password);
		profiles.add(newUser);
		return newUser;
	}

}

