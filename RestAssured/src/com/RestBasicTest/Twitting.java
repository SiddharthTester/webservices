package com.RestBasicTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Twitting {

    @Test
    public void twitting(){
        RestAssured.baseURI = "https://api.twitter.com/";

        String Consumerkey = "MFXMRyvRK2co2stm19SnKSEDV";
        String ConsumerSecretKey = "GL0yTZwrjlxSpp607SCwa629R8dzIOWzxFmeshHGz71n6XJGLg";
        String AccessToken = "557492200-efiHUCdUyGN3t6lR1kjpclWHRU6sTBkGQTyW8ngD";
        String AccessTokenSecret = "AO6x7cNRGgLeg6L9sKquGVd6LQraCd9K6Eo3WkNRJH9uU";

        Response res=given().
                contentType(ContentType.JSON).
                auth().oauth(Consumerkey,ConsumerSecretKey,AccessToken,AccessTokenSecret).
                params("status","Test tweet").
                          when().
                post("/1.1/statuses/update.json").
                          then().assertThat().statusLine("message").log().all().

                extract().response();

        System.out.println("String response :- "+res.asString());
        JsonPath jsonresponse = new JsonPath(res.asString());
        System.out.println("Json response :- "+jsonresponse);



    }
}
