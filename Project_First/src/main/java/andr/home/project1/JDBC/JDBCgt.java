package andr.home.project1.JDBC;

import java.sql.*;

public class JDBCgt {

    private static final String URL = "jdbc:postgresql://172.17.0.2:5432/test_db";
    private static final String USERNAME = "cursor";
    private static final String PASSWORD = "secret_password";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  users");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Username " + resultSet.getString(2) + " LastName " + resultSet.getString(3) + " Age " + resultSet.getString(4));
            }
                /*
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO users(id,first_name,last_name,age) VALUES (32,'Gklo','Gder',10000)");;
                    preparedStatement.executeUpdate();*/
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
