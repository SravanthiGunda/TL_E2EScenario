package E2EScenario.E2EScenario;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScenario3 {
	
	WebDriver driver = new ChromeDriver();
	@Parameters({"URL"})	
	@BeforeMethod
	public void setup(String URL) {
				
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(timeOut=6000)
	public void Scenario3() {

		driver.findElement(By.linkText("Javascript Alerts")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Click Me')]")).click();
		Alert alert = driver.switchTo().alert();
		String Actual_alertmessage = alert.getText();
		System.out.println(Actual_alertmessage);
		String Expected_alertMessage="I am an alert box!";
		try {
		Assert.assertEquals(Actual_alertmessage, Expected_alertMessage);
		}catch(AssertionError e)
		{
			System.out.println("Assertion failed: "+e.getMessage());
		}
		alert.accept();
		
	
}
	
	@AfterMethod
	public void teardown() {
		if(driver!=null)
		{
		driver.quit();
		}
	}

}
