package cs1530.planner.ui.newevent;

import cs1530.planner.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class NewEventController {
	@FXML private TextField name;
	@FXML private DatePicker date;
	@FXML private ComboBox hour, minute, meridian;
	@FXML private TextArea description;
	@FXML private Button confirm;
	
	private Main main;
	
	@FXML private void initialize() {
		this.main = Main.getInstance();
	}
	
	public void onConfirm() {
	
	}
}
