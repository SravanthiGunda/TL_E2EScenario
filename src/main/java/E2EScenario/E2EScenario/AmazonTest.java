package E2EScenario.E2EScenario;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class AmazonTest {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
		WebElement search = driver.findElement(By.xpath("//input[contains(@id,'search')])"));
		search.sendKeys("labor day sale 2024");
		search.sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//span[contains(text(),'Get It by Tomorrow')]")).click();
		WebElement AddToCart = driver.findElement(By.xpath("//button[contains(text(), 'Add to cart')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", AddToCart);
		//AddToCart.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement popover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'a-popover-inner')]")));
		popover.click();
		WebElement addtocartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add to cart')]")));
		addtocartButton.click();
		driver.findElement(By.className("nav-cart-icon nav-sprite")).click();
		driver.findElement(By.name("proceedToRetailCheckout")).click();
		
		
		
		
		
		
		

	}

}
