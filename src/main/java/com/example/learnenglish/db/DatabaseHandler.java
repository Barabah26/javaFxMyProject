package com.example.learnenglish.db;

import com.example.learnenglish.User;
import com.example.learnenglish.Word;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);

        return dbConnection;
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_EMAIL + "," + Const.USER_PASSWORD + ")" + "VALUES(?,?)";

        try (Connection connection = getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

            preparedStatement.setString(1, user.getEmail());
            // Хешування паролю перед зберіганням
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(User user) {
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_EMAIL + "=?";
        boolean result = false;

        try (Connection connection = getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select)) {

            preparedStatement.setString(1, user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Порівняння хешів паролів
                String hashedPasswordFromDB = resultSet.getString(Const.USER_PASSWORD);
                String enteredPassword = user.getPassword();
                result = BCrypt.checkpw(enteredPassword, hashedPasswordFromDB);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getUser(User user) {
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_EMAIL + "=? AND " + Const.USER_PASSWORD + "=?";
        ResultSet resultSet = null;

        try (Connection connection = getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select)) {

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword()); // Хешую пароль перед порівнянням
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSet;
    }


    public List<User> retrieveUsers(User user) {
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_EMAIL + "=? AND " + Const.USER_PASSWORD + "=?";
        List<User> userList = new ArrayList<>();

        try (Connection connection = getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User retrievedUser = new User();
                retrievedUser.setEmail(resultSet.getString(Const.USER_EMAIL));
                retrievedUser.setPassword(resultSet.getString(Const.USER_PASSWORD));
                userList.add(retrievedUser);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }

        return userList;
    }

    public List<Word> getA1Words() {
        String selectA1 = "SELECT * FROM a1";
        List<Word> a1WordList = new ArrayList<>();

        try (Connection connection = getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectA1);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String wordsInEnglish = resultSet.getString("words_in_english");
                String translate = resultSet.getString("translate");

                Word word = new Word(wordsInEnglish, translate);
                a1WordList.add(word);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return a1WordList;
    }

    public List<Word> getA2Words() {
        String selectA1 = "SELECT * FROM a2";
        List<Word> a2WordList = new ArrayList<>();

        try (Connection connection = getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectA1);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String wordsInEnglish = resultSet.getString("words_in_english");
                String translate = resultSet.getString("translate");

                Word word = new Word(wordsInEnglish, translate);
                a2WordList.add(word);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return a2WordList;
    }

    public List<Word> getB1Words() {
        String selectA1 = "SELECT * FROM b1";
        List<Word> b1WordList = new ArrayList<>();

        try (Connection connection = getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectA1);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String wordsInEnglish = resultSet.getString("words_in_english");
                String translate = resultSet.getString("translate");

                Word word = new Word(wordsInEnglish, translate);
                b1WordList.add(word);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return b1WordList;
    }

    public List<Word> getB2Words() {
        String selectA1 = "SELECT * FROM b2";
        List<Word> b1WordList = new ArrayList<>();

        try (Connection connection = getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectA1);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String wordsInEnglish = resultSet.getString("words_in_english");
                String translate = resultSet.getString("translate");

                Word word = new Word(wordsInEnglish, translate);
                b1WordList.add(word);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return b1WordList;
    }


}
