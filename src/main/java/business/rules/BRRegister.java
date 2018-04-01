package business.rules;

import services.DataAccess;
import utils.Input;

import java.sql.SQLException;

public class BRRegister {

    /**
     *  BR layer registration for an owner, contains the rules for registration of an owner,
     *  owner is added to the database if passed valid values
     * @param firstname - first name of the owner
     * @param lastname - last name of the owner
     * @param email - email address of the owner
     * @param password - password of the owner
     * @throws BRRegistrationException - thrown if invalid inputs are given
     * @throws SQLException - thrown if database integrity violated
     */
    public void registerAsOwner(String firstname, String lastname, String email,
                                String password) throws BRRegistrationException, SQLException { //throws exceptions up to application layer

        if (Input.isNameOnlyChars(firstname) && Input.isNameOnlyChars(lastname)) { // check name validity
            if (!isRegisteredEmail(email)){ // check if email is not already registered
                DataAccess.insertIntoOwner(firstname, lastname, email, password); // insert into databse
            } else {
                throw new BRRegistrationException("Email address is already registered");
            }
        }
    }


    /**
     * BR layer register vehicle, adds a new vehicle to the database with the given attributes
     * @param email - email address of the owner to register an vehicle for
     * @param plate - plate number of the vehicle
     * @param model - model of the vehicle
     * @param make - make of the vehicle
     * @param manufactureDate - manufacture date of the vehicle, nullable
     * @param fuelType - fuel type of the vehicle (petrol, diesel, gas, electric, other), nullable
     * @param vin - 17 character long vin number of the vehicle, nullable
     * @param odometer - current reading of the vehicles odometer, nullable
     * @param regYear - first registration year in New Zealand, nullable
     * @param wofExpiry - WoF expiry date, nullable
     * @throws BRRegistrationException - thrown if invalid inputs are given
     * @throws SQLException - thrown if database integrity violated
     */
    public void registerVehicle(String email, String plate, String model, String make,
                                String manufactureDate, String fuelType, String vin,
                                String odometer, String regYear, String wofExpiry) throws BRRegistrationException, SQLException{

        if (isRegisteredEmail(email)){ // check if email given is registered
            if (Input.isCorrectDateFormat(manufactureDate) && Input.isYear(regYear) //check inputs from user
                    && Input.isCorrectDateFormat(wofExpiry) && Input.isAFuel(fuelType) && Input.isNameOnlyChars(model)
                    && Input.isNameOnlyChars(make) && Input.isValidPlate(plate) && Input.isValidVin(vin)) {

                DataAccess.insertIntoVehicle(email, plate, model, make, manufactureDate,
                        fuelType, vin, odometer, regYear, wofExpiry); //insert into the database
            }
        } else {
            throw new BRRegistrationException("Email address is not a registered email");
        }
    }


    /**
     *  Checks a given email to see if it is registered within the database
     * @param email - email address
     * @return boolean - true is email address is registered in the database
     * @throws SQLException - thrown if database integrity violated
     */
    private boolean isRegisteredEmail(String email) throws SQLException{
        return DataAccess.getOwnerByEmail(email) != null; //return true if there is existing email registered
    }
}