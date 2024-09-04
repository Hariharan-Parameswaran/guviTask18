package guviTask18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class Q2 {

	public static void main(String[] args) throws InterruptedException {

		// Open the Chrome browser
		WebDriver driver = new ChromeDriver();
         /*
		   Alternatively, you can use the Firefox or Safari browser
		   WebDriver driver1 = new FirefoxDriver(); 
		   WebDriver driver2 = new SafariDriver();
		 */
		
		// Set implicit wait to 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 // Navigate to the jQuery UI droppable website
		driver.get("https://jqueryui.com/droppable/");
		 // Maximize the browser window
		driver.manage().window().maximize();
		
		 // Locate the frame that contains the draggable and droppable elements
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		
		// Locate the source element ("Drag me to my target")
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		// Locate the target element ("Drop here")
		WebElement targetElement = driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
		
		// Initialize Actions class for performing drag-and-drop
		Actions action = new Actions(driver);
		 // Move to the source element 
		action.moveToElement(sourceElement).perform();
		action.dragAndDrop(sourceElement, targetElement).perform();
		
		 // Wait for 3 seconds
		Thread.sleep(3000);
		
		// Verify the background color of the target element after the drop
		WebElement updateElement = driver.findElement(By.id("droppable"));
		
		// Check if the background color matches the expected value
		String tragetcolor = updateElement.getCssValue("background-color");
		if (tragetcolor.equals("rgba(255, 250, 144, 1)")) {
			System.out.println("Drop operation verified by color.");
		} else {
			System.out.println("Drop operation color verification failed.");
		}

		// Verify if the text of the target element has changed to "Dropped!"
		String targetcolor = targetElement.getText();
		if (targetcolor.equals("Dropped!")) {
			System.out.println("Text verification successful : 'Dropped!'");
		} else {
			System.out.println("Text verification failed.");
		}

	}

}


// Output :
//	  Drop operation verified by color.
//	  Text verification successful : 'Dropped!'
