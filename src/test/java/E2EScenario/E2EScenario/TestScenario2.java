package E2EScenario.E2EScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScenario2 {

	
		WebDriver driver = new ChromeDriver();
		@BeforeMethod
		public void setup() {
					
			driver.get("https://www.lambdatest.com/selenium-playground/");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		
		}
		
		@Test(timeOut=6000)
		public void Scenario2() {

			driver.findElement(By.linkText("Checkbox Demo")).click();
			WebElement element = driver.findElement(By.id("isAgeSelected"));
	// here we click the checkbox and verify that it is selected or not. 		
			element.click();
			if(element.isSelected())
			{
				System.out.println("Checkbox is selected");
			}
			else {
				System.out.println("Checkbox is not selected");
			}
	//here we unclick the checkbox and verify that it is selected or not.
			element.click();
			if(element.isSelected())
			{
				System.out.println("Checkbox is selected");
			}
			else {
				System.out.println("Checkbox is  not selected");
			}
			
		}
		

		@AfterMethod
		public void teardown() {
			if(driver!=null)
			{
			driver.quit();
			}
		}


	}

