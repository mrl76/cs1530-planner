import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.concurrent.TimeUnit;
import cs1530.planner.calendar.event.*;

public class EventTest{
    private TestEvent testEvent;

    //case-full-constructor-happy-path
    @Test
    public void testFullConstructorHappyPath()
    {
        Date mockDate = Mokito.Mock(Date.class);
        testEvent = new TestEvent("testName", "testDescription", mockDate);
        assertTrue(testEvent.getName().equals("testName"));
        assertTrue(testEvent.getDescription().equals("testDescription"));
        assertSame(testEvent.getDate(), mockDate);
    }

    //case-short-constructor-happy-path
    @Test
    public void testShortConstructorHappyPath()
    {
        testEvent = new TestEvent("testName");
        assertTrue(testEvent.getName().equals("testName"));
        assertTrue(testEvent.getDescirption().equals(""));
        //Im not sure how to test the date object due to it being time dependant
    }

    //case-get-name
    @Test
    public void testGetName()
    {
        testEvent = new TestEvent("testName");
        assertTrue(testEvent.getName().equals("testName"));
    }

    //case-set-name
    @Test
    public void testSetName()
    {
        testEvent = new TestEvent("testName");
        testEvent.setName("newName");
        assertTrue(testEvent.getName().equals("newName"));
    }

    //case-get-description
    @Test
    public void testGetDescription()
    {
        Date mockDate = Mokito.Mock(Date.class);
        testEvent = new TestEvent("testName", "testDescritption", mockDate);
        assertTrue(testEvent.getDescirption().equals("testDescription"));
    }

    //case-set-description
    @Test
    public void testSetDescription()
    {
        Date mockDate = Mokito.Mock(Date.class);
        testEvent = new TestEvent("testName", "testDescritption", mockDate);
        testEvent.setDescription("newDescription");
        assertTrue(testEvent.getDescirption().equals("newDescription"));
    }

    //case-get-date
    @Test
    public void testGetDate()
    {
        Date mockDate = Mokito.Mock(Date.class);
        testEvent = new TestEvent("testName", "testDescritption", mockDate);
        assertSame(testEvent.getDate(), mockDate);
    }

    //case-set-date
    @Test
    public void testSetDate()
    {
        Date startDate = new Date();
        TimeUnit.SECONDS.sleep(1);
        Date newDate = new Date();
        testEvent = new TestEvent("testName", "testDescription", startDate);
        testEvent.setDate(newDate);
        assertSame(testEvent.getDate(), newDate);
    }

    //case-compare-to-greater
    @Test
    public void testCompareToGreater()
    {
        Date startDate = new Date();
        TimeUnit.SECONDS.sleep(1);
        Date endDate = new Date();
        smallEvent = new TestEvent("smallEvent", "testDescription", startDate);
        largeEvent = new TestEvent("largeEvent" , "testDescription", endDate);
        assertTrue(smallEvent.compareTo(largeEvent) > 0);
    }

    //case-compare-to-less
    @Test
    public void testCompareToGreater()
    {
        Date startDate = new Date();
        TimeUnit.SECONDS.sleep(1);
        Date endDate = new Date();
        smallEvent = new TestEvent("smallEvent", "testDescription", startDate);
        largeEvent = new TestEvent("largeEvent" , "testDescription", endDate);
        assertTrue(largeEvent.compareTo(smallEvent) < 0);
    }
}

//test class so that we can access Event methods
//from the abstract class
class TestEvent extends Event{   
}