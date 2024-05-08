package loggerExample;

import org.apache.logging.log4j.LogManager;

public class Example {
	 private static final org.apache.logging.log4j.Logger logger =LogManager.getLogger(Example.class);
	public static void main(String[] args) {
		System.out.println("Hello User");
		logger.info("Logging information message");
        logger.error("Logging error message");
	}	
}
