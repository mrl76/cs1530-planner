package cs1530.planner.calendar.event;

public enum EventType {
	APPOINTMENT, ASSIGNMENT, EXAM, COURSE;
	
	public static EventType getType(Appointment event) {
		if(event instanceof Assignment)
			return ASSIGNMENT;
		if(event instanceof Exam)
			return EXAM;
		return APPOINTMENT;
	}
}
