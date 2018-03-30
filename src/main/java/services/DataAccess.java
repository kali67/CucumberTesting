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
            System.out.println(e.getMessage()); //TODO: pass to a logger
        }
        return conn;
    }


    public static void insertIntoOwner(String firstName, String lastName, String email, String password) {
        String sqlStatement = "insert into Owner (firstname, lastname, email, password) values (?,?,?,?)";
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, firstName);
            statement.setString(2,lastName);
            statement.setString(3,email);
            statement.setString(4,password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Owner getOwnerByEmail(String email){
        String sqlStatement = "select * from Owner where email = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, email);
            ResultSet results = statement.executeQuery();
            if (results.next()) {
                return new Owner(results.getString("firstname"),
                        results.getString("lastname"), results.getString("email"),
                        results.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteAllOwner(){
        String sql  = "delete from owner";
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
