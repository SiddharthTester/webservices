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

public class DeleteComment {

    @Test
    public void deleteCommentJira() throws IOException {
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

//Delete Comment
        Response deleteResp =
                given().
                        contentType(ContentType.JSON).
                        header("Authorization","Bearer <foooo>").
                        header("cookie", "JSESSIONID=" + sessionID).

                when().
                        delete("/rest/api/2/issue/10500/comment/10103").

                then().
                        assertThat().statusCode(204).log().all().

                extract().
                        response();

        System.out.println("Done");





    }

    public static String generateString(String filename) throws IOException {
        String filepath = System.getProperty("user.dir") + "\\Payloads\\" +filename;
        System.out.println(filepath);
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }
}