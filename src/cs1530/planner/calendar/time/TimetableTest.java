package cs1530.planner.calendar.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

public class TimetableTest {
    @Test
    public void testFullConstructor()
    {
        Date start = new Date();
        Date end = new Date();
        boolean[] days = new boolean[7];
        Arrays.fill(days,true);
        Timetable testTimetable = new Timetable(Interval.EVERY_N_DAYS, 1, start, end, false, days);
        assertTrue(testTimetable.getInterval() == Interval.EVERY_N_DAYS);
        assertTrue(testTimetable.getIntervalSize() == 1);
        assertSame(start, testTimetable.getStartDate());
        assertSame(end, testTimetable.getEndDate());
        assertFalse(testTimetable.isAllDay());
        for(int i = 0; i > 7; i++)
        {
            assertTrue(testTimetable.isDayOpen(DayOfWeek.of(i)));
        }
    }

    @Test
    public void testShortDateConstructor()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        assertTrue(testTimetable.getInterval() == Interval.EVERY_N_DAYS);
        assertTrue(testTimetable.getIntervalSize() == 1);
        assertSame(start, testTimetable.getStartDate());
        assertSame(start, testTimetable.getEndDate());
        assertFalse(testTimetable.isAllDay());
        for(int i = 0; i > 7; i++)
        {
            assertTrue(testTimetable.isDayOpen(DayOfWeek.of(i)));
        }
    }

    @Test
    public void testDatastringConstructor()
    {
        String testDatastring = "";
        Timetable testTimetable = new Timetable(testDatastring);
        assertNull(testTimetable);
    }

    @Test
    public void testToString()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        assertTrue(testTimetable.toString().equals("EVERY_N_DAYS;t;1;t;" + start.getTime() + ";t;" + start.getTime() + ";t;false;t;true,true,true,true,true,true,true"));
    }

    @Test
    public void testGetInterval()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        assertTrue(testTimetable.getInterval() == Interval.EVERY_N_DAYS);
    }

    @Test
    public void testSetInterval()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        testTimetable.setInterval(Interval.EVERY_N_YEARS);
        assertTrue(testTimetable.getInterval() == Interval.EVERY_N_YEARS);
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
        Date start = new Date();
        Date end = new Date();
        boolean[] days = new boolean[7];
        Arrays.fill(days,true);
        Timetable testTimetable = new Timetable(Interval.EVERY_N_DAYS, 1, start, end, false, days);
        assertSame(start, testTimetable.getStartDate());
    }

    @Test
    public void testSetStartDate()
    {
        Date start = new Date();
        Date end = new Date();
        boolean[] days = new boolean[7];
        Arrays.fill(days,true);
        Timetable testTimetable = new Timetable(Interval.EVERY_N_DAYS, 1, start, end, false, days);
        Date newStart = new Date();
        testTimetable.setStartDate(newStart);
        assertSame(newStart, testTimetable.getStartDate());
    }

    @Test
    public void testGetEndDate()
    {
        Date start = new Date();
        Date end = new Date();
        boolean[] days = new boolean[7];
        Arrays.fill(days,true);
        Timetable testTimetable = new Timetable(Interval.EVERY_N_DAYS, 1, start, end, false, days);
        assertSame(end, testTimetable.getEndDate());
    }

    @Test
    public void testSetEndDate()
    {
        Date start = new Date();
        Date end = new Date();
        boolean[] days = new boolean[7];
        Arrays.fill(days,true);
        Timetable testTimetable = new Timetable(Interval.EVERY_N_DAYS, 1, start, end, false, days);
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

    @Test
    public void testIsDayOpen()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        assertTrue(testTimetable.isDayOpen(DayOfWeek.of(1)));
    }

    @Test
    public void testSetDay()
    {
        Date start = new Date();
        Timetable testTimetable = new Timetable(start);
        testTimetable.setDay(DayOfWeek.of(1), false);
        assertFalse(testTimetable.isDayOpen(DayOfWeek.of(1)));
    }
}