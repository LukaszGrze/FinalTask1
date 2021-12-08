package FirstTask.steps;

import FirstTask.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObjectSteps extends PageObjectBase{


    @Given("Im on main page")
    public void openMainPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/");
        mainPage = new MainPage(driver);
    }

    @When("I sign in")
    public void clickSignIn() {
        loginPage = mainPage.signIn();
    }

    @And("^I login using email (.*) and password (.*)$")
    public void loginAs(String email, String password) {
        yourAccountPage = loginPage.loginAs(email, password);
    }

    @And("I go to my addresses page")
    public void goToMyAddressesPage() {
        addressesPage = yourAccountPage.selectAddresses();
    }

    @And("I create new address")
    public void createNewAddress() {
        newAddressPage = addressesPage.createNewAddress();
    }

    @And("^I fill in the New address form with (.*), (.*), (.*), (.*), (.*)$")
    public void enterNewAddress(String alias, String address, String city, String postalcode, String number) {
        addressesPage = newAddressPage.enterNewAddressData(alias, address, city, postalcode, number);
    }

    @And("I will check if the data in the added address is correct")
    public void checkAddedAddress() {

        Assert.assertTrue(addressesPage.addedAddress().contains(expectedAddress));
    }

    @And("I will delete the address")
    public void deleteAddress() {

        addressesPage.deleteAddress();
    }

    @Then("I will check if it is deleted")
    public void newAddressIsDeleted() {
        Assert.assertEquals(expectedSuccessfullyDeleted, addressesPage.addressIsDeleted());
        Assert.assertTrue(addressesPage.addressIsNotVisible());

    }

    @And("I close browser")
    public void closeBrowser() {
        driver.close();
    }



}
