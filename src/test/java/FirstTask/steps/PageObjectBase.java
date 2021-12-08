package FirstTask.steps;

import FirstTask.pages.*;
import org.openqa.selenium.WebDriver;

public class PageObjectBase {
    MainPage mainPage;
    LoginPage loginPage;
    YourAccountPage yourAccountPage;
    AddressesPage addressesPage;
    NewAddressPage newAddressPage;
    protected WebDriver driver;

    String expectedAddress = "Second Address\n" + "Donnie Darko\n" + "Armley\n" + "Leeds\n" +
            "12-345\n" + "United Kingdom\n" + "123456\n";

    String expectedSuccessfullyDeleted = "Address successfully deleted!";
}
