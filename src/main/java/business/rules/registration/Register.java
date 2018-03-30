package business.rules.registration;

import services.DataAccess;
import utils.InputChecker;

public class Register {

    public void registerAsOwner(String firstname, String lastname, String email, String password) throws BusinessException{
        if (InputChecker.isNameOnlyChars(firstname) && InputChecker.isNameOnlyChars(lastname)
                && InputChecker.isUniqueEmail(email)) {
            DataAccess.insertIntoOwner(firstname, lastname, email, password);
        }
    }

    public void registerVehicle(String plate, String model, String make,
                                String manufactureDate, String fuelType, String vin,
                                String odometer, String regYear, String wofExpiry){

    }
}