package updatepro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class profile {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://staging.yourteacher.ai/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("maaza987@gmail.com");
		driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Test12345");
		driver.findElement(By.cssSelector("button[color=\"blue\"]")).click();
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement profile =wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[3]/div[2]/div[1]/div")));
		profile.click();
		 
		//update profile button pai click 

		WebElement profile1 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.update__profile"))); profile1.click();
		 
		Thread.sleep(1000);
		
		// cancel button of update profile
		
		//driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button[1]")).click();
		

		//update button for update profile and update info
		
				
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your name\"]")).clear();
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your name\"]")).sendKeys("aqsa shahzad ");
		driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div[2]/div/div/div[2]/div")).click();

		Actions actions = new Actions(driver);

		// Navigate through the dropdown options using the keyboard
		// Example: Down arrow key and Enter key(jaha locators naa ho waha iss trah kr
		// sktai hai aur agr second opt select krna huwa tou arrow down wali command
		// wapis daini praigi)

		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

		driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button[2]")).click();
				 

		
		Thread.sleep(5000);
        driver.quit();

	}

}
