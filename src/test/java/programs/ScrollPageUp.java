package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollPageUp {

	public static void main(String[] args) {
		System.out.println("Program to scroll up...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String url = "https://www.amazon.in/";

		try {
			driver.get(url);

			WebElement backToTopElement = driver.findElement(By.id("navBackToTop"));

			Actions action = new Actions(driver);
			action.moveToElement(backToTopElement).perform();
			Thread.sleep(3000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-4500)", "");
			Thread.sleep(3000);

			WebElement mxPlayerLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MX Player")));
			mxPlayerLink.click();

			String pageTitle = driver.getTitle();

			if (pageTitle.equals("Amazon miniTV - Watch Free Web Series, Movies, Short Films & K-Dramas Online")) {
				System.out.println("Page title displayed: '" + pageTitle + "'. Test Passed.");
			} else {
				System.out.println("Unexpected Page title: '" + pageTitle + "'. Test Failed.");
			}

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed.");
		} finally {
			driver.quit();
		}
	}
}

// Output:
// Program to scroll up...
// Page title displayed: 'Amazon miniTV - Watch Free Web Series, Movies, Short Films & K-Dramas Online'. Test Passed.
