package business.rules.registration;

import services.DataAccess;
import utils.InputChecker;

import java.sql.SQLException;

public class Register {

    public void registerAsOwner(String firstname, String lastname, String email,
                                String password) throws BusinessException, SQLException {

        if (InputChecker.isNameOnlyChars(firstname) && InputChecker.isNameOnlyChars(lastname)) {
            if (!isRegisteredEmail(email)){
                DataAccess.insertIntoOwner(firstname, lastname, email, password);
            } else {
                throw new BusinessException("Email is already registered");
            }
        }
    }

    public void registerVehicle(String email, String plate, String model, String make,
                                String manufactureDate, String fuelType, String vin,
                                String odometer, String regYear, String wofExpiry) throws BusinessException, SQLException{

        if (isRegisteredEmail(email)){
            if (InputChecker.isCorrectDateFormat(manufactureDate) && InputChecker.isCorrectDateFormat(regYear)
                    && InputChecker.isCorrectDateFormat(wofExpiry)) {
                DataAccess.insertIntoVehicle(email, plate, model, make, manufactureDate, fuelType, vin, odometer, regYear, wofExpiry);
            }
        }
        else {
            throw new BusinessException("Email address is not a registered email");
        }
    }

    private boolean isRegisteredEmail(String email) throws SQLException{
        return DataAccess.getOwnerByEmail(email) != null;
    }
}