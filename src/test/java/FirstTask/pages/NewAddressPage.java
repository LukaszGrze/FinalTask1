package FirstTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    private final WebDriver driver;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "alias")
    private WebElement aliasField;
    @FindBy(name = "address1")
    private WebElement addressField;
    @FindBy(name = "city")
    private WebElement cityField;
    @FindBy(name = "postcode")
    private WebElement postCodeField;
    @FindBy(name = "id_country")
    private WebElement countryField;
    @FindBy(name = "phone")
    private WebElement phoneField;
    @FindBy(css = ".btn-primary")
    private WebElement saveButton;

    public AddressesPage enterNewAddressData(String alias, String address, String city, String postcode, String number) {
        aliasField.clear();
        aliasField.sendKeys(alias);
        addressField.clear();
        addressField.sendKeys(address);
        cityField.clear();
        cityField.sendKeys(city);
        postCodeField.clear();
        postCodeField.sendKeys(postcode);
        countryField.click();
        phoneField.clear();
        phoneField.sendKeys(number);
        saveButton.click();
        return new AddressesPage(driver);

    }

}
