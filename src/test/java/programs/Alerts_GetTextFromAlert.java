package programs;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts_GetTextFromAlert {

	public static void main(String[] args) {
		System.out.println("Program to get text from an alert box...");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");
			driver.findElement(By.xpath("//button[text()='Try it']")).click();

			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			String actualText = alert.getText().trim();
			String expectedText = "I am an alert box!";

			if (actualText.equals(expectedText)) {
				System.out.println("Alert text displayed: '" + actualText + "'. Test Passed.");
			} else {
				System.out.println("Expected: '" + expectedText + "', but found: '" + actualText + "'. Test Failed.");
			}
			alert.accept();

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.switchTo().defaultContent();
			driver.quit();
		}
	}
}

// Output:
// Program to get text from an alert box...
// Alert text displayed: 'I am an alert box!'. Test Passed.
