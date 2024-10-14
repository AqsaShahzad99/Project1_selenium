package langselect;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class langdrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://develop.yourteacher.ai/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("aqsa02@mailinator.com");
		driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Test12345");
		driver.findElement(By.cssSelector("button[color=\"blue\"]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[3]/div[1]/div[1]/div")).click();
		
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[3]/div[1]/div[2]/ul/li[19]"));
		  
		  // Iterate through the options and select the one you want 
		  for (WebElement option : options) {
			  if (
					  option.getText().equals("Korean")) { 
				      option.click();
		              System.out.println(option.getText());
		  
		  
		  } 
			  }
		  
		  Thread.sleep(8000);
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(100));  
		WebElement teacher= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[3]"))); 
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",teacher );
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",teacher);
		System.out.println(teacher.getText());
		
		
		Thread.sleep(1000);
		driver.quit();

	}

}
