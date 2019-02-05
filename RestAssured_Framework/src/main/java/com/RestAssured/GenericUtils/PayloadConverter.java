package com.RestAssured.GenericUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadConverter {

    private static Logger log = LogManager.getLogger(PayloadConverter.class.getName());

    public static String generatePayloadString(String filename) throws IOException {
        log.info("Inside PayloadConverter Function");
        String filepath = System.getProperty("user.dir") + "\\resources\\" + filename;
        try {
            return new String(Files.readAllBytes(Paths.get(filepath)));
        }catch (Exception e){
            log.error(e);
            return null;
        }
    }
}
