package week4.day2.assignments;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableAssignment {

	public static void main(String[] args) {

		// selects the latest chrome driver from web Driver binaries or downloads if it not available
		WebDriverManager.chromedriver().setup();

		// setup object for ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		// launch url
		driver.get("http://www.leafground.com/pages/selectable.html");

		// implicit wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// maximize browser
		driver.manage().window().maximize();

		// setup and builder object for Actions class
		Actions builder = new Actions(driver);

		// for loop to navigate to each item
		for (int i = 1; i < 8; i++) 
		{
			// mouse left click and hold and scroll through all items
			builder.clickAndHold(driver.findElement(By.xpath("//li[text()='Item " + i + "']"))).perform();

		}
		// release the mouse left click
		builder.release().perform();

	}

}
