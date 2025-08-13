package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAction_DragAndDrop {

	public static void main(String[] args) {
		System.out.println("Program to perform drag and drop operation...");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String url = "https://jqueryui.com/resources/demos/droppable/default.html";
		
		try {
			driver.get(url);
			WebElement draggableElement = driver.findElement(By.id("draggable"));
			WebElement droppableElement = driver.findElement(By.id("droppable"));
		
			Actions action = new Actions(driver);
			action.dragAndDrop(draggableElement, droppableElement).perform();
			
			WebElement dropTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='droppable']/p")));
			String dropText = dropTextElement.getText();
			
			if (dropText.equals("Dropped!")) {
				System.out.println("Text after drop: '" + dropText + "'. Test Passed.");
			} else {
				System.out.println("Text after drop: '" + dropText + "'. Test Failed.");
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}

// Output:
// Program to perform drag and drop operation...
// Text after drop: 'Dropped!'. Test Passed.
