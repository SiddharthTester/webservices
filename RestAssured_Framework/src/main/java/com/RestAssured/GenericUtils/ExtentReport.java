package com.RestAssured.GenericUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExtentReport {

    public static ExtentReports extent;
    public static ExtentTest test;

    static {
        System.out.println("I am in static Bloack");
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        extent = new ExtentReports(System.getProperty("user.dir") + "/src/main/java/com/RestAssured/com/RestAssured/Reports" + formater.format(calendar.getTime()) + ".html", false);
    }

    @BeforeMethod()
    public void beforeMethod(Method result) {
        test = extent.startTest(result.getName());
        System.out.println("I am in Before Method");
        test.log(LogStatus.INFO, result.getName() + " test Started");
    }

    @AfterClass(alwaysRun = true)
    public void endTest() {
        //driver.quit();
        extent.endTest(test);
        System.out.println("I am in AfterClass");
        extent.flush();
    }
}
