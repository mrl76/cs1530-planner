package cs1530.planner.calendar.event;

import cs1530.planner.calendar.time.Timetable;
import cs1530.planner.calendar.Course;
import cs1530.planner.util.Utils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ExamTest {
    
    //Test full constructor
    @Test
    public void testFullConstructor() {
        Date testDate = new Date();
        Timetable testTimetable = new Timetable(testDate);
        Course testCourse = new Course("testName", "testDescription", testTimetable);
        Exam testA = new Exam("testA","testDescription",testDate, "testCourse");

        assertTrue(testA.getName().equals("testA"));
        assertTrue(testA.getDescription().equals("testDescription"));
        assertSame(testA.getCourse(), "testCourse");
        assertSame(testA.getDate(), testDate);
    }

    @Test
    public void testDatastringConstructor()
    {
        String datastring = "testName;e;testDescription;e;0;e;testCourse";
        Exam testA = new Exam(datastring);
        assertTrue(testA.getName().equals("testName"));
        assertTrue(testA.getDescription().equals("testDescription"));
        assertTrue(testA.getCourse().equals("testCourse"));
        assertTrue(testA.getDate().compareTo(new Date(0)) == 0);
    }
    
    //Test accessors and mutators
    @Test
    public void testGetCourse()
    {
        Date testDate = new Date();
        Exam testA = new Exam("testA","testDescription",testDate, "testCourse");

        assertTrue(testA.getCourse().equals("testCourse"));
    }
    
    @Test
    public void testSetCourse()
    {
        Date testDate = new Date();
        Exam testA = new Exam("testA","testDescription",testDate, "testCourse");

        assertTrue(testA.getCourse().equals("testCourse"));
        testA.setCourse("testCourse2");
        assertTrue(testA.getCourse().equals("testCourse2"));
        
    }
    
    @Test
    public void testGetName()
    {
        Date testDate = new Date();
        Exam testA = new Exam("testA","testDescription",testDate, "testCourse");
        
        assertTrue(testA.getName().equals("testA"));
    }
    
    @Test
    public void testSetName()
    {
        Date testDate = new Date();
        Exam testA = new Exam("testA","testDescription",testDate, "testCourse");
        assertTrue(testA.getName().equals("testA"));
        testA.setName("newName");
        assertTrue(testA.getName().equals("newName"));
    }
    
    @Test
    public void testGetDescription()
    {
        Date testDate = new Date();
        Exam testA = new Exam("testA","Hello",testDate,"testCourse");
        assertTrue(testA.getDescription().equals("Hello"));
    }
    
    
    @Test
    public void testSetDescription()
    {
        Date testDate = new Date();
        Exam testA = new Exam("testA","Hello",testDate,"testCourse");
        
        
        testA.setDescription("NewDescription");
        assertTrue(testA.getDescription().equals("NewDescription"));
    }
    
    
    @Test
    public void testGetDate()
    {
        Date testDate = new Date();
        Exam testA = new Exam("testA","Hello",testDate,"testCourse");
        
        assertSame(testA.getDate(),testDate);
    }
    
    @Test
    public void testSetDate()
    {
        Date testDate = new Date();
        Exam testA = new Exam("testA","Hello",testDate,"testCourse");
        
        assertSame(testA.getDate(),testDate);
        
        Date testDate2 = new Date();
        testA.setDate(testDate2);
        assertSame(testA.getDate(),testDate2);
    }
    
}//end of exam test
