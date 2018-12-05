package cs1530.planner;

import cs1530.planner.database.Database;
import cs1530.planner.ui.UIManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
	private static Main instance;
	private Database database;
	private UIManager uiManager;
    private Stage stage;
	
	@Override
	public void init() {
		instance = this;
		
		database = new Database();
		database.load();
		uiManager = new UIManager();
	}
	
	@Override
    public void start(Stage primaryStage) {
		stage = primaryStage;
		stage.setOnCloseRequest((event) -> {
			database.save();
			Platform.exit();
		});
		uiManager.showLogin();
		stage.show();
    }

    public static void main(String[] args) {
	    //fix anti-aliasing for small text
	    System.setProperty("prism.lcdtext", "false");
        launch(args);
    }
	
	public static Main getInstance() {
		return instance;
	}
	
	public static Database getDatabase() {
		return instance.database;
	}
	
	public static UIManager getUIManager() {
		return instance.uiManager;
	}
	
	public static URL getResource(String path) {
		return instance.getClass().getResource(path);
	}
	
	public static void setScene(Scene s, String title) {
		instance.stage.setScene(s);
		instance.stage.setTitle(title);
	}
}
