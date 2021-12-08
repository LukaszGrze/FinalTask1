package FirstTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    private WebElement loginField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(id = "submit-login")
    private WebElement loginButton;

    public YourAccountPage loginAs(String email, String password){
        loginField.click();
        loginField.clear();
        loginField.sendKeys(email);
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
        return new YourAccountPage(driver);

    }

}
