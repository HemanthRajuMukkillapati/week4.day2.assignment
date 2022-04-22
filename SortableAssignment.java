package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableAssignment 
{

	public static void main(String[] args) 
	{
		// selects the latest chrome driver from web Driver binaries or downloads if it
		// not available
		WebDriverManager.chromedriver().setup();

		// setup object for ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		// launch url
		driver.get("http://www.leafground.com/pages/sortable.html");

		// implicit wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// maximize browser
		driver.manage().window().maximize();
		
		// builder object for Actions class 
		Actions builder = new Actions(driver);
		
		// drag and drop driver item 6 to item1
		builder.dragAndDrop(driver.findElement(By.xpath("//li[text()='Item 6']")),
				driver.findElement(By.xpath("//li[text()='Item 1']"))).perform();
		
		

	}

}
