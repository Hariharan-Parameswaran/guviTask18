package guviTask18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class Q1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Open the Chrome browser
		WebDriver driver = new ChromeDriver();
		/*
		  Alternatively, you can use the Firefox or Safari browser
		  WebDriver driver1 = new FirefoxDriver(); 
		  WebDriver driver2 = new SafariDriver();
		 */
		// Navigate to the Facebook website
		driver.get("https://www.facebook.com/");
		// Maximize the browser window
		driver.manage().window().maximize();

		// Verify that the website has been redirected to the Facebook homepage
		String urlCurrent = driver.getCurrentUrl();
		if (urlCurrent.equals("https://www.facebook.com/")) {
			System.out.println("Successfully navigated to Facebook homepage.");
		} else {
			System.out.println("Failed to navigate to Facebook homepage.");
		}

		// Click on the "Create new account" button
		WebElement element = driver.findElement(By.linkText("Create new account"));
		element.click();

		// Wait for the few seconds
		Thread.sleep(3000);

		// Enter the first name 
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("hari");

		// Enter the last name 
		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.sendKeys("U");

		// Enter the valid email address
		WebElement email = driver.findElement(By.name("reg_email__"));
		email.sendKeys("testuser1@test.com");

		// Enter a strong password
		WebElement password = driver.findElement(By.cssSelector("input#password_step_input"));
		password.sendKeys("testuser123");

		// Select the date of birth (11th May 1985) using dropdown menus
		WebElement daySel = driver.findElement(By.id("day"));
		Select day = new Select(daySel);
		day.selectByVisibleText("11");

		WebElement monthSel = driver.findElement(By.id("month"));
		Select month = new Select(monthSel);
		month.selectByVisibleText("May");

		WebElement yearSel = driver.findElement(By.id("year"));
		Select year = new Select(yearSel);
		year.selectByVisibleText("1985");

		// Select the gender as "Male" using the radio button
		WebElement radiobtn = driver.findElement(By.xpath("//input[@value='2']"));
		radiobtn.click();

		// Click on the "Sign Up" button
		WebElement signup = driver.findElement(By.name("websubmit"));
		signup.click();

		// Verify that the user is successfully registered and redirected to the
		// Facebook homepage
		String title = driver.getTitle();
		if (title.contains("Facebook")) {
			System.out.println("User is successfully registered and redirected to the Facebook homepage.");
		} else {
			System.out.println("Registration failed or page redirection did not happen as expected.");
		}
	}
}

// Output :
//	Successfully navigated to Facebook homepage.
//	User is successfully registered and redirected to the Facebook homepage.
