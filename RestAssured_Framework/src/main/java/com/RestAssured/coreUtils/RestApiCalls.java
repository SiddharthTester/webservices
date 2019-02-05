package com.RestAssured.coreUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
public class RestApiCalls {

    private static Logger log = LogManager.getLogger(RestApiCalls.class.getName());

    static String Consumerkey = "MFXMRyvRK2co2stm19SnKSEDV";
    static String ConsumerSecretKey = "GL0yTZwrjlxSpp607SCwa629R8dzIOWzxFmeshHGz71n6XJGLg";
    static String AccessToken = "557492200-efiHUCdUyGN3t6lR1kjpclWHRU6sTBkGQTyW8ngD";
    static String AccessTokenSecret = "AO6x7cNRGgLeg6L9sKquGVd6LQraCd9K6Eo3WkNRJH9uU";

    public static Response getRequest(String uri){
        log.info("Inside getRequest Calls");
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.auth().oauth(Consumerkey,ConsumerSecretKey,AccessToken,AccessTokenSecret);
        Response response = requestSpecification.get(uri);
        log.debug(requestSpecification.log().all());
        return response;
    }

    public static Response getRequest(String uri, String paramKey, String paramValue){
        log.info("Inside getRequest Calls");
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.param(paramKey,paramValue);
        requestSpecification.auth().oauth(Consumerkey,ConsumerSecretKey,AccessToken,AccessTokenSecret);
        Response response = requestSpecification.get(uri);
        log.debug(requestSpecification.log().all());
        return response;
    }

    public static Response postRequest(String uri, String strJSON){
        log.info("Inside postRequest Calls");
        RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.post(uri);
        log.debug(requestSpecification.log().all());
        return response;
    }

    public static Response postRequest(String uri, String strJSON, String paramKey, String paramValue){
        log.info("Inside postRequest Calls");
        RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.param(paramKey,paramValue);
        requestSpecification.auth().oauth(Consumerkey,ConsumerSecretKey,AccessToken,AccessTokenSecret);
        Response response = requestSpecification.post(uri);
        log.debug(requestSpecification.log().all());
        return response;
    }

    public static Response postRequest(String uri, String paramKey, String paramValue){
        log.info("Inside postRequest Calls");
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.params(paramKey,paramValue);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.auth().oauth(Consumerkey,ConsumerSecretKey,AccessToken,AccessTokenSecret);
        Response response = requestSpecification.post(uri);
        log.debug(requestSpecification.log().all());
        return response;
    }

    public static Response putRequest(String uri, String strJSON){
        log.info("Inside putRequest Calls");
        RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.put(uri);
        log.debug(requestSpecification.log().all());
        return response;
    }

    public static Response deleteRequest(String uri, String strJSON){
        log.info("Inside deleteRequest Calls");
        RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.delete(uri);
        log.debug(requestSpecification.log().all());
        return response;
    }
}
