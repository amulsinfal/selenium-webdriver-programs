package programs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown_GetAllSelectedOption {

	public static void main(String[] args) {
		System.out.println("Program to get all selected option...");

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

			select.selectByIndex(0);
			select.selectByValue("saab");
			select.selectByVisibleText("Audi");

			List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
			List<String> actualOptions = new ArrayList<>();
			for (WebElement element : allSelectedOptions) {
				actualOptions.add(element.getText());
			}

			List<String> expectedOptions = List.of("Volvo", "Saab", "Audi");

			if (actualOptions.equals(expectedOptions)) {
				System.out.println("Expected List: " + expectedOptions);
				System.out.println("Actual List: " + actualOptions);
				System.out.println("Options match exactly. Test Passed.");
			} else {
				System.out.println("Options do not match. Test Failed.");
				System.out.println("Expected List: " + expectedOptions);
				System.out.println("Actual List: " + actualOptions);
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
// Program to get all option...
// Expected List: [Volvo, Saab, Audi]
// Actual List: [Volvo, Saab, Audi]
// Options match exactly. Test Passed.