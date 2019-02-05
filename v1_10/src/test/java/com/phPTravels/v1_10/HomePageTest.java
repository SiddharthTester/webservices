package com.phPTravels.v1_10;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class HomePageTest extends Base_Utils{

	@BeforeMethod
	@Parameters("grpbrowser")
	public void openApp(String grpbrowser) throws InterruptedException
	{
		if (grpbrowser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.marionette", "D:\\workspace\\v1_10\\resources\\geckodriver.exe");
			d = new FirefoxDriver();
		}
		if (grpbrowser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\workspace\\v1_10\\resources\\chromedriver.exe");
			d = new ChromeDriver();
		}
		d.get("https://www.flipkart.com");
		Thread.sleep(3000);
		d.findElement(By.xpath("//div[@class='mCRfo9']/div/div/button")).click();
	}
	
	@Test
	public void searchProduct() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys("Titan Watches");
		System.out.println("Inside searchProduct :: Searched Titanwatchecs");
		d.findElement(By.xpath("//button[@class='vh79eN']")).click();
		System.out.println("Inside searchProduct :: Clicked on Search ");
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[@class='sUG0yY']/a[text()='Wrist Watches']")).click();
		System.out.println("Inside searchProduct :: Clicked on Wrist Watches ");
//		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Titan']/preceding-sibling::input"));
		d.findElement(By.xpath("//div[text()='Titan']")).click();
		System.out.println("Inside searchProduct :: Clicked on Titan ");
		Thread.sleep(5000);
	}
	
//	@Test
	public void printDescriptions() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys("Titan Watches");
		d.findElement(By.xpath("//button[@class='vh79eN']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[@class='sUG0yY']/a[text()='Wrist Watches']")).click();
		d.findElement(By.xpath("//div[text()='Titan']")).click();
		Thread.sleep(3000);
		//d.findElement(By.xpath("//div[@data-id='WATF33EEKPZC5BZY']/div/a")).click();
		d.findElement(By.xpath("//div[@id=\"container\"]/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]")).click();
		Thread.sleep(3000);
		
		String oldTab = d.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(d.getWindowHandles());
	    newTab.remove(oldTab);
	    // change focus to new tab
	    d.switchTo().window(newTab.get(0));
	    Thread.sleep(3000);
		
		String desc=d.findElement(By.xpath("/html/head/meta[@name='Description']")).getText();
		System.out.println(desc);
	}
	
//	@Test
	public void print10thProduct() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys("Titan Watches");
		d.findElement(By.xpath("//button[@class='vh79eN']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[@class='sUG0yY']/a[text()='Wrist Watches']")).click();
		d.findElement(By.xpath("//div[text()='Titan']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//div[@id=\"container\"]/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]")).click();
	}
	
//	@Test
	public void printAllProduct() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys("Titan Watches");
		d.findElement(By.xpath("//button[@class='vh79eN']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[@class='sUG0yY']/a[text()='Wrist Watches']")).click();
		d.findElement(By.xpath("//div[text()='Titan']")).click();
		Thread.sleep(3000);
		List<WebElement> lst=d.findElements(By.xpath("//a[@class='_2cLu-l']"));
		JavascriptExecutor js = (JavascriptExecutor) d;
		for(WebElement w:lst)
		{
			js.executeScript("arguments[0].scrollIntoView();", w);
			System.out.println(w.getText());
		}
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
}
