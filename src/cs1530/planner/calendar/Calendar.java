package cs1530.planner.calendar;

import cs1530.planner.calendar.event.Event;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Calendar {
	private Set<Course> courses;
	private SortedSet<Event> events;
	
	public Calendar() {
		this.courses = new HashSet<>();
		this.events = new TreeSet<>();
	}
}
