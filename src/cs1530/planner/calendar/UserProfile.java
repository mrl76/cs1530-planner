package cs1530.planner.calendar;

//User profile class for holding username password and calendar
public class UserProfile {
	private String username;
	private String password;
	private Calendar calendar;
	
	//constructors
	public UserProfile(String name, String password, Calendar cal){
		this.username = name;
		this.password = password;
		this.calendar = cal;
	}
	
	public UserProfile(String name, String password){
		this(name, password, new Calendar());
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
	
	//verifies old password then resets it to new password
	//returns true on success false on failure
	public boolean resetPassword(String newPassword, String oldPassword){
		if(verifyPassword(oldPassword)){
			this.password = newPassword;
			return true;
		}else{
			return false;
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