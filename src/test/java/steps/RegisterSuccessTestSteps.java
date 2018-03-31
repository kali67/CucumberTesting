package steps;

import application.Registration;
import application.main;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import services.DataAccess;
import utils.Output;

import java.sql.SQLException;

public class RegisterSuccessTestSteps {
    Registration registration = new Registration();

    @Given("^I am connected to the online system$")
    public void iAmConnectedToTheOnlineSystem() throws SQLException {
        DataAccess.getConnection();
    }

    @When("^I have successfully registered as an owner$")
    public void iHaveSuccessfullyRegisteredAsAnOwner() throws Throwable {
        registration.registerOwner("Joe", "Blogg", "example@gmail.com", "passw0rd");
    }

    @Then("^A confirmation message \"([^\"]*)\" is displayed on the screen$")
    public void aConfirmationMessageIsDisplayedOnTheScreen(String message) throws Throwable {
        Assert.assertEquals(message, Output.printList.get(Output.printList.size() - 1));
    }
}
