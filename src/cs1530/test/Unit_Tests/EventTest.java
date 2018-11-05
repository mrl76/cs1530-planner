import org.junit.*;
import static org.junit.Assert.*;
import org.mockito.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;

public class EventTest{
    private TestEvent testEvent;

    //case-event-full-constructor
    @Test
    public void testFullConstructor()
    {
        Date mockDate = Mokito.Mock(Date.class);
        testEvent = new TestEvent("testName", "testDescription", mockDate);
        assertTrue(testEvent.getName().equals("testName"));
        assertTrue(testEvent.getDescription().equals("testDescription"));
        assertSame(testEvent.getDate(), mockDate);
    }

    //case-event-short-constructor
    @Test
    public void testShortConstructor()
    {
        testEvent = new TestEvent("testName");
        assertTrue(testEvent.getName().equals("testName"));
        assertTrue(testEvent.getDescirption().equals(""));
        //Im not sure how to test the date object due to it being time dependant
    }

    //case-event-get-name
    @Test
    public void testGetName()
    {
        testEvent = new TestEvent("testName");
        assertTrue(testEvent.getName().equals("testName"));
    }

    //case-event-set-name
    @Test
    public void testSetName()
    {
        testEvent = new TestEvent("testName");
        testEvent.setName("newName");
        assertTrue(testEvent.getName().equals("newName"));
    }

    //case-event-get-description
    @Test
    public void testGetDescription()
    {
        Date mockDate = Mokito.Mock(Date.class);
        testEvent = new TestEvent("testName", "testDescritption", mockDate);
        assertTrue(testEvent.getDescirption().equals("testDescription"));
    }

    //case-event-set-description
    @Test
    public void testSetDescription()
    {
        Date mockDate = Mokito.Mock(Date.class);
        testEvent = new TestEvent("testName", "testDescritption", mockDate);
        testEvent.setDescription("newDescription");
        assertTrue(testEvent.getDescirption().equals("newDescription"));
    }

    //case-event-get-date
    @Test
    public void testGetDate()
    {
        Date mockDate = Mokito.Mock(Date.class);
        testEvent = new TestEvent("testName", "testDescritption", mockDate);
        assertSame(testEvent.getDate(), mockDate);
    }

    //case-event-set-date
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

    //case-event-compare-to-greater
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

    //case-event-compare-to-less
    @Test
    public void testCompareToLess()
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
    public TestEvent(String name, String description, Date date)
    {
        super(name, description, date);
    }
    
    public TestEvent(String name)
    {
        super(name);
    }
}