package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealsAssignment 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{

		// setup webdriver
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		// to disable browser notifications
		options.addArguments("--disable-notifications");

		// passing options as a parmeter to driver
		ChromeDriver driver = new ChromeDriver(options);

		// launch snapdeal
		driver.get("https://www.snapdeal.com/");

		// industry stndard implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// maximize window
		driver.manage().window().maximize();

		// builder object creation for Actions class
		Actions builder = new Actions(driver);

		// mouse over Men
		builder.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Men')]"))).perform();

		// select Sports shoe
		builder.click(driver.findElement(By.xpath("//a/span[text()='Sports Shoes']"))).perform();

		// Printing count of sports shoe
		System.out.println("the count of sports shoe is: "
				+ driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText());

		// thread.sleep is used to avoid script failure sometimes because of application
		// select Training shoes under sports shoe
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		// listing all webelements with prices to before sort
		Thread.sleep(5000);
		List<WebElement> beforeSort = driver.findElements(By.xpath("//span[contains(@id,'display-price')]"));

		// declaring an integer arraylist
		List<Integer> bfrPrice = new ArrayList<Integer>();

		// for loop to extract price and add to integer list, using regular expressions
		// to avoid "RS and ," in price
		for (WebElement evrele : beforeSort) 
		{
			bfrPrice.add(Integer.parseInt(evrele.getText().replaceAll("[^0-9]", "")));
		}

		// sorting the prices in ascending
		Collections.sort(bfrPrice);

		// printing the prices
		System.out.println("Below are the Prices from low to high");
		System.out.println(bfrPrice);

		// click on sort
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();

		// select low to high
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();

		// waiting for 10 seconds or else webdriver picking elements whichever is loaded
		// first instead of starting from first
		Thread.sleep(10000);

		// list to pick webelemnts of prices after sort
		List<WebElement> priceEle = driver.findElements(By.xpath("//span[contains(@class,'lfloat product-price')]"));

		// Declaring an Integer list
		List<Integer> priceList = new ArrayList<Integer>();

		// for loop to extract price and add to integer list, using regular expressions
		// to avoid "RS and ," in price
		for (WebElement eachele : priceEle) 
		{
			priceList.add(Integer.parseInt(eachele.getText().replaceAll("[^0-9]", "")));

		}

		// Printing Price list after sort
		System.out.println("Below are the Prices after sort");
		System.out.println(priceList);

		// comparing whether the sort functionality is working fine or not
		if (priceList.equals(beforeSort)) 
		{
			System.out.println("The Sort functionality is working fine");

		} 
		else 
		{
			System.out.println("The Sort functionality is not working fine");
		}

		// clear and enter 900 in from price field
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");

		// clear enter 1200 in to price field
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");

		// click on go
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();

		// since no availability to select color going with only min and max filter
		Thread.sleep(5000);

		// verifying min and max value applied successfully or not
		if (driver.findElement(By.name("fromVal")).getAttribute("value").equals("900")
				&& driver.findElement(By.name("toVal")).getAttribute("value").equals("1200")) 
		{

			// printing if succesfully applied
			System.out.println("The min and max filter applied successfully");
		} 
		else 
		{
			// Printing if filter is not applied
			System.out.println("The Min and Max filter is not applied");
		}

		// mouseover to first elment
		builder.moveToElement(driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"))).perform();

		// mouseover to first elemnet and click on quick view
		builder.moveToElement(driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"))).click()
				.perform();

		// printing the cost using Regex
		System.out.println("The Price of the shoe is: "
				+ driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText().replaceAll("[^0-9]", ""));

		// printing discount
		System.out.println("The discount on price of the shoe is: "
				+ driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText());

		// taking screenshot code
		File snapshotSource = driver.findElement(By.xpath("//div[contains(@class,'quickViewModal ')]/parent::div"))
				.getScreenshotAs(OutputType.FILE);

		// Destination

		File Desti = new File("./ScreenShots/snapdeal.png");

		// copy source to dest using File.utils

		FileUtils.copyFile(snapshotSource, Desti);

	}

}
