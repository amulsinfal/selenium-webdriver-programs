package programs;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts_AcceptAlert {

	public static void main(String[] args) {
		System.out.println("Program to accept an alert...");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm3";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");
			driver.findElement(By.xpath("//button[text()='Try it']")).click();

			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();

			WebElement resultText = driver.findElement(By.id("demo"));
			String actualText = resultText.getText().trim();
			String expectedText = "You pressed OK!";

			if (actualText.equals(expectedText)) {
				System.out.println("Alert accepted successfully. Result text: '" + actualText + "'. Test Passed.");
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
// Program to accept an alert...
// Alert accepted successfully. Result text: 'You pressed OK!'. Test Passed.
