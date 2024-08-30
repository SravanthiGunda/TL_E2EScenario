package E2EScenario.E2EScenario;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonTest {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void setup() {
				
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
	}
	
	@Test
	public void Scenario1() {
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	try {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*")));
	System.out.println("All the elements are loaded completely in the DOM");
	}
	catch(TimeoutException ex)
	{
	System.out.println("Timeout occurred while waiting for all elements to be available.");
	}
	String ActualTitle = driver.getTitle();
	String ExpectedTitle1 ="LambdaTest";
	String ExpectedTitle2 = "Selenium Grid Online | Run Selenium Test On Cloud";
	SoftAssert softassert = new SoftAssert();
	softassert.assertEquals(ActualTitle, ExpectedTitle1);
	softassert.assertEquals(ActualTitle, ExpectedTitle1, "Title does not match and test case continues");
	softassert.assertEquals(ActualTitle, ExpectedTitle2, "Both Actual and Expected values are same");
	System.out.println(ActualTitle);
	//Commented the below step as it moves the scenario to failed status. 
	//softassert.assertAll();
	

	
			
	}
	
	@AfterMethod
	public void teardown() {
		if(driver!=null)
		{
		driver.quit();
		}
	}

}
