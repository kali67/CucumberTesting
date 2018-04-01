package services;
import model.Owner;
import model.Vehicle;

import java.sql.*;

public class DataAccess {

    /**
     * Get the connection object to the database
     * @return Connection object
     */
    public static Connection getConnection(){
        Connection conn = null;
        String url = "jdbc:sqlite:db.sqlite";
        try {
            conn = DriverManager.getConnection(url); //get the connection to the specified url
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     *
     * @param firstName - first name of the owner
     * @param lastName - last name of the owner
     * @param email - email address of the owner
     * @param password - password of the owner
     * @throws SQLException - thrown if database integrity violated
     */
    public static void insertIntoOwner(String firstName, String lastName, String email, String password) throws SQLException {
        String sqlStatement = "insert into Owner (firstname, lastname, email, password) values (?,?,?,?)";
        try (Connection connection = getConnection(); //using java 8 try with resources
             PreparedStatement statement = connection.prepareStatement(sqlStatement)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.executeUpdate();
        }

    }

    /**
     * Insert vehicle with given values into the vehicles table
     * @param email - email address of the owner to register an vehicle for
     * @param plate - plate number of the vehicle
     * @param model - model of the vehicle
     * @param make - make of the vehicle
     * @param manufactureDate - manufacture date of the vehicle
     * @param fuelType - fuel type of the vehicle (petrol, diesel, gas, electric, other)
     * @param vin - 17 character long vin number of the vehicle
     * @param odometer - current reading of the vehicles odometer
     * @param regYear - first registration year in New Zealand
     * @param wofExpiry - WoF expiry date
     * @throws SQLException - thrown if database integrity violated
     */
    public static void insertIntoVehicle(String email, String plate, String model, String make,
                                         String manufactureDate, String fuelType, String vin,
                                         String odometer, String regYear, String wofExpiry) throws SQLException{
        String sqlStatement = "insert into vehicle (plate, model, make, manufactureDate, fuelType," +
                                                    "vin, odometer, firstRegistrationYear, wofExpiryDate, ownerID)" +
                                                    " values (?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlStatement)){
            statement.setString(1, plate);
            statement.setString(2, model);
            statement.setString(3, make);
            statement.setString(4, manufactureDate);
            statement.setString(5, fuelType);
            statement.setString(6, vin);
            statement.setString(7, odometer);
            statement.setString(8, regYear);
            statement.setString(9, wofExpiry);
            statement.setString(10, email);
            statement.executeUpdate();
        }

    }

    /**
     * Gets the vehicle object from the plate number given
     * @param plate - plate number to identify a vehicle
     * @return - a vehicle matching the plate number given
     * @throws SQLException - thrown if database integrity violated
     */
    public static Vehicle getVehicleByPlate(String plate) throws SQLException{
        String sql = "select * from vehicle where plate = ?";
        try (Connection connection = getConnection(); //java 8 try with resources
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, plate);
            return getVehicle(statement.executeQuery());
        }
    }

    /**
     *  Gets the vehicle object from the email address of the owner given
     * @param email - email address to identify an owner by
     * @return - vehicle registered to the owner given
     * @throws SQLException - thrown if database integrity violated
     */
    public static Vehicle getVehicleByEmail(String email) throws SQLException {
        String sql = "select * from vehicle where ownerID = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            return getVehicle(statement.executeQuery());
        }
    }

    /**
     * Returns the Vehicle object from the result set given
     * @param results - result set from a database query
     * @return Vehicle object from the result set given
     * @throws SQLException - thrown if database integrity violated
     */
    private static Vehicle getVehicle(ResultSet results) throws SQLException{
        if (results.next()) { // if there is any results in the result set
            return new Vehicle(results.getString("plate"),
                    results.getString("model"),
                    results.getString("make"),
                    results.getString("manufactureDate"),
                    results.getString("fuelType"),
                    results.getString("vin"),
                    results.getString("odometer"),
                    results.getString("firstRegistrationYear"),
                    results.getString("wofExpiryDate"),
                    results.getString("ownerID"));
        }
        return null; //if no results
    }

    /**
     *
     * @param email - email address of the owner to be looked up
     * @return Owner object from the db query
     * @throws SQLException - thrown if database integrity violated
     */
    public static Owner getOwnerByEmail(String email) throws SQLException{
        String sqlStatement = "select * from Owner where email = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlStatement)) {
            statement.setString(1, email);
            ResultSet results = statement.executeQuery();
            if (results.next()) {
                return new Owner(results.getString("firstname"),
                        results.getString("lastname"), results.getString("email"),
                        results.getString("password"));
            }
            return null;
        }
    }

    /**
     * Restores the database for testing
     */
    public static void restoreDB(){
        deleteAllVehicles();
        deleteAllOwners();
    }

    /**
     * Helper method to restore database, just deletes everything in owners table
     */
    private static void deleteAllOwners(){
        String sql  = "delete from owner";
        try (Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Helper method ot restore database, just deletes everything in the vehicle table
     */
    private static void deleteAllVehicles(){
        String sql  = "delete from vehicle";
        try (Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
