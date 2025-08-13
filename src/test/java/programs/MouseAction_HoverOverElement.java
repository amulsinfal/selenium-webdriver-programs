package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAction_HoverOverElement {

	public static void main(String[] args) {
		System.out.println("Program to Hover Over Element...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String url = "https://www.amazon.in/";

		try {
			driver.get(url);
			WebElement signInDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList")));

			Actions action = new Actions(driver);
			action.moveToElement(signInDropDown).perform();

			WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Sign in')]")));
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
// Program to Hover Over Element...
// Heading displayed: 'Sign in or create account'. Test Passed.
