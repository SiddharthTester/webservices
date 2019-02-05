package com.RestAssured.GenericUtils;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestUtils {

    private static Logger log = LogManager.getLogger(TestUtils.class.getName());

    public static String getStringResponse(Response response){
        log.info("Inside Get String Response");
        String strResponse = response.getBody().asString();
        log.debug(strResponse);
        return strResponse;
    }

    public static JsonPath jsonParser(String response){
        log.info("Inside Jason Parser");
        JsonPath jsonResponse = new JsonPath(response);
        log.debug(jsonResponse);
        return jsonResponse;
    }

    public static XmlPath xmlParser(String response){
        log.info("Inside XML Parser");
        XmlPath xmlResponse = new XmlPath(response);
        log.debug(xmlResponse);
        return xmlResponse;
    }

    public static int getStatusCode(Response response) {
        log.info("Inside Get Status Code");
        int statusCode = response.getStatusCode();
        log.info(statusCode);
        return statusCode;
    }

    public static String getStatusMessage(Response response){
        log.info("Inside Get Status Message");
        String statusMessage = response.getStatusLine();
        log.info(statusMessage);
        return statusMessage;
    }
}
