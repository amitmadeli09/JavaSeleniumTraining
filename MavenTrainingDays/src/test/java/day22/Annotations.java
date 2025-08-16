package day22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	WebDriver driver;
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Start of the suite");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Preparing Test Environment");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Launching the browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Navigating to HRM Login Page");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	@Test(priority = 1)
	public void verifyPage() {
		System.out.println("Page is verified");
	}
	@Test(priority = 2)
	 public void loginTest() throws InterruptedException {
		 System.out.println("Performing Login");
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/register']"))).sendKeys();
		 
		 driver.findElement(By.name("username")).sendKeys("Admin");;
		 driver.findElement(By.name("password")).sendKeys("admin123");
		 driver.findElements(By.xpath("//button[text=' Login ']"));
		 
		 String expectedTitle = "OrangeHRM";
		 String actualTitle = driver.getTitle();
		 
		 Assert.assertEquals(actualTitle, expectedTitle, "Title is Mismatched");
		 Assert.assertTrue(true);
		 
		 //System.out.println(driver.getTitle());
		 
	 }
	 @AfterMethod
	 public void afterMethod() {
		 System.out.println("Log out");
		 driver.get("https://opensource-demo.orangehrmlive.com/");
		  
	 }
	 @AfterClass
	 public void afterClass() {
		 System.out.println("Closing the browser");
		 if(driver != null) {
			 driver.quit();
		 }
	 }
	 @AfterTest
	 public void afterTest() {
		System.out.println("After Test Method should work"); 
	 }
	 @AfterSuite
	 public void afterSuite() {
		 System.out.println("After Suit method should work");
	 }
	 

}
