package steps;

import application.Registration;
import BR.registration.BusinessException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Owner;
import org.junit.Assert;
import services.DataAccess;
import utils.Output;

import java.sql.SQLException;

public class OwnerRegistrationTestSteps {

    private Registration registration = new Registration();

    @Given("^I am connected to the online system And the owner does not yet exist$")
    public void iAmConnectedToTheOnlineSystemAndTheOwnerDoesNotYetExist() throws SQLException {
        DataAccess.getConnection();
    }

    @When("^I register with firstname \"([^\"]*)\" lastname \"([^\"]*)\" email \"([^\"]*)\" password \"([^\"]*)\"$")
    public void iRegisterWithFirstnameLastnameEmailPassword(String firstname, String lastname,
                                                            String email, String password) throws BusinessException, SQLException {
        registration.registerOwner(firstname, lastname, email, password);
    }

    @Then("^the owner with firstname \"([^\"]*)\" lastname \"([^\"]*)\" email \"([^\"]*)\" password \"([^\"]*)\" should exist in the database$")
    public void theOwnerWithFirstnameLastnameEmailPasswordShouldExistInTheDatabase(String firstname, String lastname,
                                                          String email, String password) throws SQLException{
        Assert.assertEquals(DataAccess.getOwnerByEmail(email), new Owner(firstname, lastname, email, password));
    }

    @Then("^the owner with email \"([^\"]*)\" should not exist in the database$")
    public void theOwnerWithEmailShouldNotExistInTheDatabase(String email) throws Throwable {
        Assert.assertEquals(null, DataAccess.getOwnerByEmail(email));
    }

    @Then("^the owner with email \"([^\"]*)\" should exist in the database$")
    public void theOwnerWithEmailShouldExistInTheDatabase(String email) throws Throwable {
        Assert.assertNotEquals(null, DataAccess.getOwnerByEmail(email));
    }
    @Given("^I am connected to the online system$")
    public void iAmConnectedToTheOnlineSystem() throws SQLException {
        DataAccess.getConnection();
    }

    @When("^I have successfully registered as an owner$")
    public void iHaveSuccessfullyRegisteredAsAnOwner() {
        registration.registerOwner("Joe", "Blogg", "example@gmail.com", "passw0rd");
    }

    @Then("^A message \"([^\"]*)\" is displayed on the screen$")
    public void aConfirmationMessageIsDisplayedOnTheScreen(String message) {
        Assert.assertEquals(message, Output.printList.get(Output.printList.size() - 1));
    }

    @When("^I have unsuccessfully registered as an owner$")
    public void iHaveUnsuccessfullyRegisteredAsAnOwner() {
        registration.registerOwner("Joe123", "Blogg", "example@gmail.com", "passw0rd");
    }

    @Given("^The email \"([^\"]*)\" already exists in the database$")
    public void theEmailAlreadyExistsInTheDatabase(String email) {
        registration.registerOwner("Joe", "Blogg", email, "passw0rd");
    }
}
