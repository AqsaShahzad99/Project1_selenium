package forgotpass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://staging.yourteacher.ai/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[3]/div[2]/h2")).click();
		driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("aqsa@kodexolabs.com");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/button")).click();
		Thread.sleep(50000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/button")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/input")).sendKeys("Test12345");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/input")).sendKeys("Test12345");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/button")).click();
		
		Thread.sleep(3000);

		driver.quit();

	}

}
