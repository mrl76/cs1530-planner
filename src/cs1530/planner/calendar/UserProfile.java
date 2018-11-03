package cs1530.planner.calendar;

import cs1530.planner.calendar.Calendar;


//User profile class for holdinng username password and calendar
public class UserProfile{
	
	private String username;
	private String password;
	private Calendar calendar;
	
	//cpnstructor
	public UserProfile(String name, String pw){
		this.username = name;
		this.password = pw;
		this.calendar = new Calendar();
	}
	
	//constructor
	public UserProfile(String name, String pw, Calendar cal){
		this.username = name;
		this.password = password;
		this.calendar = cal;
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
	public boolean veriifyPassword(String attempt){
		if(attempt.equals(password)){
			return true;
		}else{
			return false;
		}
	}
	
	//used to verify username for login
	public boolean verifyUserName(String attempt){
		if(attempt.equals(username)){
			return true;
		}else{
			return false;
		}		
	}
	
	//for resetting username
	public void resetUserName(String newName){
		this.username = newName;
	}
	
	//verifys old password then resets it to new password
	//returns true on success false on failure
	public boolean resetPassword(String newPassword, String oldPassword){
		if(veriifyPassword(oldPassword)){
			this.password = newPassword;
			return true;
		}else{
			return false;
		}
	}
	
	//WILL NEED MORE METHODS PROBABLY AS SOON AS CALENDAR IS COMPLETED OR I MAY BE WRONG DEPENDING ON HOW THATS STRUCTURE
		
}