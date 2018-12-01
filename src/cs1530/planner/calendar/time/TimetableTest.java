package cs1530.planner.calendar.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TimetableTest {
    @Test
    public void testFullConstructor()
    {
        Date mockStart = new Date();
        Date mockEnd = new Date();
        Date mockPrevious = new Date();
        Date mockNext = new Date();
        boolean testRepeating = false;
        int testIntervalSize = 7;
        Interval mockInterval = Interval.DAYS;
        boolean testAllDay = true;
        Timetable testTimetable = new Timetable(
                mockStart,
                mockPrevious,
                mockNext,
                mockEnd,
                testRepeating,
                testIntervalSize,
                mockInterval,
                testAllDay);

        assertSame(testTimetable.getStartDate(), mockStart);
        assertSame(testTimetable.getEndDate(), mockEnd);
        assertSame(testTimetable.getPreviousDate(), mockPrevious);
        assertSame(testTimetable.getNextDate(), mockNext);
        assertSame(testTimetable.getInterval(), mockInterval);

        assertFalse(testTimetable.isRepeating());
        assertTrue(testTimetable.isAllDay());
        assertTrue(testTimetable.getIntervalSize() == 7);
    }

    @Test
    public void testShortDateConstructor()
    {
        Date mockStart = new Date();
        Timetable testTimetable = new Timetable(mockStart);

        assertSame(testTimetable.getStartDate(), mockStart);
        assertSame(testTimetable.getEndDate(), mockStart);
        assertSame(testTimetable.getPreviousDate(), mockStart);
        assertNull(testTimetable.getNextDate());
        assertSame(testTimetable.getInterval(), Interval.DAYS);

        assertFalse(testTimetable.isRepeating());
        assertFalse(testTimetable.isAllDay());
        assertTrue(testTimetable.getIntervalSize() == 1);
    }

    @Test
    public void testDatastringConstructor()
    {
        String testDatastring = "0;t;0;t;null;t;null;t;1;t;DAYS;t;false;t;false";
        Timetable testTimetable = new Timetable(testDatastring);

        assertTrue(testTimetable.getStartDate().compareTo(new Date(0)) == 0);
        assertNull(testTimetable.getEndDate());
        assertTrue(testTimetable.getPreviousDate().compareTo(new Date(0)) == 0);
        assertNull(testTimetable.getNextDate());
        assertSame(testTimetable.getInterval(), Interval.DAYS);

        assertFalse(testTimetable.isRepeating());
        assertFalse(testTimetable.isAllDay());
        assertTrue(testTimetable.getIntervalSize() == 1);
    }

    @Test
    public void testToString()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        assertTrue(testTimetable.toString().equals(start.getTime() + ";t;" + start.getTime() + ";t;null;t;" + start.getTime() + ";t;" + 1 + ";t;DAYS;t;false;t;false"));
    }

    @Test
    public void testGetInterval()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        assertTrue(testTimetable.getInterval() == Interval.DAYS);
    }

    @Test
    public void testSetInterval()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        testTimetable.setInterval(Interval.YEARS);
        assertTrue(testTimetable.getInterval() == Interval.YEARS);
    }

    @Test
    public void testGetIntervalSize()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        assertTrue(testTimetable.getIntervalSize() == 1);
    }

    @Test
    public void testSetIntervalSize()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        testTimetable.setIntervalSize(2);
        assertTrue(testTimetable.getIntervalSize() == 2);
    }

    @Test
    public void testGetStartDate()
    {
        Date mockStart = new Date();
        Date mockEnd = new Date();
        Date mockPrevious = new Date();
        Date mockNext = new Date();
        boolean testRepeating = false;
        int testIntervalSize = 7;
        Interval mockInterval = Interval.DAYS;
        boolean testAllDay = true;
        Timetable testTimetable = new Timetable(
                mockStart,
                mockPrevious,
                mockNext,
                mockEnd,
                testRepeating,
                testIntervalSize,
                mockInterval,
                testAllDay);
        assertSame(mockStart, testTimetable.getStartDate());
    }

    @Test
    public void testSetStartDate()
    {
        Date mockStart = new Date();
        Date mockEnd = new Date();
        Date mockPrevious = new Date();
        Date mockNext = new Date();
        boolean testRepeating = false;
        int testIntervalSize = 7;
        Interval mockInterval = Interval.DAYS;
        boolean testAllDay = true;
        Timetable testTimetable = new Timetable(
                mockStart,
                mockPrevious,
                mockNext,
                mockEnd,
                testRepeating,
                testIntervalSize,
                mockInterval,
                testAllDay);
        Date newStart = new Date();
        testTimetable.setStartDate(newStart);
        assertSame(newStart, testTimetable.getStartDate());
    }

    @Test
    public void testGetEndDate()
    {
        Date mockStart = new Date();
        Date mockEnd = new Date();
        Date mockPrevious = new Date();
        Date mockNext = new Date();
        boolean testRepeating = false;
        int testIntervalSize = 7;
        Interval mockInterval = Interval.DAYS;
        boolean testAllDay = true;
        Timetable testTimetable = new Timetable(
                mockStart,
                mockPrevious,
                mockNext,
                mockEnd,
                testRepeating,
                testIntervalSize,
                mockInterval,
                testAllDay);
        assertSame(mockEnd, testTimetable.getEndDate());
    }

    @Test
    public void testSetEndDate()
    {
        Date mockStart = new Date();
        Date mockEnd = new Date();
        Date mockPrevious = new Date();
        Date mockNext = new Date();
        boolean testRepeating = false;
        int testIntervalSize = 7;
        Interval mockInterval = Interval.DAYS;
        boolean testAllDay = true;
        Timetable testTimetable = new Timetable(
                mockStart,
                mockPrevious,
                mockNext,
                mockEnd,
                testRepeating,
                testIntervalSize,
                mockInterval,
                testAllDay);
        Date newEnd = new Date();
        testTimetable.setEndDate(newEnd);
        assertSame(newEnd, testTimetable.getEndDate());
    }

    @Test
    public void testIsAllDay()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        assertFalse(testTimetable.isAllDay());
    }

    @Test
    public void testSetAllDay()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        testTimetable.setAllDay(true);
        assertTrue(testTimetable.isAllDay());
    }
}