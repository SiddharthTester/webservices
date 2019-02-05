package com.RestBasicTest;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequest {


    @Test
    public void verifyPostResponse(){
        RestAssured.baseURI = "http://cron.instaffic.com/";

        //GivenBlock
        EncoderConfig encoderconfig = new EncoderConfig();
        Response res= given().
                config(RestAssured.config().
                        encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType(ContentType.URLENC).
                log().all().
                contentType("application/x-www-form-urlencoded").
                formParam("userId","442").
                formParam("startTime","1540944178").
                formParam("endTime","1542004870").
        //WhenBlock
        when().
                post("getActionDetails").
        //ThenBlock
        then().

        //ExtractBlock
        extract().response();
        //PrintingObjectValueOFResponse
        System.out.println("Object Value Of Response is ==> " + res);
        String respnse = res.asString();
        //ActualResponse
        System.out.println(respnse);

        JsonPath jsonResponse = new JsonPath(respnse);
        String Ststus = jsonResponse.get("status");
        String likesCount = jsonResponse.getJsonObject("likes_count");
        String followedcount = jsonResponse.getJsonObject("followed_count");
        System.out.println(Ststus);

        System.out.println("Likes -> "+ likesCount + "Follow -> " + followedcount);
          System.out.println("Done");
        //************************************End****************************************
    }
}
