package cs1530.test.Unit_Tests;

import cs1530.planner.calendar.*;
import cs1530.planner.calendar.event.AppointmentTest;
import cs1530.planner.calendar.event.AssignmentTest;
import cs1530.planner.calendar.event.ExamTest;
import cs1530.planner.calendar.time.TimetableTest;
import cs1530.planner.database.DatabaseTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        AppointmentTest.class,
        AssignmentTest.class,
        ExamTest.class,
        TimetableTest.class,
        CalendarTest.class,
        CourseTest.class,
        UserProfileTest.class,
        DatabaseTest.class,
        AlarmTest.class
})
public class TestSuite {

}
