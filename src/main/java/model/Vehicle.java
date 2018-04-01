package model;

public class Vehicle {

    private String plate;
    private String model;
    private String make;
    private String manufactureDate;
    private String fuelType;
    private String vin;
    private String odometer;
    private String regYear;
    private String wofExpiry;
    private String ownerID;

    /**
     * Constructor for a vehicle object
     * @param plate - plate number of the vehicle
     * @param model - model of the vehicle
     * @param make - make of the vehicle
     * @param manufactureDate - manufacture date of the vehicle
     * @param fuelType - fuel type of the vehicle (petrol, diesel, gas, electric, other)
     * @param vin - 17 character long vin number of the vehicle
     * @param odometer - current reading of the vehicles odometer
     * @param regYear - first registration year in New Zealand
     * @param wofExpiry - WoF expiry date
     * @param ownerID - email address of the owner who is registered to
     */
    public Vehicle(String plate, String model, String make,
                   String manufactureDate, String fuelType, String vin,
                   String odometer, String regYear, String wofExpiry, String ownerID) {
        this.plate = plate;
        this.make = make;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.fuelType = fuelType;
        this.vin = vin;
        this.odometer = odometer;
        this.regYear = regYear;
        this.wofExpiry = wofExpiry;
        this.ownerID = ownerID;
    }
    public String getOwnerID(){
        return this.ownerID;
    }
}
