package com.RestBasicTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonParserSample {

//    String baseURI ="https://maps.googleapis.com/";

    @Test
    public void sampleJsonParser(){
        RestAssured.baseURI = "https://maps.googleapis.com/";

        Response res = given().
                param("location", "-33.8670522,151.1957362").
                param("radius", "500").
                param("type", "restaurant").
                param("keyword", "cruise").
                param("key", "AIzaSyA8oiNdyNISOEka0F5enWRs5JOeBi0ajVs").
//                log().all().

        when().
                get("/maps/api/place/nearbysearch/json").

        then().
                assertThat().statusCode(200).
                log().all().

        extract().response();

        String respnse = res.asString();
//        System.out.println(respnse);
        JsonPath jsonresponse = new JsonPath(respnse);
        int arraySize = jsonresponse.getInt("results.size()");
//        System.out.println(arraySize);
        for (int i = 0; i < arraySize; i++)
        {
            String name = jsonresponse.getString("results["+i+"].name");
            System.out.println(name);
        }
//        String path = jsonresponse.get(respnse);
//        System.out.println(path);
    }
}
