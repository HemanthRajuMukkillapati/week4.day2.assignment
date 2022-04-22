package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropAssignment {

	public static void main(String[] args) 
	{

		// setting up chromedriver with latest version using webdriver manager
		WebDriverManager.chromedriver().setup();

		// driver object for chromdriver class
		ChromeDriver driver = new ChromeDriver();

		// launch url
		driver.get("http://www.leafground.com/pages/drop.html");

		// implicit wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// maximize browser
		driver.manage().window().maximize();

		// create Object for action class-builder
		Actions builder = new Actions(driver);

		// using builder object to drag and drop
		builder.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).perform();

	}

}