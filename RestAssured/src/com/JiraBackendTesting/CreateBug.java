package com.JiraBackendTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateBug {

    @Test
    public void createIssue() throws IOException {
        RestAssured.baseURI = "http://localhost:8080/";

//Login to Jira
        String loginrequestBody = generateString("JiraLogin.json");

        Response res =
                given().
                        contentType(ContentType.JSON).
                        body(loginrequestBody).
                when().
                        post("/rest/auth/1/session").

                then().
                        assertThat().statusCode(200).

                extract().response();

        String response1 = res.asString();
        System.out.println("Login Response :- "+response1);

        JsonPath jsonRespnse = new JsonPath(response1);
        String sessionID = jsonRespnse.getString("session.value");
        System.out.println("Session Id : "+sessionID);

//Create Issue
        String createIssueRequest = generateString("CreateIssue.json");

        Response createIssueResp = given().
                contentType(ContentType.JSON).
                header("cookie", "JSESSIONID=" + sessionID).
                body(createIssueRequest).

        when().
                post("/rest/api/2/issue/").

        then().
                assertThat().statusCode(201).log().all().

        extract().
                response();

        String response2 = createIssueResp.asString();
        System.out.println("Create Issue Response : "+response2);

        JsonPath jsonRespnseCi = new JsonPath(response2);
        String issueId = jsonRespnseCi.getString("key");
        System.out.println("Issue id is : "+issueId);

//Add Comment
        String addCommentRequest = generateString("Comment.json");
        Response addcmntResp = given().
                contentType(ContentType.JSON).
//                pathParam("issueIdOrKey",issueId).
                header("Authorization","Bearer <foooo>").
                header("Accept","application/json").
                header("cookie", "JSESSIONID=" + sessionID).
                body(addCommentRequest).

        when().
                post("/rest/api/2/issue/"+issueId+"/comment/").

        then().
                assertThat().statusCode(201).

        extract().
                response();

        String response3 = addcmntResp.asString();
        System.out.println("Jai Sri Ram : "+response3);



        //Converter
        }
    public static String generateString(String filename) throws IOException {
        String Filepath = System.getProperty("user.dir") + "\\Payloads\\" +filename;
        System.out.println(Filepath);
        return new String(Files.readAllBytes(Paths.get(Filepath)));
    }

}
