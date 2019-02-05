package com.PagesRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.phPTravels.v1_10.Base_Utils;

public class HotelsPage extends Base_Utils {

	@FindBy(xpath = "/html/body/nav/div/div[2]/ul[2]/ul/ul/li/a")
	WebElement languageButton;

	@FindBys({ @FindBy(xpath = "/html/body/nav/div/div[2]/ul[2]/ul/ul/li/ul/li") })
	List<WebElement> languages;

	@FindBy(xpath = "//div[@class='clearfix']/following-sibling::div[@id='s2id_autogen8']/a/span[contains(text(), 'Search by Hotel or City Name')]")
	WebElement hotelCityName;

	@FindBy(xpath = "//div[@id='select2-drop']/div/input")
	WebElement hotelCityNameInput;

	@FindBys({ @FindBy(xpath = "//div[@id='select2-drop']/ul/li/ul/li") })
	List<WebElement> allElements;

	@FindBy(xpath = "/html/body/div[9]/div[1]/table/thead/tr[1]/th[2]")
	WebElement CheckIndateYear;

	@FindBy(xpath = "//div[@id='dpd1']/div/input")
	WebElement checkInButton;

	@FindBys({ @FindBy(xpath = "/html/body/div[9]/div[1]/table/tbody/tr/td") })
	List<WebElement> checkIndates;

	@FindBys({ @FindBy(xpath = "/html/body/div[9]/div[2]/table/tbody/tr/td/span") })
	List<WebElement> checkInmonths;

	@FindBy(xpath = "/html/body/div[10]/div[1]/table/thead/tr[1]/th[2]")
	WebElement checkOutDateYear;

	@FindBy(xpath = "/html/body/div[10]")
	WebElement calender;

	@FindBy(xpath = "//*[@id='dpd2']/div/input")
	WebElement swapMonths;

	@FindBys({ @FindBy(xpath = "/html/body/div[10]/div[1]/table/tbody/tr/td") })
	List<WebElement> checkOutdates;

	@FindBys({ @FindBy(xpath = "/html/body/div[10]/div[2]/table/tbody/tr/td/span") })
	List<WebElement> checkOutmonths;

	@FindBy(id = "travellersInput")
	WebElement travellersbox;

	@FindBy(xpath = "//div[@id='options']/div[1]/div[1]/div/div[1]/div/strong")
	WebElement adultChnl;

	@FindBy(xpath = "//div[@id='options']/div[1]/div[1]/div/div[2]/div/div/span[1]")
	WebElement decreaseAdultsCount;

	@FindBy(id = "adultInput")
	WebElement adults;

	@FindBy(xpath = "//div[@id='options']/div[1]/div[1]/div/div[2]/div/div/span[2]")
	WebElement increaseAdultCount;

	@FindBy(xpath = "//div[@id='options']/div[1]/div[2]/div/div[1]/div/strong")
	WebElement childChnl;

	@FindBy(xpath = "//div[@id='options']/div[1]/div[2]/div/div[2]/div/div/span[1]")
	WebElement decreaseChildCount;

	@FindBy(id = "childInput")
	WebElement childs;

	@FindBy(xpath = "//div[@id='options']/div[1]/div[2]/div/div[2]/div/div/span[2]")
	WebElement increaseChildCount;
	
	@FindBy(xpath="//div[@id='hotels']/form/div[5]/button")
	WebElement searchBtn;

	public void desiredLanguageSelection(String language) throws InterruptedException {
		Actions action = new Actions(d);
		action.moveToElement(languageButton);
		for (WebElement engLanguage : languages) {
			if (engLanguage.getText().contains(language)) {
				engLanguage.click();
				break;
			}
		}
	}

	public void hotelCitySelection(String initialNmae, String HotelorCityName) throws InterruptedException {
		hotelCityName.click();
		hotelCityNameInput.sendKeys(initialNmae);
		for (WebElement element : allElements) {
			if (element.getText().contains(HotelorCityName)) {
				element.click();
				break;
			}
		}
	}

	public void fillOUtCheckInDate(String checkINMonthYear, String checkINMonth, String checkINDate)
			throws InterruptedException {
		for (int i = 0; i <= 3; i++) {
			checkInButton.click();
			if (CheckIndateYear.getText().contains(checkINMonthYear)) {
				for (WebElement webElement : checkIndates) {
					if (webElement.getText().contains(checkINDate)) {
						webElement.click();
						break;
					}
				}
				break;
			} else {
				CheckIndateYear.click();
				for (WebElement webElement : checkInmonths) {
					if (webElement.getText().contains(checkINMonth)) {
						Thread.sleep(500);
						webElement.click();
						break;
					}
					continue;
				}
			}
		}
	}

	public void fillOutCheckOutDate(String checkOutMonthYear, String checkOutmonth, String checkOutDate) {
		for (int i = 0; i <= 3; i++) {
			if (!calender.isDisplayed()) {
				swapMonths.click();
				continue;
			}
			if (checkOutDateYear.getText().contains(checkOutMonthYear)) {
				for (WebElement webElement : checkOutdates) {
					if (webElement.getText().contains(checkOutDate)) {
						webElement.click();
						break;
					}
				}
				break;
			} else {
				checkOutDateYear.click();
				for (WebElement webElement : checkOutmonths) {
					if (webElement.getText().contains(checkOutmonth)) {
						webElement.click();
						break;
					}
					continue;
				}
			}
		}
	}
	
	public void fillOutTravelersInputs(int adultsInTravel, int childsInTravel) {
		travellersbox.click();
		
		String adultCount = adults.getAttribute("value");
		Integer intAdultCount = Integer.parseInt(adultCount);
		
		String childCount = childs.getAttribute("value");
		Integer intChildCount = Integer.parseInt(childCount);
		try {
			if (!(adultsInTravel == intAdultCount)) {
				int result = 0;
				if (adultsInTravel <= intAdultCount) {
					result = (intAdultCount - adultsInTravel);
					for (int i = 1; i <= result; i++) {
						decreaseAdultsCount.click();
					}
				}
				if (adultsInTravel >= intAdultCount) {
					result = (adultsInTravel - intAdultCount);
					for (int i = 1; i <= result; i++) {
						increaseAdultCount.click();
					}
				}
			} else {
				System.out.println("Check elements");
			}
		} catch (Exception e) {
			System.out.println("Adult Catch block");
		}
		try {
			if (!(childsInTravel == intChildCount)) {
				int result = 0;
				if (childsInTravel <= intChildCount) {
					result = (intChildCount - childsInTravel);
					for (int i = 1; i <= result; i++) {
						decreaseChildCount.click();
					}
				}
				if (childsInTravel >= intChildCount) {
					result = (childsInTravel - intChildCount);
					for (int i = 1; i <= result; i++) {
						increaseChildCount.click();
					}
				}
			} else {
				System.out.println("Check elements");
			}
		} catch (Exception e) {
			System.out.println("Child Catch block");
		}
	}
	
	public void searchHotels() {
		searchBtn.click();
	}
}
