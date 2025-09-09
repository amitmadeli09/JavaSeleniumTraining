package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    // Locators
    private By genderMale = By.id("gender-male");
    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void register(String firstName, String lastName, String email, String password, String confirmPassword) {
        driver.findElement(genderMale).click();
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);

        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);

        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(confirmPasswordField).clear();
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);

        driver.findElement(registerButton).click();
    }
}