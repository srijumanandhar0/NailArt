package com.nail.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.nail.config.DbConfig;
import com.nail.model.UserModel;

public class LoginService {

    private Connection dbConn;

    public LoginService() {
        try {
            this.dbConn = DbConfig.getConnection();
        } catch (Exception ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public boolean validateUser(UserModel user) {
        if (dbConn == null) {
            System.err.println("Database connection is not available.");
            return false;
        }

        // SQL query to check if user with provided email and password exists
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        System.out.println("Query: " + query);
        System.out.println("Email: " + user.getEmail() + ", Password: " + user.getPassword());


        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword()); // Assuming no password encryption

            ResultSet result = stmt.executeQuery();

            // If a matching user is found, return true (valid login)
            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error during user login: " + e.getMessage());
            e.printStackTrace();
        }

        // Return false if no matching record is found
        return false;
    }
}
