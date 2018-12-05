package cs1530.planner.calendar;

import cs1530.planner.calendar.time.Timetable;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AlarmTest {
    @Test
    public void test_full_constructor()
    {
        Date testDate = new Date();
        Timetable test_timetable = new Timetable(testDate);
        Alarm testAlarm = new Alarm(test_timetable, 1);
        assertSame(testAlarm.getTimetable(), test_timetable);
        assertTrue(testAlarm.getMinutesWarning() == 1);
    }

    @Test
    public void test_short_constructor()
    {
        Date testDate = new Date();
        Timetable test_timetable = new Timetable(testDate);
        Alarm testAlarm = new Alarm(test_timetable);
        assertSame(testAlarm.getTimetable(), test_timetable);
        assertTrue(testAlarm.getMinutesWarning() == 0);
    }

    @Test
    public void test_get_timetable()
    {
        Date testDate = new Date();
        Timetable test_timetable = new Timetable(testDate);
        Alarm testAlarm = new Alarm(test_timetable);
        assertSame(testAlarm.getTimetable(), test_timetable);
    }

    @Test
    public void test_set_timetable()
    {
        Date testDate = new Date();
        Timetable test_timetable = new Timetable(testDate);
        Alarm testAlarm = new Alarm(test_timetable);
        Timetable new_timetable = new Timetable(testDate);
        testAlarm.setTimetable(new_timetable);
        assertSame(testAlarm.getTimetable(), new_timetable);
    }

    @Test
    public void test_get_minute_warning()
    {
        Date testDate = new Date();
        Timetable test_timetable = new Timetable(testDate);
        Alarm testAlarm = new Alarm(test_timetable);
        assertTrue(testAlarm.getMinutesWarning() == 0);
    }

    @Test
    public void test_set_minute_warning()
    {
        Date testDate = new Date();
        Timetable test_timetable = new Timetable(testDate);
        Alarm testAlarm = new Alarm(test_timetable);
        testAlarm.setMinutesWarning(5);
        assertTrue(testAlarm.getMinutesWarning() == 5);
    }

    @Test
    public void test_compare_to_greater()
    {
        Date lessDate = new Date(0);
        Date greatDate = new Date(1000000000);
        Timetable lessTimetable = new Timetable(lessDate);
        Alarm lessAlarm = new Alarm(lessTimetable);
        Timetable greatTimetable = new Timetable(greatDate);
        Alarm greatAlarm = new Alarm(greatTimetable);
        int testVal = greatAlarm.compareTo(lessAlarm);
        assertTrue(greatAlarm.compareTo(lessAlarm) > 0);
    }

    @Test
    public void test_compare_to_less()
    {
        Date lessDate = new Date(0);
        Date greatDate = new Date(1000000000);
        Timetable lessTimetable = new Timetable(lessDate);
        Alarm lessAlarm = new Alarm(lessTimetable);
        Timetable greatTimetable = new Timetable(greatDate);
        Alarm greatAlarm = new Alarm(greatTimetable);
        int testVal = greatAlarm.compareTo(lessAlarm);
        assertTrue(lessAlarm.compareTo(greatAlarm) < 0);
    }
}