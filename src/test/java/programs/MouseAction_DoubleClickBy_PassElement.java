package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAction_DoubleClickBy_PassElement {

	public static void main(String[] args) {
		System.out.println("Program to double click on an element(by passing element)...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Double-click me']")));
			Actions action = new Actions(driver);
			action.doubleClick(button).perform();

			WebElement label = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("demo")));
			String actualText = label.getText().trim();
			String expectedText = "Hello World";

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
// Program to double click on an element(by passing element)...
// Text displayed: 'Hello World'. Test Passed.
