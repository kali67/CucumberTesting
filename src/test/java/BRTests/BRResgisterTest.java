package BRTests;

import business.rules.BRRegistrationException;
import business.rules.BRRegister;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import services.DataAccess;

import java.sql.SQLException;

public class BRResgisterTest {

    private BRRegister register = new BRRegister();

    @BeforeClass
    public static void setUp() throws SQLException{
        DataAccess.restoreDB();
        DataAccess.insertIntoOwner("Bob", "Jones", "example@yahoo.com", "passw0rd");
    }

    @Test
    public void registerAsOwnerTestValid(){
        try {
            register.registerAsOwner("Joe", "Bloggs", "example@email.com", "passsw0rd");
        } catch (BRRegistrationException | SQLException e) {
            Assert.fail();
        }
    }

    @Test(expected = BRRegistrationException.class)
    public void registerAsOwnerTestEmailAlreadyRegistered() throws BRRegistrationException, SQLException{
        register.registerAsOwner("Joe", "Bloggs", "example@email.com", "passsw0rd");
    }

    @Test(expected = BRRegistrationException.class)
    public void registerVehicleInvalidPlateLength() throws BRRegistrationException, SQLException{
        register.registerVehicle("example@yahoo.com", "ABC12324", "Toyota",
                "Levin", "12.12.2000", "petrol", "12345678912345678",
                "123121", "2018", "12-12-2018");
    }

    @Test
    public void registerVehicleTestValid(){
        try {
            register.registerVehicle("example@yahoo.com", "ABC123", "Toyota",
                    "Levin", "12.12.2000", "petrol", "12345678912345678",
                    "123121", "2018", "12-12-2018");
        } catch (BRRegistrationException | SQLException e) {
            Assert.fail();
        }
    }

    @Test(expected = SQLException.class) //SQLITE_CONSTRAINT_PRIMARYKEY
    public void registerVehicleAlreadyResistered() throws BRRegistrationException, SQLException{
        register.registerVehicle("example@email.com", "ABC123", "Toyota",
                "Levin", "12.12.2000", "petrol", "12345678912345678",
                "123121", "2018", "12-12-2018");
    }

    @Test(expected = BRRegistrationException.class)
    public void registerVehicleEmailNotResistered() throws BRRegistrationException, SQLException{
        register.registerVehicle("notRegisteredEmail@email.com", "ABC123", "Toyota",
                "Levin", "12.12.2000", "petrol", "12345678912345678",
                "123121", "2018", "12-12-2018");
    }
}
