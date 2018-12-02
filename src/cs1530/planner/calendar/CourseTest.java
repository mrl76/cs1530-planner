package cs1530.planner.calendar;

import cs1530.planner.calendar.time.Timetable;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class CourseTest {
    //case-course-full-constructor
    @Test
    public void testFullConstructor()
    {
        Date testDate = new Date();
        Timetable testTimetable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription",testTimetable);
        assertTrue(testCourse.getName().equals("testName"));
        assertTrue(testCourse.getDescription().equals("testDescription"));
        assertSame(testCourse.getTimetable(), testTimetable);
    }

    // date string constructor still needs implemented
    @Test
    public void testDataStringConstructor()
    {
        String testDatastring = "testName;c;testDescription;c;0;t;0;t;null;t;null;t;1;t;DAYS;t;false;t;false";
        Course testCourse = new Course(testDatastring);
        Timetable testTimetable = new Timetable("0;t;0;t;null;t;null;t;1;t;DAYS;t;false;t;false");
        assertTrue(testCourse.getName().equals("testName"));
        assertTrue(testCourse.getDescription().equals("testDescription"));
        assertTrue(testCourse.getTimetable().toString().equals(testTimetable.toString()));
    }

    @Test
    public void testGetName()
    {
        Date testDate = new Date();
        Timetable testTimetable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription",testTimetable);
        assertTrue(testCourse.getName().equals("testName"));
    }

    @Test
    public void testSetName()
    {
        Date testDate = new Date();
        Timetable testTimetable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription",testTimetable);
        testCourse.setName("newName");
        assertTrue(testCourse.getName().equals("newName"));
    }

    @Test
    public void testGetDescription()
    {
        Date testDate = new Date();
        Timetable testTimetable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription",testTimetable);
        assertTrue(testCourse.getDescription().equals("testDescription"));
    }

    @Test
    public void testSetDescription()
    {
        Date testDate = new Date();
        Timetable testTimetable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription",testTimetable);
        testCourse.setDescription("newDescription");
        assertTrue(testCourse.getDescription().equals("newDescription"));
    }

    @Test
    public void testGetTimetable()
    {
        Date testDate = new Date();
        Timetable testTimetable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription",testTimetable);
        assertSame(testTimetable, testCourse.getTimetable());
    }

    @Test
    public void testSetTimetable()
    {
        Date testDate = new Date();
        Timetable testTimetableTable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription",testTimetableTable);
        Timetable newTimetable = new Timetable(testDate);
        testCourse.setTimetable(newTimetable);
        assertSame(newTimetable, testCourse.getTimetable());
    }

    @Test
    public void testToString()
    {
        Date testDate = new Date();
        Timetable testTimetableTable = new Timetable("0;t;0;t;null;t;null;t;1;t;DAYS;t;false;t;false");
        Course testCourse = new Course("testName", "testDescription",testTimetableTable);
        assertTrue(testCourse.toString().equals("testName;c;testDescription;c;0;t;0;t;null;t;null;t;1;t;DAYS;t;false;t;false"));
    }
}