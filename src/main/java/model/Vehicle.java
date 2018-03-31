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
