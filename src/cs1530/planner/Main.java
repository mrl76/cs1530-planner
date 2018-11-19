package cs1530.planner;

import cs1530.planner.calendar.UserProfile;
import cs1530.planner.database.Database;
import cs1530.planner.ui.FXMLParent;
import cs1530.planner.ui.login.LoginController;
import cs1530.planner.util.Utils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
	private Database database;
    private LoginController login;
	
	@Override
	public void init() {
		database = new Database();
		database.load();
		
		login = new LoginController(this);
	}
	
	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(FXMLParent.LOGIN, 300, 100));
        primaryStage.show();
	
	    Utils.notification("Test", "This is a test message!", TrayIcon.MessageType.INFO);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void openProfile(UserProfile user) {
		//TODO
    }
	
	public Database getDatabase() {
		return database;
	}
}
