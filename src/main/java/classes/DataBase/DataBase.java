package classes.DataBase;

import classes.Account;
import classes.Currency;

import java.sql.*;

public class DataBase {
    public static void registration(String name, double balance, Currency currency, String pinCode) {
        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO users (name, balance, currency, pinCode) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, balance);
            preparedStatement.setString(3, currency.toString());
            preparedStatement.setString(4, pinCode);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static void checkConnection() {
        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected successfully");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void query(String query) {
        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeQuery(query);
            System.out.println("Successful request");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static String getBalance(String name) {
        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "root";
        String password = "root";
        String query = "SELECT balance FROM users WHERE name = '" + name + "'";

        String bal = null;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement Statement = connection.prepareStatement(query)) {
            ResultSet rs = Statement.executeQuery(query);
            while (rs.next()) {
                bal = String.valueOf(rs.getDouble("balance"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bal;
    }

    public static void setBalance(String name, double value) {
        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "root";
        String password = "root";
        String query = "UPDATE users SET balance = ? WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, value);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static double getBalanceFromDb(String name) {
        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "root";
        String password = "root";
        String query = "SELECT balance FROM users WHERE name = '" + name + "'";

        double balance = 0;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement Statement = connection.prepareStatement(query)) {
            ResultSet rs = Statement.executeQuery(query);
            while (rs.next()) {
                balance = rs.getDouble("balance");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return balance;
    }

    public static String getCurrency(String name) {
        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "root";
        String password = "root";
        String query = "SELECT currency FROM users WHERE name = '" + name + "'";

        String cur = null;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement Statement = connection.prepareStatement(query)) {
            ResultSet rs = Statement.executeQuery(query);
            while (rs.next()) {
                cur = rs.getString("currency");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cur;
    }

    public static boolean checkUser(String name) {
        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "root";
        String password = "root";
        boolean temp = false;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM users WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                temp = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return temp;
    }


    public static boolean checkPin(String name, String pin) {
        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "root";
        String password = "root";
        boolean temp = false;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM users WHERE name = ? AND pinCode = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pin);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                temp = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    public static void changePinFromDb(String name, String pin){
        String url = "jdbc:mysql://localhost:3306/atm";
        String user = "root";
        String password = "root";
        String query = "UPDATE users SET pinCode = ? WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, pin);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
