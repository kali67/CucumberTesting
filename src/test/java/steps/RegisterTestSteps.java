package steps;

import business.rules.registration.BusinessException;
import business.rules.registration.Register;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Owner;
import org.junit.Assert;
import services.DataAccess;

import java.sql.SQLException;

public class RegisterTestSteps {

    private Register register = new Register();

    @Given("^I am connected to the online system And the owner does not yet exist$")
    public void iAmConnectedToTheOnlineSystemAndTheOwnerDoesNotYetExist() throws SQLException {
        DataAccess.getConnection();
    }

    @When("^I register with firstname \"([^\"]*)\" lastname \"([^\"]*)\" email \"([^\"]*)\" password \"([^\"]*)\"$")
    public void iRegisterWithFirstnameLastnameEmailPassword(String firstname, String lastname,
                                                            String email, String password) throws BusinessException {
        register.registerAsOwner(firstname, lastname, email, password);
    }

    @Then("^the owner with firstname \"([^\"]*)\" lastname \"([^\"]*)\" email \"([^\"]*)\" password \"([^\"]*)\" should exist in the database$")
    public void theOwnerWithFirstnameLastnameEmailPasswordShouldExistInTheDatabase(String firstname, String lastname,
                                                          String email, String password){
        Assert.assertEquals(DataAccess.getOwnerByEmail(email), new Owner(firstname, lastname, email, password));
    }
}
