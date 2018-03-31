package services;
import model.Owner;

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

    private static void insertIntoOwns(Connection connection, String email, String plate) throws SQLException {
        String sql = "insert into owns (ownerID, vehicleID) values (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, plate);
            statement.executeUpdate();
        }
    }

    public static void insertIntoVehicle(String email, String plate, String model, String make,
                                         String manufactureDate, String fuelType, String vin,
                                         String odometer, String regYear, String wofExpiry) throws SQLException{
        String sqlStatement = "insert into vehicle (plate, model, make, manufactureDate, fuelType," +
                                                    "vin, odometer, firstRegistrationYear, wofExpiryDate)" +
                                                    " values (?,?,?,?,?,?,?,?,?)";

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
            statement.executeUpdate();
            insertIntoOwns(connection, email, plate);
        }

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

}
