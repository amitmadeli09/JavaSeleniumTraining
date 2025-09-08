package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    // Locators
    By genderMale = By.id("gender-male");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By email = By.id("Email");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void selectGenderMale() {
        driver.findElement(genderMale).click();
    }

    public void enterFirstName(String fName) {
        driver.findElement(firstName).sendKeys(fName);
    }

    public void enterLastName(String lName) {
        driver.findElement(lastName).sendKeys(lName);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void enterConfirmPassword(String cpass) {
        driver.findElement(confirmPassword).sendKeys(cpass);
    }

    public void clickRegister() {
        driver.findElement(registerBtn).click();
    }

    public void register(String fName, String lName, String mail, String pass,String cpass) {
        selectGenderMale();
        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(mail);
        enterPassword(pass);
        enterConfirmPassword(cpass);
        clickRegister();
    }
}