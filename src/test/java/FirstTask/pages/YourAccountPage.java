package FirstTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {
    private final WebDriver driver;

    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "addresses-link")
    private WebElement addressesButton;

    public AddressesPage selectAddresses() {

        addressesButton.click();
        return new AddressesPage(driver);
    }
}
