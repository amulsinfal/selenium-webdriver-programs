package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown_GetSelectedOption {

	public static void main(String[] args) {
		System.out.println("Program to get the selected option...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement carsList = wait.until(ExpectedConditions.elementToBeClickable(By.id("cars")));
			Select select = new Select(carsList);

			select.selectByVisibleText("Opel");
			String actualText = select.getFirstSelectedOption().getText();
			String expectedText = "Opel";

			if (actualText.equals(expectedText)) {
				System.out.println("Option selected: '" + actualText + "'. Test Passed.");
			} else {
				System.out.println("Expected: '" + expectedText + "', but found: '" + actualText + "'. Test Failed.");
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
// Program to get the selected option...
// Option selected: 'Opel'. Test Passed.
