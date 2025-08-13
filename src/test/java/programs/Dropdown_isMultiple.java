package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown_isMultiple {

	public static void main(String[] args) {
		System.out.println("Program to check if the dropdown is a multiple select dropdown...");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement carsList = wait.until(ExpectedConditions.elementToBeClickable(By.id("cars")));
			Select select = new Select(carsList);

			boolean isMultiple = select.isMultiple();

			if (isMultiple) {
				System.out.println("Dropdown is a multiple select dropdown. Test Passed.");
			} else {
				System.out.println("Dropdown is not a multiple select dropdown. Test Failed.");
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
// Program to check if the dropdown is a multiple select dropdown...
// Dropdown is a multiple select dropdown. Test Passed.
