package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

    // Excel utils(class variables)
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

//    @Test(priority = 1)
//    public void testRegister() {
//        driver.findElement(By.linkText("Register")).click();
//        RegisterPage registerPage = new RegisterPage(driver);
//
//        for (int i = 1; i < regExcel.getRowCount(); i++) { // ignore header
//            String firstName = regExcel.getCellData(i, 0);
//            String lastName = regExcel.getCellData(i, 1);
//            String email = regExcel.getCellData(i, 2);
//            String password = regExcel.getCellData(i, 3);
//            String confirmPassword = regExcel.getCellData(i, 4);
//
//            registerPage.register(firstName, lastName, email, password, confirmPassword);
//
//            String successMsg = driver.findElement(By.className("result")).getText();
//            Assert.assertTrue(successMsg.contains("completed"), "Registration failed!");
//        }
//    }

    @Test(priority = 2)
    public void testLogin() throws IOException {
        LoginPage loginPage = new LoginPage(driver);

        boolean loggedIn = false;

        for (int i = 1; i < loginExcel.getRowCount(); i++) { // ignore header
            driver.findElement(By.linkText("Log in")).click();

            String email = loginExcel.getCellData(i, 0);
            String password = loginExcel.getCellData(i, 1);
            String expected = loginExcel.getCellData(i, 2); // valid or invalid

            loginPage.login(email, password);

            if (expected.equalsIgnoreCase("invalid")) {
                // Expecting login failure
                boolean errorShown = driver.findElement(By.cssSelector(".message-error")).isDisplayed();
                Assert.assertTrue(errorShown, "Invalid login should fail for: " + email);

                // Take screenshot
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String path = System.getProperty("user.dir") + "/test-output/screenshots/" + email + ".png";
                FileUtils.copyFile(src, new File(path));

                System.out.println("Invalid login captured for: " + email);

                driver.navigate().to("https://demo.nopcommerce.com/");

            } else if (expected.equalsIgnoreCase("valid") && !loggedIn) {
                // Valid login
                boolean isLoggedIn = driver.findElement(By.linkText("Log out")).isDisplayed();
                Assert.assertTrue(isLoggedIn, "Valid user could not log in: " + email);

                System.out.println("Login successful for: " + email);
                loggedIn = true; // Only login once with valid credentials
            }
        }
    }


    // ✅ Added test cases after login — nothing changed above this line
    @Test(priority = 3)
    public void testAddDesktopToCart() {
        WebElement computersMenu = driver.findElement(By.linkText("Computers"));
        Actions actions = new Actions(driver);
        actions.moveToElement(computersMenu).perform();

        WebElement desktopsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops")));
        desktopsLink.click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");

        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[@class='product-title']/a[contains(text(),'Build your own computer')]")));
        product.click();

        WebElement ramDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_attribute_2")));
        ramDropdown.click();
        driver.findElement(By.xpath("//option[text()='8GB [+$60.00]']")).click();

        WebElement hddOption = wait.until(ExpectedConditions.elementToBeClickable(By.id("product_attribute_3_7")));
        hddOption.click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-1")));
        addToCartBtn.click();
    }

    @Test(priority = 4)
    public void testAddIphoneToWishlist() {
        Actions actions = new Actions(driver);
        WebElement electronicsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electronics")));
        actions.moveToElement(electronicsMenu).perform();

        WebElement cellPhonesLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cell phones")));
        cellPhonesLink.click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");

        WebElement iphoneProduct = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[@class='product-title']/a[contains(text(),'iPhone')]")));
        iphoneProduct.click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");

        WebElement wishlistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-wishlist-button-21")));
        wishlistBtn.click();
    }

    @Test(priority = 5)
    public void testCompareAndClearBooks() throws InterruptedException {
        driver.findElement(By.linkText("Books")).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[@class='product-title']/a[contains(text(),'Fahrenheit 451')]/ancestor::div[@class='details']//button[@title='Add to compare list']")))
                .click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[@class='product-title']/a[contains(text(),'First Prize Pies')]/ancestor::div[@class='details']//button[@title='Add to compare list']")))
                .click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("product comparison"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".compare-products-table")));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Clear list']"))).click();
    }

    @Test(priority = 6)
    public void testAddFlowerBraceletQuantityTwo() throws InterruptedException {
        driver.findElement(By.linkText("Jewelry")).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[@class='product-title']/a[contains(text(),'Flower Girl Bracelet')]"))).click();

        WebElement qtyBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_enteredQuantity_43")));
        qtyBox.clear();
        qtyBox.sendKeys("2");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-43"))).click();
    }

    @Test(priority = 7)
    public void testAdidasThenNikeSBZoomWishlist() {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));
        searchBox.clear();
        searchBox.sendKeys("adidas");
        driver.findElement(By.xpath("//button[@type='submit' and text()='Search']")).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));
        searchBox.clear();
        searchBox.sendKeys("nike");
        driver.findElement(By.xpath("//button[@type='submit' and text()='Search']")).click();

        searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));
        searchBox.clear();
        searchBox.sendKeys("Nike");
        driver.findElement(By.xpath("//button[@type='submit' and text()='Search']")).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");

        WebElement nikeSbZoomProduct = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Nike SB Zoom Stefan Janoski \"Medium Mint\"']")));
        nikeSbZoomProduct.click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2);");

        WebElement wishlistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-wishlist-button-28")));
        wishlistBtn.click();
    }

    @Test(priority = 8)
    public void testOpenWishlist() {
        WebElement wishlistLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Wishlist")));
        wishlistLink.click();
    }

    @Test(priority = 9)
    public void testOpenShoppingCart() {
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Shopping cart")));
        cartLink.click();
    }

    @Test(priority = 10)
    public void testLogout() {
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));
        logoutLink.click();
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
