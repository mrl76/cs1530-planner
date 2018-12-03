package cs1530.planner.calendar;

import cs1530.planner.calendar.event.Appointment;
import cs1530.planner.calendar.event.Assignment;
import cs1530.planner.calendar.event.Exam;
import cs1530.planner.calendar.time.Timetable;
import cs1530.planner.calendar.Course;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Date;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalendarTest {

    //Test constructor
    @Test
    public void testConstructor()
    {
        Calendar testC = new Calendar();
        Class courseType = testC.getCourses().getClass();
        Class eventType = testC.getEvents().getClass();
        Class alarmType = testC.getAlarms().getClass();
        assertTrue(courseType.getName().equals("java.util.HashSet"));
        assertTrue(eventType.getName().equals("java.util.TreeSet"));
        assertTrue(alarmType.getName().equals("java.util.TreeSet"));
    }
    
    @Test
    public void testGetCourses()
    {
        Calendar testC = new Calendar();
        Class courseType = testC.getCourses().getClass();
        assertTrue(courseType.getName().equals("java.util.HashSet"));
    }
    
    
    @Test
    public void testAddCourse()
    {
        Calendar testC = new Calendar();
        Date testDate = new Date();
        Timetable testTimetable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription",testTimetable);
        
        testC.addCourse(testCourse);
        assertTrue(testC.getCourses().contains(testCourse));
    }
    
    @Test
    public void testRemoveCourses()
    {
        Calendar testC = new Calendar();
        Date testDate = new Date();
        Timetable testTimetable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription",testTimetable);
        
        testC.addCourse(testCourse);
        testC.removeCourse(testCourse);
        assertFalse(testC.getCourses().contains(testCourse));
    }
    
    @Test
    public void testGetEvents()
    {
        Calendar testC = new Calendar();
        Class eventType = testC.getEvents().getClass();
        assertTrue(eventType.getName().equals("java.util.TreeSet"));
    }
    
    
    @Test
    public void testGetAlarms()
    {
        Calendar testC = new Calendar();
        Class alarmsType = testC.getAlarms().getClass();
        assertTrue(alarmsType.getName().equals("java.util.TreeSet"));
    }
    
    
    @Test
    public void testAddAppointment()
    {
        Calendar testC = new Calendar();
        Date testDate = new Date();
        Appointment testAppointment = new Appointment("TEST1","TESTdescription",testDate);
        testC.addAppointment(testAppointment);
        
        assertTrue(testC.getEvents().contains(testAppointment));
        
        
    }
    
    
    @Test
    public void testRemoveAppointment()
    {
        Calendar testC = new Calendar();
        Date testDate = new Date();
        Appointment testAppointment = new Appointment("TEST1","TESTdescription",testDate);
        testC.addAppointment(testAppointment);
        testC.removeAppointment(testAppointment);
        
        assertFalse(testC.getEvents().contains(testAppointment));
    }
    
    
    @Test
    public void testResetDate()
    {
        Calendar testC = new Calendar();
        Date testDate = new Date();
        Timetable testTimetable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription",testTimetable);
        Exam testA = new Exam("testA","Hello",testDate,testCourse);
        
        Date testDate2 = new Date();
        testC.resetDate(testA, testDate2);
        
        assertSame(testA.getDate(),testDate2);
    }
    
    
    @Test
    public void testResetDateAssginment()
    {
        Calendar testC = new Calendar();
        Date testDate = new Date();
        Timetable testTimetable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription",testTimetable);
        Assignment testA = new Assignment("testA","Hello",testDate,testCourse);
        
        Date testDate2 = new Date();
        testC.resetDate(testA, testDate2);
        
        assertSame(testA.getDate(),testDate2);
    }

}//end of CalendarTest
