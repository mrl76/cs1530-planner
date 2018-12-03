package cs1530.planner.ui.login;
import cs1530.planner.Main;
import cs1530.planner.calendar.UserProfile;
import cs1530.planner.calendar.event.Appointment;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import static org.junit.Assert.*;
import javafx.fxml.FXML;


import java.io.IOException;
public class LoginPageTest extends GuiTest {

    @Override
    protected Parent getRootNode(){
        Parent parent = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            parent = loader.load(getClass().getResource("login.fxml"));
            System.out.println(parent);
            return parent;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testCreateClickHappyPath() {
    }

    @Test
    public void testCreateClickNoUsername() {

    }

    @Test
    public void testCreateClickNoPassword() {

    }

    @Test
    public void testCreateClickUserExists() {

    }

    @Test
    public void testConfirmClickHappyPath() {

    }

    @Test
    public void testConfirmClickNoUserFound() {

    }

    @Test
    public void testConfirmClickIncorrectPassword() {

    }

    @Test
    public void testConfirmClickNoUsername() {

    }

    @Test
    public void testConfirmClickNoPassword() {

    }
}
