package com.RestAssuredframework;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SampleClass2 {

    private static Logger log = LogManager.getLogger(SampleClass2.class.getName());

    @Test
    public void thirdtest(){
        System.out.println("I am Third Test");
    }

    @Test
    public void Fourthtest(){
        System.out.println("I am Fourth Test");
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


