package hotel.log4j;

import org.apache.log4j.Logger;

public class Log4j {

	private Logger logger = Logger.getLogger(getClass());;

	public void info(String message) {
		logger.info("----info----" + message);
	}

	public void error(String message) {
		logger.error("----error----" + message);
	}

}