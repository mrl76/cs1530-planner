package cs1530.planner.database;

import cs1530.planner.calendar.UserProfile;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void testConstructor()
    {
        Database testDatabase = new Database();
        // assertNotNull(testDatabase);
        System.out.println("Please finish testConstructor");
    }

    @Test
    public void testSave()
    {
        UserProfile testProfile1 = new UserProfile("testProfile1", "password1");
        UserProfile testProfile2 = new UserProfile("testProfile2", "passwrod2");

        System.out.println("Please add a .add method to Database.java");
    }

    @Test
    public void testSaveProfile()
    {
        System.out.println("Please add a .add method to Database.java");
    }

    @Test
    public void testLoad()
    {
        System.out.println("Please add a .add method to Database.java");
    }

    @Test
    public void testGetProfilePresent()
    {
        System.out.println("Please add a .add method to Database.java");
    }

    @Test
    public void testGetProfileNotPresent()
    {
        System.out.println("Please add a .add method to Database.java");
    }
}