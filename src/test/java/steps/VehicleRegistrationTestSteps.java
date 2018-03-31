package steps;

import application.Registration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import services.DataAccess;

import java.sql.SQLException;

public class VehicleRegistrationTestSteps {
    private Registration registration = new Registration();

    @Given("^I am connected to the online system and owner with email \"([^\"]*)\" exists in the database$")
    public void iAmConnectedToTheOnlineSystemAndOwnerWithEmailExistsInTheDatabase(String email) {
        registration.registerOwner("Joe", "Bloggs", email, "passw0rd");
    }

    @When("^I register a vehicle with plate \"([^\"]*)\" and manufacture date \"([^\"]*)\" reg year \"([^\"]*)\" wof \"([^\"]*)\" for owner with email \"([^\"]*)\"$")
    public void iRegisterAVehicleWithPlateAndManufactureDateRegYearWofForOwnerWithEmail(String plate, String manufactDate, String regYear, String wof, String email){
        registration.registerVehicle(email, plate, "levin", "toyota", manufactDate,
                "petrol", "12345678912345678", "123122", regYear, wof);
    }

    @When("^I register a vehicle for owner with email \"([^\"]*)\"$")
    public void iRegisterAVehicleForOwnerWithEmail(String email) throws Throwable {
        registration.registerVehicle(email, "qwe123", "levin", "toyota", "12/12/1998",
                "petrol", "12345678912345678", "123122", "2018", "12/12/2018");
    }

    @Then("^the vehicle should now be registered to owner with email \"([^\"]*)\" in the database$")
    public void theVehicleShouldNowBeRegisteredToOwnerWithEmailInTheDatabase(String email) throws SQLException{
        Assert.assertNotEquals(null, DataAccess.getVehicleByEmail(email)); //will return null if no vehicle
    }


    @Then("^the vehicle with plate \"([^\"]*)\" is not in the database$")
    public void theVehicleWithPlateShouldNotBeEnteredIntoTheDatabase(String plate) {
       // Assert.assertNotEquals(null, DataAccess.getVehicleByPlate(plate));
    }

    @When("^I register a vehicle with plate \"([^\"]*)\" fuel type \"([^\"]*)\" for an owner with email \"([^\"]*)\"$")
    public void iRegisterAVehicleWithPlateFuelTypeForAnOwnerWithEmail(String plate, String fuelType, String email) {
        registration.registerVehicle(email, plate, "levin", "toyota", "12/12/2018",
                fuelType, "12345678912345678", "123122", "2018", "12/12/2018");
    }


    @Given("^I am connected to the online system and vehicle with plate \"([^\"]*)\" is registered to email \"([^\"]*)\"$")
    public void iAmConnectedToTheOnlineSystemAndVehicleWithPlateIsRegisteredToEmail(String plate, String email) {
        registration.registerOwner("Bob", "Jones", email, "passw0rd");
        registration.registerVehicle(email, plate, "levin", "toyota", "12/12/2018",
                "diesel", "12345678912345678", "123122", "2018", "12/12/2018");
    }


    @When("^I register a vehicle with plate \"([^\"]*)\" to an owner with email \"([^\"]*)\"$")
    public void iRegisterAVehicleWithPlateToAnOwnerWithEmail(String plate, String email) {
        registration.registerVehicle(email, plate, "levin", "toyota", "12/12/2018",
                "diesel", "12345678912345678", "123122", "2018", "12/12/2018");
    }

    @And("^The owner with email \"([^\"]*)\" has no registered vehicle with plate \"([^\"]*)\"$")
    public void theOwnerWithEmailHasNoRegisteredVehicleWithPlate(String email, String plate) throws SQLException {
        Assert.assertNotEquals(email, DataAccess.getVehicleByPlate(plate).getOwnerID());
    }
}
