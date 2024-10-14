package reset;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class resetcount {

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
		
		// code for reset button opening
		
		List<WebElement> options2 = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[3]/div[2]/div[2]/div/ul/li[6]"));

	    // Iterate through the options and select the one you want 
		for (WebElement option1 : options2) {
			if (option1.getText().equals("Reset")) {
				System.out.println(option1.getText());
				option1.click();
			}
		}
		
		Thread.sleep(2000);

		// for no button of reset
		
//		WebElement resetbutton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/button[1]"));
//		resetbutton.click(); 
		
		// for yes button of reset
		WebElement resetbutton1 = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/button[2]"));
		resetbutton1.click(); 
		
		Thread.sleep(5000);
		driver.quit();


	}

}
