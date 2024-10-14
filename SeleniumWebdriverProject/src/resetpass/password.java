package resetpass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class password {
    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://staging.yourteacher.ai/");
        driver.manage().window().maximize();

        // Navigate to the reset password page
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[3]/div[2]/h2")).click();
        driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("aqsa@mailinator.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/button")).click();

        // Wait for some time to ensure the email is sent
        TimeUnit.SECONDS.sleep(5); 

        // Navigate to Mailinator
        driver.get("https://www.mailinator.com/v4/public/inboxes.jsp?trialshow=true&to=aqsa");
        driver.findElement(By.xpath("//*[@id=\"requestTrial\"]/div/div/div[1]/button")).click();
        
        // Wait for the inbox to load and emails to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='inbox_pane']/div[3]/div/div[4]/div/div")));

        // Fetch the list of emails
        List<WebElement> emails = driver.findElements(By.xpath("//*[@id='inbox_pane']/div[3]/div/div[4]/div/div"));
        
        if (!emails.isEmpty()) {
            // Interact with the first email in the list
            WebElement firstEmail = emails.get(0);

            // Scroll to the first email element to make it interactable
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstEmail);

            // Wait until the first email is clickable and click it
            wait.until(ExpectedConditions.elementToBeClickable(firstEmail));
            firstEmail.click();
            System.out.println("Clicked on the first email");
            
            // Wait for the email content to load
            Thread.sleep(10000);

            // Locate and print the text message
//            WebElement text = driver.findElement(By.xpath("//*[@id='u_body']/tbody/tr/td/div[4]/div/div/div/div/table[1]/tbody/tr[1]/td/div/span"));
//            String textMsg = text.getText();
//            System.out.println("Email text: " + textMsg);
        } else {
            System.out.println("No emails found");
            driver.quit();
            return;
        }
        
        Thread.sleep(8000);
        driver.quit();
    }
}
