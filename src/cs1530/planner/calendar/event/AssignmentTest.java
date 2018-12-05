package cs1530.planner.calendar.event;

import cs1530.planner.calendar.time.Timetable;
import cs1530.planner.calendar.Course;
import cs1530.planner.util.Utils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AssignmentTest {
    
    
    //Test full constructor
    @Test
    public void testFullConstructor()
    {
        Date testDate = new Date();
        Assignment testA = new Assignment("testA","Hello",testDate,"testCourse");
        
        assertTrue(testA.getName().equals("testA"));
        assertTrue(testA.getDescription().equals("Hello"));
        assertTrue(testA.getCourse().equals("testCourse"));
        assertSame(testA.getDate(),testDate);
    }
    
    
    //Test constructor with only name and course
    @Test
    public void testNameCourseConstructor()
    {
        Date testDate = new Date();
        Assignment testA = new Assignment("testA","testDescription", testDate,"testCourse");
        
        assertTrue(testA.getName().equals("testA"));
        assertTrue(testA.getDescription().equals("testDescription"));
        assertTrue(testA.getCourse().equals("testCourse"));
    }
    
    //Test constructor with only name
    @Test
    public void testNameConstructor()
    {
        Date testDate = new Date();
        Assignment testA = new Assignment("testA","Hello",testDate,"testCourse");
        
        assertTrue(testA.getName().equals("testA"));
        assertTrue(testA.getDescription().equals("Hello"));
    }
    
    
    //Test accessors and mutators
    @Test
    public void testGetCourse()
    {
        Date testDate = new Date();
        Assignment testA = new Assignment("testA","Hello",testDate,"testCourse");
        
        assertTrue(testA.getCourse().equals("testCourse"));
    }
    
    @Test
    public void testSetCourse()
    {
        Date testDate = new Date();
        Assignment testA = new Assignment("testA","Hello",testDate,"testCourse");
        assertTrue(testA.getCourse().equals("testCourse"));
        testA.setCourse("testCourse2");
        assertTrue(testA.getCourse().equals("testCourse2"));

    }
    
    @Test
    public void testGetName()
    {
        Date testDate = new Date();
        Assignment testA = new Assignment("testA","Hello",testDate,"testCourse");
        
        assertTrue(testA.getName().equals("testA"));
    }
    
    @Test
    public void testSetName()
    {
        Date testDate = new Date();
        Assignment testA = new Assignment("testA","Hello",testDate,"testCourse");
        
        assertTrue(testA.getName().equals("testA"));
        testA.setName("newName");
        assertTrue(testA.getName().equals("newName"));
    }
    
    @Test
    public void testGetDescription()
    {
        Date testDate = new Date();
        Assignment testA = new Assignment("testA","Hello",testDate,"testCourse");
        assertTrue(testA.getDescription().equals("Hello"));
    }
    
    
    @Test
    public void testSetDescription()
    {
        Date testDate = new Date();
        Assignment testA = new Assignment("testA","Hello",testDate,"testCourse");
        
        
        testA.setDescription("NewDescription");
        assertTrue(testA.getDescription().equals("NewDescription"));
    }
    
    
    @Test
    public void testGetDate()
    {
        Date testDate = new Date();
        Assignment testA = new Assignment("testA","Hello",testDate,"testCourse");
        
        assertSame(testA.getDate(),testDate);
    }
    
    @Test
    public void testSetDate()
    {
        Date testDate = new Date();
        Assignment testA = new Assignment("testA","Hello",testDate,"testCourse");
        
        assertSame(testA.getDate(),testDate);
        
        Date testDate2 = new Date();
        testA.setDate(testDate2);
        assertSame(testA.getDate(),testDate2);
    }

    
    
}//end of Assignment test
