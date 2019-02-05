package com.phPTravels.v1_10;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.PagesRepo.HotelsPage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestCase1 extends Base_Utils {
	HotelsPage hotelsPage;

//	@BeforeSuite
	public void openBrowserTest() {
		selectBrowser("Chrome");
		d.get("https://www.phptravels.net/");

	}

	@BeforeMethod
	public void openApp() throws InterruptedException {
		selectBrowser("Chrome");
		d.get("https://www.phptravels.net/");
		Thread.sleep(2000);
		
		hotelsPage = PageFactory.initElements(d, HotelsPage.class);
	}
	
//	@Test
	public void testfhj() {
		String a="abcd123";
		String b="dgh234";
		Integer aInInt = Integer.parseInt(a.replaceAll("[^0-9]", ""));
		Integer bINInt = Integer.parseInt(b.replaceAll("[^0-9]", ""));
//		Integer bInInt = Integer.parseInt(b);
		System.out.println(aInInt);
		System.out.println(bINInt);
//		int c = aInInt + bINInt;
		System.out.println(aInInt + bINInt);
		
	}

	@Test
	public void bookHotels() throws InterruptedException {
		
		System.out.println("1nd test");
		hotelsPage.desiredLanguageSelection("English");
		hotelsPage.hotelCitySelection("Bra", "Brady, United State");
		String checkINMonthYear = "February 2019";
		String checkINMonth = "Feb";
		String checkINDate = "25";
		hotelsPage.fillOUtCheckInDate(checkINMonthYear, checkINMonth, checkINDate);
		String checkOutMonthYear = "March 2019";
		String checkOutmonth = "Mar";
		String checkOutDate = "20";
		hotelsPage.fillOutCheckOutDate(checkOutMonthYear, checkOutmonth, checkOutDate);
		int adultsInTravel = 0;
		int childsInTravel = 2;
		hotelsPage.fillOutTravelersInputs(adultsInTravel, childsInTravel);		
		hotelsPage.searchHotels();
		Thread.sleep(10000);
	}

	@AfterMethod
	public void oops() {
		d.quit();
	}

//	@AfterSuite
	public void tearDown() {

	}

	/*
	 * /html/body/div[9]/div[2]/table/thead/tr/th[1]
	 *
	 * /html/body/div[9]/div[1]/table/thead/tr[1]/th[1]
	 *
	 * //div[@class='clearfix']/following-sibling::div[1]/section/div[2]/div/div/div
	 * [2]/div/div/form/div/div //*[@id="select2-drop"]/ul/li/ul/li[1]
	 */
}
