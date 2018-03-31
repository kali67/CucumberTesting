package services;
import model.Owner;
import model.Vehicle;

import java.sql.*;

public class DataAccess {

    public static Connection getConnection(){
        Connection conn = null;
        String url = "jdbc:sqlite:db.sqlite";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage()); //TODO: pass to a MessageLogger
        }
        return conn;
    }

    public static void insertIntoOwner(String firstName, String lastName, String email, String password) throws SQLException {
        String sqlStatement = "insert into Owner (firstname, lastname, email, password) values (?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlStatement)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.executeUpdate();
        }

    }

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

    public static Vehicle getVehicleByPlate(String plate) throws SQLException{
        String sql = "select * from vehicle where plate = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, plate);
            return getVehicle(statement.executeQuery());
        }
    }

    public static Vehicle getVehicleByEmail(String email) throws SQLException {
        String sql = "select * from vehicle where ownerID = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            return getVehicle(statement.executeQuery());
        }
    }

    private static Vehicle getVehicle(ResultSet results) throws SQLException{
        if (results.next()) {
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
        return null;
    }

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

    public static void deleteAllOwner(){
        String sql  = "delete from owner";
        try (Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllVehicles(){
        String sql  = "delete from vehicle";
        try (Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
