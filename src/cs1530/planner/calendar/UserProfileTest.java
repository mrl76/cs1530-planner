package cs1530.planner.calendar;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserProfileTest {

    @Test
    public void testFullConstructor()
    {
        UserProfile testUserProfile = new UserProfile("user1", "pass1");
        assertTrue(testUserProfile.getUsername().equals("user1"));
        assertTrue(testUserProfile.verifyPassword("pass1"));
    }

    @Test
    public void testNamePasswordConstructor()
    {
        UserProfile testUserProfile = new UserProfile("user1", "pass1");
        assertTrue(testUserProfile.getUsername().equals("user1"));
        assertTrue(testUserProfile.verifyPassword("pass1"));
        assertNotNull(testUserProfile.getCalendar());
    }

    @Test
    public void testNameConstructor()
    {
        UserProfile testUserProfile = new UserProfile("user1");
        assertTrue(testUserProfile.getUsername().equals("user1"));
        assertNotNull(testUserProfile.getCalendar());
    }

    @Test
    public void testGetCalendar()
    {
        UserProfile testUserProfile = new UserProfile("user1", "pass1");
        Calendar testCal = testUserProfile.getCalendar();
        assertNotNull(testCal);
    }

    @Test
    public void testGetUsername()
    {
        UserProfile testUserProfile = new UserProfile("user1", "pass1");
        assertTrue(testUserProfile.getUsername().equals("user1"));
    }

    @Test
    public void testVerifyPasswordCorrect()
    {
        UserProfile testUserProfile = new UserProfile("user1", "pass1");
        assertTrue(testUserProfile.verifyPassword("pass1"));
    }

    @Test
    public void testVerifyPasswordIncorrect()
    {
        UserProfile testUserProfile = new UserProfile("user1", "pass1");
        assertFalse(testUserProfile.verifyPassword("pass2"));
    }

    @Test
    public void testVerifyUsernameCorrect()
    {
        UserProfile testUserProfile = new UserProfile("user1");
        assertTrue(testUserProfile.getUsername().equals("user1"));
    }

    @Test
    public void testVerifyUsernameIncorrect()
    {
        UserProfile testUserProfile = new UserProfile("user1");
        assertFalse(testUserProfile.getUsername().equals("user2"));
    }

    @Test
    public void testEqualsTrue()
    {
        UserProfile testUserProfile = new UserProfile("user1", "pass1");
        UserProfile comparisonUserProfile = new UserProfile("user1", "pass1");
        assertTrue(testUserProfile.equals(comparisonUserProfile));
    }

    @Test
    public void testEqualsNotUserProfile()
    {
        UserProfile testUserProfile = new UserProfile("user1", "pass1");
        Date notUserProfile = new Date();
        assertFalse(testUserProfile.equals(notUserProfile));
    }

    @Test
    public void testEqualsUsernameNotEqual()
    {
        UserProfile testUserProfile = new UserProfile("user1", "pass1");
        UserProfile comparisonUserProfile = new UserProfile("user2", "pass1");
        assertFalse(testUserProfile.equals(comparisonUserProfile));
    }

    @Test
    public void testHashCode()
    {
        String testUsername = "user1";
        UserProfile testUserProfile = new UserProfile(testUsername, "pass1");
        assertTrue(testUserProfile.hashCode() == testUsername.hashCode());
    }
}