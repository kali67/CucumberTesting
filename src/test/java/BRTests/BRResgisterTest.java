package BRTests;

import BR.registration.BusinessException;
import BR.registration.RegisterBR;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import services.DataAccess;

import java.sql.SQLException;

public class BRResgisterTest {

    private RegisterBR register = new RegisterBR();

    @BeforeClass
    public static void setUp() throws SQLException{
        DataAccess.deleteAllOwner();
        DataAccess.deleteAllVehicles();
        DataAccess.insertIntoOwner("Bob", "Jones", "example@yahoo.com", "passw0rd");
    }

    @Test
    public void registerAsOwnerTestValid(){
        try {
            register.registerAsOwner("Joe", "Bloggs", "example@email.com", "passsw0rd");
        } catch (BusinessException | SQLException e) {
            Assert.fail();
        }
    }

    @Test(expected = BusinessException.class)
    public void registerAsOwnerTestEmailAlreadyRegistered() throws BusinessException, SQLException{
        register.registerAsOwner("Joe", "Bloggs", "example@email.com", "passsw0rd");
    }

    @Test(expected = BusinessException.class)
    public void registerVehicleInvalidPlateLength() throws BusinessException, SQLException{
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
        } catch (BusinessException | SQLException e) {
            Assert.fail();
        }
    }

    @Test(expected = SQLException.class) //SQLITE_CONSTRAINT_PRIMARYKEY
    public void registerVehicleAlreadyResistered() throws BusinessException, SQLException{
        register.registerVehicle("example@email.com", "ABC123", "Toyota",
                "Levin", "12.12.2000", "petrol", "12345678912345678",
                "123121", "2018", "12-12-2018");
    }

    @Test(expected = BusinessException.class)
    public void registerVehicleEmailNotResistered() throws BusinessException, SQLException{
        register.registerVehicle("notRegisteredEmail@email.com", "ABC123", "Toyota",
                "Levin", "12.12.2000", "petrol", "12345678912345678",
                "123121", "2018", "12-12-2018");
    }
}
