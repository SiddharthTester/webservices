package com.RestAssured.GenericUtils;

import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class Assertion {

    private static Logger log = LogManager.getLogger(Assertion.class.getName());

    public static void assertTrue(boolean flag){
        Assert.assertTrue(flag);
    }

    public static void assertFalse(boolean flag){
        Assert.assertFalse(flag);
    }

    public static void verifyStatusCode(Response response, int statusCode){
        Assert.assertEquals(TestUtils.getStatusCode(response), statusCode);
    }

    public static void verifyStatusMessage(Response response, String statusMessage){
        Assert.assertEquals(TestUtils.getStatusMessage(response), statusMessage);
    }

}
