package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class slf4jApp {
    private static final Logger logger= LoggerFactory.getLogger(slf4jApp.class);

    public static void main(String[] args) {
        logger.trace("TRACE message - detailed debugging");
        logger.debug("DEBUG message - developer info");
        logger.info("INFO message - application flow");
        logger.warn("WARN message - something unexpected");
        logger.error("ERROR message - failure occured");
        try{
            int quotient= 33/0;

        }
        catch (Exception e)
        {
            logger.error("Exception occured : {}", e.getMessage(),e);

        }
        logger.info("Slf4jLogging example execution done");
    }
}

