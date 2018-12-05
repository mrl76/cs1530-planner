package cs1530.planner.calendar.event;

import cs1530.planner.calendar.time.Timetable;
import cs1530.planner.util.Utils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AppointmentTest {
    
    //Test full constructor
    @Test
    public void testFullConstructor()
    {
        Date testDate = new Date();
        Appointment testAppointment = new Appointment("TEST1","TESTdescription",testDate);
        assertTrue(testAppointment.getName().equals("TEST1"));
        assertTrue(testAppointment.getDescription().equals("TESTdescription"));
        assertSame(testAppointment.getDate(), testDate);
    }

    @Test
    public void testDatastringConstructor()
    {
        String datastring = "testName;a;testDescription;a;0";
        Appointment testA = new Appointment(datastring);
        assertTrue(testA.getName().equals("testName"));
        assertTrue(testA.getDescription().equals("testDescription"));
        assertTrue(testA.getDate().compareTo(new Date(0)) == 0);
    }
    
    
    @Test
    public void testGetName()
    {
        Date testDate = new Date();
        Appointment testAppointment = new Appointment("TEST1","TESTdescription",testDate);
        assertTrue(testAppointment.getName().equals("TEST1"));
    }
    
    @Test
    public void testSetName()
    {
        Date testDate = new Date();
        Appointment testAppointment = new Appointment("TEST1","TESTdescription",testDate);
        assertTrue(testAppointment.getName().equals("TEST1"));
        testAppointment.setName("TEST2");
        assertTrue(testAppointment.getName().equals("TEST2"));
    }
    
    
    @Test
    public void testGetDescription()
    {
        Date testDate = new Date();
        Appointment testAppointment = new Appointment("TEST1","TESTdescription",testDate);
        
        assertTrue(testAppointment.getDescription().equals("TESTdescription"));
        
    }
    
    
    @Test
    public void testSetDescription()
    {
        Date testDate = new Date();
        Appointment testAppointment = new Appointment("TEST1","TESTdescription",testDate);
        
        assertTrue(testAppointment.getDescription().equals("TESTdescription"));
        testAppointment.setDescription("Hi");
        assertTrue(testAppointment.getDescription().equals("Hi"));
    }
    
    
    @Test
    public void testGetDate()
    {
        Date testDate = new Date();
        Appointment testAppointment = new Appointment("TEST1","TESTdescription",testDate);
        
        assertSame(testAppointment.getDate(), testDate);
    }
    
    @Test
    public void testSetDate()
    {
        Date testDate = new Date();
        Appointment testAppointment = new Appointment("TEST1","TESTdescription",testDate);
        assertSame(testAppointment.getDate(), testDate);
        
        Date testDate2 = new Date();
        testAppointment.setDate(testDate2);
        assertSame(testAppointment.getDate(),testDate2);
    }
    
    
    
    
}//end of AppointmentTest
