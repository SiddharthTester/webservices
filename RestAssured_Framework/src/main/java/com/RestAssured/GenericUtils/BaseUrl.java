package com.RestAssured.GenericUtils;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BaseUrl {

    private static Logger log = LogManager.getLogger(BaseUrl.class.getName());

    public static final String url = "https://api.twitter.com";

    public static String getEndPoint(){
        log.info("Base URI : " + url);
        return url;
    }

    public static String getEndPoint(String resource){
        log.info("URI EndPoint : " + url + resource);
        return url + resource;
    }

}
