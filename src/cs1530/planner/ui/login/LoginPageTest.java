package cs1530.planner.ui.login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import java.io.IOException;

public class LoginPageTest extends GuiTest {
    @Override
    protected Parent getRootNode() {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return parent;
    }

    @Test
    public void testInitalLoad() {

    }
}
