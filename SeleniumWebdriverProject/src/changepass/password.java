package changepass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class password {

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
		
		Thread.sleep(5000);
		//change password option pai click and change pass krain gai
		
				
		List<WebElement> options1 = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[3]/div[2]/div[2]/div/ul/li[4]"));

		// Iterate through the options and select the one you want
		for (WebElement option0 : options1) {
			if (option0.getText().equals("Change Password")) {
				System.out.println(option0.getText());
				option0.click();
			}
		}

		
		WebElement element1 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/div/div/div[1]/div[1]/div/input")));
		element1.sendKeys("Test12345");

		WebElement element2 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/div/div/div[1]/div[2]/div/input")));
		element2.sendKeys("Test123456");

		// for update button in change password

		WebElement element3 = driver.findElement(By.xpath("/html/body/div[10]/div/div/div[2]/button[2]"));
		element3.click();
					 
				
				
		//for cancel button in change password
//		WebElement element4 = driver.findElement(By.xpath("/html/body/div[10]/div/div/div[2]/button[1]")); 
//		element4.click(); 


		Thread.sleep(5000);
		driver.quit();

	}

}
