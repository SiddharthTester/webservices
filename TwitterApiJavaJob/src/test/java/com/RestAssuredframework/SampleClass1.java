package com.RestAssuredframework;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SampleClass1 {

    private static Logger log = LogManager.getLogger(SampleClass1.class.getName());

    @Test
    public void firsttest() {
        log.info("I am First Test");
    }

    @Test
    public void secondtest() {
        log.debug("I am second Test");
    }

    @Test
    public void loggertest() {
        log.error("Error Type loggerTest");
        log.fatal("Fatal Type");

        int i = 10;
        try {
            int j = i / 0;
        } catch (Exception e) {
            log.error(e);
            log.info(e);
            log.debug(e);
            log.fatal(e);
        }

    }
}
