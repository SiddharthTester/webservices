package com.Test;

import com.RestAssured.GenericUtils.BaseUrl;
import com.RestAssured.GenericUtils.TestUtils;
import com.RestAssured.coreUtils.RestApiCalls;
import io.restassured.config.EncoderConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class StatusCheck {

    private static Logger log = LogManager.getLogger(StatusCheck.class.getName());

    Response response;

    @Test
    public void getStatusFromUserTimeline(){
        log.info("Starting Test Case : getStatusFromUserTimeline");
        String endPointURI = BaseUrl.getEndPoint("/1.1/statuses/user_timeline.json");
//        System.out.println(endPointURI);
        response = RestApiCalls.getRequest(endPointURI);
//        String strResponse = response.getBody().asString();
//        System.out.println(strResponse);
//        JsonPath jsonresponse = new JsonPath(strResponse);
//        String strResponse = TestUtils.getStringResponse(response);
        JsonPath jsp = TestUtils.jsonParser(TestUtils.getStringResponse(response));
    }

    @Test
    public void searchTweets(){
        log.info("Starting Test Case : searchTweets");
        String endpointURI = BaseUrl.getEndPoint("/1.1/search/tweets.json");
        response = RestApiCalls.getRequest(endpointURI, "q", "nasa");
        TestUtils.jsonParser(TestUtils.getStringResponse(response));

    }

//    @Test
//    public void tweeting(){
//        log.info("Starting Test Case : Tweeting");
//        String endpointURI = BaseUrl.getEndPoint("/1.1/statuses/update.json");
////        response = RestApiCalls.postRequest(endpointURI);
//        response = RestApiCalls.postRequest(endpointURI, "status", "Test");
//        TestUtils.jsonParser(TestUtils.getStringResponse(response));
//    }
}
