package team4.tictactoe.backend.controllers.auth;
import team4.tictactoe.backend.Server;
import team4.tictactoe.backend.config.RequestFormatter;
import team4.tictactoe.backend.models.Login;
import team4.tictactoe.backend.models.NewUser;
import team4.tictactoe.backend.models.User;

import java.sql.*;
import java.util.ArrayList;

public class AuthController {
    public static String login(Login login) throws SQLException {
        Connection connection = Server.getConnection();
        String query = "SELECT id, password FROM users WHERE username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, login.getUsername());
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = 0;
        String password;
        String response;
        ArrayList<String> errors = new ArrayList<>();
        if (resultSet.next()) {
            id = resultSet.getInt("id");
            password = resultSet.getString("password");
            resultSet.close();
            preparedStatement.close();
            if (password.equals(login.getPassword())) {
                User user = getUser(id);
                response = RequestFormatter.formatMessage(user, "login", true);
            } else {
                errors.add("Invalid credentials");
                response = RequestFormatter.formatMessage(errors, "login", false);
            }
        } else {
            resultSet.close();
            preparedStatement.close();
            errors.add("User not found");
            response = RequestFormatter.formatMessage(errors, "login", false);
        }
        return response;

    }

    public static String register(NewUser newUser) {
        Connection connection = Server.getConnection();
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        String response = "";
        ArrayList<String> errors = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, newUser.getUsername());
            preparedStatement.setString(2, newUser.getPassword());
            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    User user = getUser(id);
                    response = RequestFormatter.formatMessage(user, "register", true);
                }
            } else {
                errors.add("Failed to register");
                errors.add("User already exists");
                response = RequestFormatter.formatMessage(errors, "register", false);
            }
        } catch (SQLException e) {
            errors.add("User already exists");
            response = RequestFormatter.formatMessage(errors, "register", false);
        }
        return response;
    }
    private static User getUser(int id) throws SQLException {
        Connection connection = Server.getConnection();
        String query = "SELECT * FROM users WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        User user = new User();
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user.setName(resultSet.getString("name"));
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPoints(resultSet.getInt("score"));
        }
        resultSet.close();
        preparedStatement.close();
        query = "UPDATE users SET status='ONLINE' WHERE id=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        return user;
    }
}
