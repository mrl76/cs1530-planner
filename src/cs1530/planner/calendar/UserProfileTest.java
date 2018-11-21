package cs1530.planner.calendar;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserProfileTest {

    @Test
    public void testFullConstructor()
    {
        Calendar testCal = new Calendar();
        UserProfile testUserProfile = new UserProfile("user1", "pass1", testCal);
        assertTrue(testUserProfile.getUsername().equals("user1"));
        assertTrue(testUserProfile.verifyPassword("pass1"));
        assertSame(testUserProfile.getCalendar(), testCal);
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
        Calendar testCal = new Calendar();
        UserProfile testUserProfile = new UserProfile("user1", "pass1", testCal);
        assertSame(testUserProfile.getCalendar(), testCal);
    }

    @Test
    public void testGetUsername()
    {
        Calendar testCal = new Calendar();
        UserProfile testUserProfile = new UserProfile("user1", "pass1", testCal);
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
    public void testResetUsername()
    {
        UserProfile testUserProfile = new UserProfile("user1");
        testUserProfile.resetUserName("user2");
        assertTrue(testUserProfile.getUsername().equals("user2"));
    }

    // bad implementation of method under test, should not have to pass in old password
    @Test
    public void testResetPasswordEqual()
    {
        UserProfile testUserProfile = new UserProfile("user1", "pass1");
        assertTrue(testUserProfile.resetPassword("pass1", "pass1"));
        assertTrue(testUserProfile.verifyPassword("pass1"));
    }

    @Test
    public void testResetPasswordNotEqual()
    {
        UserProfile testUserProfile = new UserProfile("user1", "pass1");
        assertFalse(testUserProfile.resetPassword("pass2", "pass2"));
        assertTrue(testUserProfile.verifyPassword("pass1"));
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