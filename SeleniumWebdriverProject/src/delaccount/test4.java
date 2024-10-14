package delaccount;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class test4 {

	public static void main(String[] args) throws InterruptedException   {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://staging.yourteacher.ai/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("maaza987@gmail.com");
		driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Test12345");
		driver.findElement(By.cssSelector("button[color=\"blue\"]")).click();
		
		//new WebDriverWait(driver, 30).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

		
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@id=\"___reactour\"]/div[4]/div/button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[3]/div[2]/div[1]")));
        element.click();
        
        List<WebElement> options1 = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[3]/div[2]/div[2]/div/ul/li[3]"))
       		  ;
       		  
        // Iterate through the options and select the one you want 
        for (WebElement option0 : options1) { 
        	if (option0.getText().equals("Delete Account"))
        	{
       		  System.out.println(option0.getText());
       		  option0.click(); 
       		  }
        }	
        
       driver.findElement(By.xpath("/html/body/div[6]/div/div/input")).sendKeys("DO IT NOW"); 
       
       //code for cancel button
       //driver.findElement(By.xpath("/html/body/div[6]/div/div/div/button[1]")).click();
       
       
       //code for confirm button
       driver.findElement(By.xpath("/html/body/div[6]/div/div/div/button[2]")).click();
		
		Thread.sleep(5000);
		
	    driver.quit();

	}

}
