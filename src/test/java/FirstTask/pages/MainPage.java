package FirstTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "_desktop_user_info")
    private WebElement signInButton;

    public LoginPage signIn() {
        signInButton.click();
        return new LoginPage(driver);
    }
}
