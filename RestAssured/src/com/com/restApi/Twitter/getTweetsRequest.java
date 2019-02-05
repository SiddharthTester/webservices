package com.com.restApi.Twitter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class getTweetsRequest {

    @Test
    public void getTweets(){
        RestAssured.baseURI = "https://api.twitter.com/";

        String Consumerkey = "MFXMRyvRK2co2stm19SnKSEDV";
        String ConsumerSecretKey = "GL0yTZwrjlxSpp607SCwa629R8dzIOWzxFmeshHGz71n6XJGLg";
        String AccessToken = "557492200-efiHUCdUyGN3t6lR1kjpclWHRU6sTBkGQTyW8ngD";
        String AccessTokenSecret = "AO6x7cNRGgLeg6L9sKquGVd6LQraCd9K6Eo3WkNRJH9uU";

        Response getTweetsResp =
        given().
                contentType(ContentType.JSON).
                auth().oauth(Consumerkey,ConsumerSecretKey,AccessToken,AccessTokenSecret).

        when().
                get("/1.1/statuses/user_timeline.json").

        then().
                assertThat().statusCode(200).log().all().

        extract().response();

        System.out.println(getTweetsResp.asString());
//        JsonPath jsonResponse =new JsonPath(getTweetsResp.asString());
    }
    public static String generateString(String filename) throws IOException {
        String filepath = System.getProperty("user.dir") + "\\Payloads\\" + filename;
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }
}
