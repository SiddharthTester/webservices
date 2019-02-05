package com.RestBasicTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class GetRequestSample {
    //************************************Start****************************************
    //Base URI
    public static String baseURI ="https://maps.googleapis.com/";

    public static void main(String args[]){
        RestAssured.baseURI = baseURI;

        //GivenBlock
        given().
                param("location", "-33.8670522,151.1957362").
                param("radius", "500").
                param("type", "restaurant").
                param("keyword", "cruise").
                param("key", "AIzaSyA8oiNdyNISOEka0F5enWRs5JOeBi0ajVs").

        //WhenBlock
        when().
                get("/maps/api/place/nearbysearch/json").

        //ThenBlock
        then().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("results[0].name", equalTo("Sydney Showboats") );
                System.out.println("Done");

    //************************************End****************************************
    }
//    //GivenBlock
//    final ResponseBodyExtractionOptions body = given().
//            param("location", "-33.8670522,151.1957362").
//            param("radius", "500").
//            param("type", "restaurant").
//            param("keyword", "cruise").
//            param("key", "AIzaSyA8oiNdyNISOEka0F5enWRs5JOeBi0ajVs").
//
//            //WhenBlock
//                    when().
//                    get("/maps/api/place/nearbysearch/json").
//
//            //ThenBlock
//                    then().assertThat().statusCode(200).
//            //Extractblock
//                    extract().body();
}
