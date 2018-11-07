/*
*Back end log in 
*receives loaded profiles from main and username 
*checks if username entered in is pa
*/
package cs1530.planner.login;

import cs1530.planner.calendar.UserProfile;
import cs1530.planner.database.Database;
import java.util.Set;
import java.util.HashSet;


public final class Login{
	
	/*
	*static method to take a username password and list of profiles to validate 
	*returns null currentllly if not found we can change this depending on how we want to handle it
	*/
	public static UserProfile userLogin(String username, String password, Set<UserProfile> profiles){
		
		//user is return value exists is flag to find profile
		boolean exists = false;
		UserProfile user = null;
			
		//search for username in list of profiles
		for(UserProfile profile: profiles){
			if(username.equals(profile.getUsername())){
				exists = true;
				user = profile;
				break;
			}
		}
		
		//if profile not in list rurn null could display message in ui suggesting to create profile
		if(!exists){
			return null;
		}
		
		//validate password if correct return user 
		if(user.verifyPassword(password)){
			return user;
		}else{
			return null;
		}
	}
	
	//adds new user to the set then returns said profile so that user is logged in and use their new calendar
	public static UserProfile createProfile(String username, String password, Set<UserProfile> profiles){
		UserProfile newUser = new UserProfile(username, password);
		profiles.add(newUser);
		return newUser;
	}

}

