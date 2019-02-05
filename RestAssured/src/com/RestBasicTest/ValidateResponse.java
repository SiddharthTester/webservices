package com.RestBasicTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidateResponse {

    String baseURI ="https://maps.googleapis.com/";

    @Test
    public void verifyResponse(){
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
                assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("results[0].name", equalTo("Sydney Showboats") ).and().
                body("results[2].vicinity", equalTo("32 The Promenade, King Street Wharf 5, Sydney") ).and().
                body("results[1].place_id", equalTo("ChIJrTLr-GyuEmsRBfy61i59si0")).and().
//              body("results[1].rating", equalTo("4.6")).and().
                header("Server","scaffolding on HTTPServer2").and().header("X-Frame-Options","SAMEORIGIN");

                System.out.println("Done");

        //************************************End****************************************
    }
}
