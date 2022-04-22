package week4.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableAssignment 
{

	public static void main(String[] args) 
	{

		// setup latest ChromeDriver
		WebDriverManager.chromedriver().setup();

		// setup driver object for Chrome Driver class
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/table.html");
		
		//maxmimize window
		driver.manage().window().maximize();

		// list all row elements using common xpath
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));

		// print size of list to get count of rows
		System.out.println("the no of rows in table are: " + rows.size());

		// list all column elements using common xpath
		List<WebElement> cols = driver.findElements(By.xpath("//table//tr[2]/td"));

		// print size of list to get the count of number of columns
		System.out.println("the no of columns in table are: " + cols.size());

		int m = 1;
		
		// using parameterized Xpath and for loop to navigate from row 3 to 5
		for (int i = 3; i < 6; i++) 
		{
			//getting text into a string of progress value
			String progVal = driver.findElement(By.xpath("//table//tr[" + i + "]/td[2]")).getText();

			// Get the progress value of all 'Learn to interact with Elements'
			System.out.println("The progress value of " + m + " th 'Learn to interact with Elements' is " + progVal);
			
			//counter to increase m in output
			m++;
		}
		// define a list
		List<Integer> progValsL = new ArrayList<Integer>();

		// for loop to add all progress without % symbol to a list
		for (int k = 2; k < 7; k++) 
		{

			int prog = Integer.parseInt(
					driver.findElement(By.xpath("//table//tr[" + k + "]/td[2]")).getText().replaceAll("[^0-9]", ""));
			progValsL.add(prog);

		}

		// sort the list
		Collections.sort(progValsL);

		// check the vital task check box of least completed Progress with index of least progress from list
		driver.findElement(
				By.xpath("//table//tr[6]/td/font[contains(text(),'" + progValsL.get(0) + "')]/following::input"))
				.click();

	}

}
