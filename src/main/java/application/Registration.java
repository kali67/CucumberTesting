package application;

import BR.registration.BusinessException;
import BR.registration.RegisterBR;
import utils.Output;

import java.sql.SQLException;


public class Registration {

    public void registerOwner(String firstname, String lastname, String email, String password){
        RegisterBR registerBR = new RegisterBR();
        try {
            registerBR.registerAsOwner(firstname, lastname, email, password);
            Output.print("Successfully registered owner");
        } catch (BusinessException | SQLException e) {
            Output.print(e.getMessage());
        }
    }

    public void registerVehicle(String email, String plate, String model, String make,
                                       String manufactureDate, String fuelType, String vin,
                                       String odometer, String regYear, String wofExpiry){
        RegisterBR registerBR = new RegisterBR();
        try {
            registerBR.registerVehicle(email, plate, model, make, manufactureDate, fuelType, vin, odometer, regYear, wofExpiry);
            Output.print("Successfully registered vehicle");
        } catch (BusinessException e){
            Output.print(e.getMessage());
        } catch (SQLException e) {
            Output.print("Vehicle is already registered");
        }
    }
}
