package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingFramesUsingWebElement {

	public static void main(String[] args) {
		System.out.println("Program to Switch to IFrame using webelement...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width";

		try {
			driver.get(url);
			WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@name='iframeResult']")));
			driver.switchTo().frame(iframeElement);

			WebElement label = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2")));
			String labelText = label.getText();

			if (labelText.equals("HTML Iframes")) {
				System.out.println("Text present on the iframe: '" + labelText + "'. Test Passed.");
			} else {
				System.out.println("Text missing on the iframe: '" + labelText + "'. Test Failed.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.switchTo().defaultContent();
			driver.quit();
		}
	}
}

// Output:
// Program to Switch to IFrame using webelement...
// Text present on the iframe: 'HTML Iframes'. Test Passed.
