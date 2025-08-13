package programs;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts_SendTextToAlert {

	public static void main(String[] args) {
		System.out.println("Program to send text to alert...");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");
			driver.findElement(By.xpath("//button[text()='Try it']")).click();

			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.sendKeys("Automation tester");
			alert.accept();

			WebElement resultText = driver.findElement(By.id("demo"));
			String actualText = resultText.getText().trim();
			String expectedText = "Hello Automation tester! How are you today?";

			if (actualText.equals(expectedText)) {
				System.out.println("Text displayed: '" + actualText + "'. Test Passed.");
			} else {
				System.out.println("Expected: '" + expectedText + "', but found: '" + actualText + "'. Test Failed.");
			}

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.switchTo().defaultContent();
			driver.quit();
		}
	}
}

// Output:
// Program to send text to alert...
// Text displayed: 'Hello Automation tester! How are you today?'. Test Passed.
