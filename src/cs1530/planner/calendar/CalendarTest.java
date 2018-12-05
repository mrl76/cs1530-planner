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
        UserProfile testUser = new UserProfile("testName","testPass");
        Calendar testC = new Calendar(testUser);
        assertNotNull(testC);
    }
    
    @Test
    public void testGetCourses()
    {
        UserProfile testUser = new UserProfile("testName","testPass");
        Calendar testC = new Calendar(testUser);
        Class courseType = testC.getCourses().getClass();
        assertTrue(courseType.getName().equals("java.util.HashSet"));
    }
    
    
    @Test
    public void testAddCourse()
    {
        UserProfile testUser = new UserProfile("testName","testPass");
        Calendar testC = new Calendar(testUser);
        Date testDate = new Date();
        Timetable testTimetable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription",testTimetable);
        
        testC.addCourse(testCourse);
        assertTrue(testC.getCourses().contains(testCourse));
    }
    
    @Test
    public void testRemoveCourses()
    {
        UserProfile testUser = new UserProfile("testName","testPass");
        Calendar testC = new Calendar(testUser);
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
        UserProfile testUser = new UserProfile("testName","testPass");
        Calendar testC = new Calendar(testUser);
        Class eventType = testC.getEvents().getClass();
        assertTrue(eventType.getName().equals("java.util.TreeSet"));
    }
    
    
    @Test
    public void testGetAlarms()
    {
        UserProfile testUser = new UserProfile("testName","testPass");
        Calendar testC = new Calendar(testUser);
        Class alarmsType = testC.getAlarms().getClass();
        assertTrue(alarmsType.getName().equals("java.util.TreeSet"));
    }
    
    
    @Test
    public void testAddAppointment()
    {
        UserProfile testUser = new UserProfile("testName","testPass");
        Calendar testC = new Calendar(testUser);
        Date testDate = new Date();
        Appointment testAppointment = new Appointment("TEST1","TESTdescription",testDate);
        testC.addAppointment(testAppointment);
        
        assertTrue(testC.getEvents().contains(testAppointment));
    }
    
    
    @Test
    public void testRemoveAppointment()
    {
        UserProfile testUser = new UserProfile("testName","testPass");
        Calendar testC = new Calendar(testUser);
        Date testDate = new Date();
        Appointment testAppointment = new Appointment("TEST1","TESTdescription",testDate);
        testC.addAppointment(testAppointment);
        testC.removeAppointment(testAppointment);
        
        assertFalse(testC.getEvents().contains(testAppointment));
    }

    @Test
    public void testGetAppointements()
    {
        UserProfile testUser = new UserProfile("testName","testPass");
        Calendar testC = new Calendar(testUser);
        Date testDate = new Date();
        Appointment testAppointment = new Appointment("TEST1","TESTdescription",testDate);
        testC.addAppointment(testAppointment);
        assertTrue(testC.getAppointments().contains(testAppointment));
    }
    
    @Test
    public void testResetDate()
    {
        UserProfile testUser = new UserProfile("testName","testPass");
        Calendar testC = new Calendar(testUser);
        Date testDate = new Date();
        Exam testA = new Exam("testA","testDescription",testDate, "testCourse");
        
        Date testDate2 = new Date();
        testC.resetDate(testA, testDate2);
        
        assertSame(testA.getDate(),testDate2);
    }
    
    
    @Test
    public void testResetDateAssginment()
    {
        UserProfile testUser = new UserProfile("testName","testPass");
        Calendar testC = new Calendar(testUser);
        Date testDate = new Date();
        Assignment testA = new Assignment("testA","Hello",testDate,"testCourse");
        
        Date testDate2 = new Date();
        testC.resetDate(testA, testDate2);
        
        assertSame(testA.getDate(),testDate2);
    }

}//end of CalendarTest
