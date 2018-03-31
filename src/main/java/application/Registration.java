package application;

import business.rules.registration.BusinessException;
import business.rules.registration.Register;
import utils.Output;

import java.sql.SQLException;


public class Registration {

    public void registerOwner(String firstname, String lastname, String email, String password){
        Register register = new Register();
        try {
            register.registerAsOwner(firstname, lastname, email, password);
            Output.print("Successfully registered owner");
        } catch (BusinessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void registerVehicle(String email, String plate, String model, String make,
                                       String manufactureDate, String fuelType, String vin,
                                       String odometer, String regYear, String wofExpiry){
        Register register = new Register();
        try {
            register.registerVehicle(email, plate, model, make, manufactureDate, fuelType, vin, odometer, regYear, wofExpiry);
            Output.print("Successfully registered vehicle");
        } catch (BusinessException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
