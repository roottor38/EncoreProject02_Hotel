package hotel.view;

import hotel.log4j.Log4j;

public class FailView {

	public static void failMessageView(String message) {
		Log4j log = new Log4j();
		log.error(message);
	}

}
