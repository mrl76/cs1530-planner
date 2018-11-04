package cs1530.planner.util;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class Utils {
	private static final Image BELL = Toolkit.getDefaultToolkit().createImage("bell.png");
	
	public static void notification(String title, String message, TrayIcon.MessageType type) {
		try {
			//TODO image does not display
			SystemTray tray = SystemTray.getSystemTray();
			TrayIcon icon = new TrayIcon(BELL, "Alarm");
			icon.setImageAutoSize(true);
			tray.add(icon);
			icon.displayMessage(title, message, type);
		} catch(AWTException ex) {
			ex.printStackTrace();
		}
	}
	
	public static Date now() {
		return Calendar.getInstance().getTime();
	}
}
