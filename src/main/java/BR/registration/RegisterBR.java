package BR.registration;

import services.DataAccess;
import utils.Input;

import java.sql.SQLException;

public class RegisterBR {

    public void registerAsOwner(String firstname, String lastname, String email,
                                String password) throws BusinessException, SQLException {

        if (Input.isNameOnlyChars(firstname) && Input.isNameOnlyChars(lastname)) {
            if (!isRegisteredEmail(email)){
                DataAccess.insertIntoOwner(firstname, lastname, email, password);
            } else {
                throw new BusinessException("Email address is already registered");
            }
        }
    }

    public void registerVehicle(String email, String plate, String model, String make,
                                String manufactureDate, String fuelType, String vin,
                                String odometer, String regYear, String wofExpiry) throws BusinessException, SQLException{

        if (isRegisteredEmail(email)){
            if (Input.isCorrectDateFormat(manufactureDate) && Input.isYear(regYear)
                    && Input.isCorrectDateFormat(wofExpiry) && Input.isAFuel(fuelType) && Input.isNameOnlyChars(model)
                    && Input.isNameOnlyChars(make) && Input.isValidPlate(plate) && Input.isValidVin(vin)) {
                DataAccess.insertIntoVehicle(email, plate, model, make, manufactureDate, fuelType, vin, odometer, regYear, wofExpiry);
            }
        } else {
            throw new BusinessException("Email address is not a registered email");
        }
    }

    private boolean isRegisteredEmail(String email) throws SQLException{
        return DataAccess.getOwnerByEmail(email) != null;
    }
}