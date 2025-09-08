package testcases;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.RegisterPage;
import utils.ExcelUtils;
import pages.LoginPage;
import utils.DriverFactory;
public class NopCommerceTests {

    WebDriver driver;
    WebDriverWait wait;
    
    //Excel utils(class variables)
    ExcelUtils regExcel;
    ExcelUtils loginExcel;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Setting up NopCommerce Test Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Preparing Test Environment");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Load Excel from resources folder
        String excelPath = "src/test/resources/testdata/NopData.xlsx";
        regExcel = new ExcelUtils(excelPath, "RegisterData");
        loginExcel = new ExcelUtils(excelPath, "LoginData");
    }
    @Test(priority = 1, groups = {"regression"})
    public void testRegister() {
        driver.findElement(By.linkText("Register")).click();
        RegisterPage registerPage = new RegisterPage(driver);

        for (int i = 1; i < regExcel.getRowCount(); i++) { // ignore header
            String firstName = regExcel.getCellData(i, 0);
            String lastName = regExcel.getCellData(i, 1);
            String email = regExcel.getCellData(i, 2);
            String password = regExcel.getCellData(i, 3);
            String confirmPassword = regExcel.getCellData(i, 4);

            registerPage.register(firstName, lastName, email, password,confirmPassword);

            String successMsg = driver.findElement(By.className("result")).getText();
            Assert.assertTrue(successMsg.contains("completed"), "Registration failed!");
        }
    }

    @Test(priority = 2, groups = {"smoke"})
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);

        for (int i = 1; i < loginExcel.getRowCount(); i++) { // ignore header
            // Go to login page each time
            driver.findElement(By.linkText("Log in")).click();

            String email = loginExcel.getCellData(i, 0);
            String password = loginExcel.getCellData(i, 1);

            loginPage.login(email, password);

            Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed(),
                    "Login failed for user: " + email);

            // Logout after successful login
            driver.findElement(By.linkText("Log out")).click();
        }
    }

    @Test(priority = 3 , groups = {"smoke"})
    public void testAddDesktopToCart() {
        // Hover over Computers and click Desktops
        WebElement computersMenu = driver.findElement(By.linkText("Computers"));
        Actions actions = new Actions(driver);
        actions.moveToElement(computersMenu).perform();
        System.out.println("Hovered over Computers menu");

        WebElement desktopsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops")));
        desktopsLink.click();
        System.out.println("Selected Desktops from dropdown");

        // Scroll to middle of page before selecting product
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
        System.out.println("Scrolled to middle of Desktops page");

        // Select product: Build your own computer
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[@class='product-title']/a[contains(text(),'Build your own computer')]")
        ));
        product.click();
        System.out.println("Desktop product opened");

        // Select RAM from dropdown (e.g. 8GB)
        WebElement ramDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_attribute_2")));
        ramDropdown.click();
        driver.findElement(By.xpath("//option[text()='8GB [+$60.00]']")).click();
        System.out.println("Selected RAM: 8GB");

        // Select HDD (radio button)
        WebElement hddOption = wait.until(ExpectedConditions.elementToBeClickable(By.id("product_attribute_3_7"))); 
        hddOption.click();
        System.out.println("Selected HDD: 400 GB");

        // Scroll to middle again before Add to Cart
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
        System.out.println("Scrolled to middle of product page");

        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-1")));
        addToCartBtn.click();
        System.out.println("Desktop product added to cart with selected configuration");
    }

    
    @Test(priority = 4, groups = {"smoke"})
    public void testAddIphoneToWishlist() {
        // Hover over Electronics and click Cell phones
    	Actions actions = new Actions(driver);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	WebElement electronicsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electronics")));
    	actions.moveToElement(electronicsMenu).perform();
        System.out.println("Hovered over Electronics menu");

        WebElement cellPhonesLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cell phones")));
        cellPhonesLink.click();
        System.out.println("Selected Cell Phones from dropdown");

        // Scroll to middle before selecting iPhone
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
        System.out.println("Scrolled to middle of Cell Phones page");

        // Select iPhone product
        WebElement iphoneProduct = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[@class='product-title']/a[contains(text(),'iPhone')]")
        ));
        iphoneProduct.click();
        System.out.println("iPhone product opened");

        // Scroll to middle before clicking Add to Wishlist
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
        System.out.println("Scrolled to middle of iPhone page");

        // Add to wishlist
        WebElement wishlistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-wishlist-button-21")));
        wishlistBtn.click();
        System.out.println("iPhone added to Wishlist");
    }
    
    @Test(priority = 5, groups = {"smoke"})
    public void testCompareAndClearBooks() throws InterruptedException {
        // Navigate to Books section
        driver.findElement(By.linkText("Books")).click();
        System.out.println("Opened Books section");

        // Add first book to compare list
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[@class='product-title']/a[contains(text(),'Fahrenheit 451')]/ancestor::div[@class='details']//button[@title='Add to compare list']")))
                .click();
        System.out.println("Fahrenheit 451' added to Compare list");

        Thread.sleep(2000); // wait for success notification

        // Add second book to compare list
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[@class='product-title']/a[contains(text(),'First Prize Pies')]/ancestor::div[@class='details']//button[@title='Add to compare list']")))
                .click();
        System.out.println("First Prize Pies' added to Compare list");

        Thread.sleep(2000); // wait for success notification

        // Open the Compare Products page
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("product comparison"))).click();
        System.out.println("Opened Book Comparison page");

        // Verify books are displayed in comparison
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".compare-products-table")));
        System.out.println("Books are displayed in comparison list");

        // Clear comparison list
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Clear list']"))).click();
        System.out.println("Cleared the comparison list");

    	}
    
    @Test(priority = 6, groups = {"smoke"})
    public void testAddFlowerBraceletQuantityTwo() throws InterruptedException {
        // Go to Jewelry section
        driver.findElement(By.linkText("Jewelry")).click();
        System.out.println("Opened Jewelry section");

        // Open Flower Girl Bracelet
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[@class='product-title']/a[contains(text(),'Flower Girl Bracelet')]")
        )).click();
        System.out.println("Opened 'Flower Girl Bracelet' product page");

        // Clear default qty and set quantity = 2
        WebElement qtyBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_enteredQuantity_43")));
        qtyBox.clear();
        qtyBox.sendKeys("2");
        System.out.println("Quantity set to 2");

        // Click Add to Cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-43"))).click();
        System.out.println("Flower Girl Bracelet' (x2) added to cart");

    }
    
    @Test(priority = 7, groups = {"smoke"})
    public void testAdidasThenNikeSBZoomWishlist() {
        // Step 1: Search Adidas
    	WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));
        searchBox.clear();
        searchBox.sendKeys("adidas");
        System.out.println("Searched for 'adidas'");

        // Click the search button
        driver.findElement(By.xpath("//button[@type='submit' and text()='Search']")).click();
        System.out.println("Search results displayed for 'adidas'");

        // Scroll to middle of results
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
        System.out.println("Scrolled to middle of Adidas results");

        // Scroll back up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        System.out.println("Scrolled back to top");

        // Clear search bar and search Nike
        searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));
        searchBox.clear();
        searchBox.sendKeys("nike");
        System.out.println("Searched for 'nike'");

        driver.findElement(By.xpath("//button[@type='submit' and text()='Search']")).click();
        System.out.println("Search results displayed for 'nike'");

        // Step 4: Clear search bar and search Nike
        searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));
        searchBox.clear();
        searchBox.sendKeys("Nike");
        System.out.println("Nike");

        driver.findElement(By.xpath("//button[@type='submit' and text()='Search']")).click();
        System.out.println("Search results displayed for Nike");

        // Step 5: Scroll to middle of Nike results
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
        System.out.println("Scrolled to middle of Nike results");

        // Step 6: Open Nike SB Zoom Stefan Janoski "Medium Mint"
        WebElement nikeSbZoomProduct = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Nike SB Zoom Stefan Janoski \"Medium Mint\"']")
        ));
        nikeSbZoomProduct.click();
        System.out.println("Opened Nike SB Zoom Stefan Janoski 'Medium Mint' product page");

        // Step 7: Scroll to middle of product page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");

        // Step 8: Add to wishlist
        WebElement wishlistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-wishlist-button-28")));
        wishlistBtn.click();
        System.out.println("Nike SB Zoom Stefan Janoski 'Medium Mint' added to Wishlist");
    }
    
    @Test(priority = 8, groups = {"smoke","regression"})
    public void testOpenWishlist() {
        // Open Wishlist page
        WebElement wishlistLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Wishlist")));
        wishlistLink.click();
        System.out.println("Opened Wishlist page successfully");
    }
    
    @Test(priority = 9 , groups = {"smoke","regression"})
    public void testOpenShoppingCart() {
        // Open Shopping Cart
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Shopping cart")));
        cartLink.click();
        System.out.println("Opened Shopping Cart page");
    }

    @Test(priority = 10, groups = {"smoke","regression"})
    public void testLogout() {
        // Click Logout
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));
        logoutLink.click();
        System.out.println("Logged out successfully");
    }
 
    @AfterClass
    public void afterClass() {
        System.out.println("Closing Browser");
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Test Environment Closed");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Test Suite Finished");
    }
}
