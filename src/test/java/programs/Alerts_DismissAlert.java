package programs;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts_DismissAlert {

	public static void main(String[] args) {
		System.out.println("Program to dismiss an alert...");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm3";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");
			driver.findElement(By.xpath("//button[text()='Try it']")).click();

			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.dismiss();

			WebElement resultText = driver.findElement(By.id("demo"));
			String actualText = resultText.getText().trim();
			String expectedText = "You canceled!";

			if (actualText.equals(expectedText)) {
				System.out.println("Alert dismissed successfully. Result text: '" + actualText + "'. Test Passed.");
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
// Program to dismiss an alert...
// Alert dismissed successfully. Result text: 'You canceled!'. Test Passed.