package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseTest;
import pages.LocatorInterface;
import utils.Waits;

import java.util.Map;

import static pages.LocatorClass.*;
import static pages.LocatorInterface.*;

public class MyStepdefs extends BaseTest implements LocatorInterface{

    @Given("user on homepage")
    public void userOnHomepage() {
        driver.get(url);
    }

    @When("user login as follow")
    public void userLoginAsFollow(DataTable table) {
        Map<String, String> map = table.asMap();
        sendKeys(usernameInputLogin, map.get("username"));
        sendKeys(passwordInputLogin, map.get("password"));
        click(buttonSubmitLogin);
    }

    @Then("login should be successfull")
    public void loginShouldBeSuccessfull() {
        waitForElement(buttonLogout, Waits.VISIBILITY);
    }
}
