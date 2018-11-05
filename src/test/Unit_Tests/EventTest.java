import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EventTest{
    private TestEvent testEvent;

    //case-full-constructor-happy-path
    @Test
    public void testFullConstructorHappyPath()
    {
        Date mockDate = Mokito.Mock(Date.class);
        testEvent = new TestEvent("testName", "testDescription", mockDate);
        assertEquals(testEvent.name, "testName");
        assertEquals(testEvent.description, "testDescription");
        assertEquals(testEvent.date, mockDate);
    }

    //case-short-constructor-happy-path
    @Test
    public void testShortConstructorHappyPath()
    {
        testEvent = new TestEvent("testName");
        assertEquals(testEvent.name, "testName");
        assertEquals(testEvent.descirption, "");
        //Im not sure how to test the date object
    }

    //case-get-name
    @Test
    public void testGetName()
    {

    }

    //case-set-name
    @Test
    public void testSetName()
    {

    }

    //case-get-description
    @Test
    public void testGetDescription()
    {

    }

    //case-set-description
    public void testSetDescription()
    {

    }
}

//test class so that we can access Event methods
//from the abstract class
public class TestEvent extends Event{   
}