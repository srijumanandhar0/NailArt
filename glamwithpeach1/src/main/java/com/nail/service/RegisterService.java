package com.nail.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nail.config.DbConfig;
import com.nail.model.UserModel;

public class RegisterService {

    private Connection dbConn;

    public RegisterService() throws Exception {
        try {
            this.dbConn = DbConfig.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Registers a new user in the database using UserModel.
     *
     * @param user the UserModel object containing user details
     * @return Boolean indicating success or failure
     */
    public Boolean addUser(UserModel user) {
        if (dbConn == null) {
            System.err.println("Database connection is not available.");
            return null;
        }

        String insertQuery = "INSERT INTO `user` (user_name, country, email, password) VALUES (?, ?, ?, ?)";



        try (PreparedStatement stmt = dbConn.prepareStatement(insertQuery)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getCountry());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword()); // No encryption

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Error during user registration: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
