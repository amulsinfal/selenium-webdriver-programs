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

public class Dropdown_DeSelectValues {

	public static void main(String[] args) {
		System.out.println("Program to deselect options...");

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
			System.out.println("Selected options: " + actualOptions);

			select.deselectByIndex(0);
			select.deselectByValue("saab");
			select.deselectByVisibleText("Audi");

			allSelectedOptions = select.getAllSelectedOptions();
			System.out.println("Deselecting all options...");
			System.out.println(allSelectedOptions.size() + " options are selected after deselecting all.");

			if (allSelectedOptions.isEmpty()) {
				System.out.println("No options selected after deselection. Test Passed.");
			} else {
				System.out.println("Some options are still selected. Test Failed.");
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
// Program to deselect options...
// Selected options: [Volvo, Saab, Audi]
// Deselecting all options...
// 0 options are selected after deselecting all.
// No options selected after deselection. Test Passed.
