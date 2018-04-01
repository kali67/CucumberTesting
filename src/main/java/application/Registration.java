package application;

import business.rules.BRRegistrationException;
import business.rules.BRRegister;
import utils.Output;

import java.sql.SQLException;


public class Registration {

    /**
     * Application layer register. Registers an owner and outputs actions to screen.
     * Possible exceptions thrown are BRRegister and SQLException, these are caught and printed to the screen
     * @param firstname - first name of the owner
     * @param lastname - last name of the owner
     * @param email - email address of the owner
     * @param password - password of the owner
     */
    public void registerOwner(String firstname, String lastname, String email, String password){
        BRRegister BRRegister = new BRRegister();
        try {
            BRRegister.registerAsOwner(firstname, lastname, email, password);
            Output.print("Successfully registered owner"); //redirected sys.out
        } catch (BRRegistrationException | SQLException e) {
            Output.print(e.getMessage());
        }
    }

    /**
     * Register a vehicle for a given owners email address
     *
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
     */
    public void registerVehicle(String email, String plate, String model, String make,
                                       String manufactureDate, String fuelType, String vin,
                                       String odometer, String regYear, String wofExpiry){
        BRRegister BRRegister = new BRRegister();
        try {
            BRRegister.registerVehicle(email, plate, model, make, manufactureDate, fuelType, vin, odometer, regYear, wofExpiry);
            Output.print("Successfully registered vehicle");
        } catch (BRRegistrationException e){
            Output.print(e.getMessage());
        } catch (SQLException e) {
            Output.print("Vehicle is already registered");
        }
    }
}
