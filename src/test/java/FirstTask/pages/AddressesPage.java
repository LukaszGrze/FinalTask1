package FirstTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressesPage {
    private final WebDriver driver;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Create new address']")
    private WebElement newAddressButton;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article")
    private WebElement newAddress;
    @FindBy(xpath = "//div[2]//article[1]//div[2]//a[2]//i[1]")
    private WebElement deleteButton;
    @FindBy(className = "alert-success")
    private WebElement successBar;
    @FindBy(className = "address-body")
    private List<WebElement> allElements;

    public NewAddressPage createNewAddress() {
        newAddressButton.click();
        return new NewAddressPage(driver);
    }

    public String addedAddress(){
        return newAddress.getText();

    }

    public void deleteAddress(){
        deleteButton.click();
    }

    public String addressIsDeleted(){
        return successBar.getText();
    }

    public boolean addressIsNotVisible(){
        return allElements.size() ==1;

    }


}
