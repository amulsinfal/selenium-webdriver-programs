package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollPageDown {

	public static void main(String[] args) {
		System.out.println("Program to scroll down...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String url = "https://www.amazon.in/";

		try {
			driver.get(url);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,4500)", "");
			Thread.sleep(2000);

			WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'CardInstance')]//span[contains(text(),'Sign in')]")));
			signInButton.click();

			WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='claim-collection-container']/h1")));
			String headingText = heading.getText();

			if (headingText.equals("Sign in or create account")) {
				System.out.println("Heading displayed: '" + headingText + "'. Test Passed.");
			} else {
				System.out.println("Unexpected heading: '" + headingText + "'. Test Failed.");
			}

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed.");
		} finally {
			driver.quit();
		}
	}
}

// Output:
// Program to scroll down...
// Heading displayed: 'Sign in or create account'. Test Passed.
