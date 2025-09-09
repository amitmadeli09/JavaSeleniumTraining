package day22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoWebShopPracticeAnnotations {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Preparing the Suite for Testing");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Creating the Test Enviornment");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Launching The Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	@BeforeMethod 
	public void beforeMethod() { 
		System.out.println("Starting the Test"); 
	}
	
	@Test(priority = 1)
	public void verifyPage() {
		System.out.println("Page is Verified Successfully");
	}
	@Test(priority = 2)
	public void loginTest() {
		
		System.out.println("Waiting for Loggin in");
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.id("Email")).sendKeys("marvel01@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("IronMan");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value=\"Log in\"]"))).click();
		System.out.println("Logging In Successfully");
	}
	@Test(priority=3)
	public void clickApparelsAndShoes() {
		driver.findElement(By.xpath("//a[@href=\"/apparel-shoes\"]")).click();
		System.out.println("Apparels and Shoes Section Clicked Successfully");
	}
	@Test(priority = 4)
	public void selectProduct() {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@class='product-title']//a[contains(@href,'blue-jeans')]"))).click();
	    System.out.println("Product is Clicked");
	}
	@Test(priority = 5)
	public void addToCart() {
		WebElement element = driver.findElement(By.id("addtocart_36_EnteredQuantity"));
		element.clear();
		element.sendKeys("2");
		driver.findElement(By.id("add-to-cart-button-36")).click();
	    System.out.println("Product is added to cart");
	}
	@Test (priority = 6)
	public void shoppingCart() {
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		System.out.println("Shopping Cart Opened");
	}
	@Test (priority = 7)
	public void logOut() {
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		System.out.println("Testing is Over");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("Logging Out");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("Closing the Browser");
		if(driver != null) {
			driver.quit();
		}
	}
	@AfterTest
	public void afterTest() {
		System.out.println("Closing the Test Environment");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("Suit Closed Successfully");
	}
}