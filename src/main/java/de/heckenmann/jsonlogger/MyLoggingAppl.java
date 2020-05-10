package de.heckenmann.jsonlogger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class MyLoggingAppl {

  private static Logger logger;

  public static void main(final String... args) {
    logger = LogManager.getLogger(MyLoggingAppl.class);
    int counter = 0;
    while (true) {
      ThreadContext.put("counter", Integer.toString(counter++));
      logger.info("Hello");

      try {
        Thread.sleep(1000);
      } catch (final InterruptedException e) {
        logger.error(e);
      }
      ThreadContext.remove("counter");
    }
  }
}
