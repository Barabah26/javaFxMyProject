package com.example.learnenglish;

import org.mindrot.jbcrypt.BCrypt;


public class User {

    private int id;
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {

    }
    public static String hashPassword(String password) {
        // Реалізуйте логіку хешування паролю тут
        // Наприклад, використовуйте BCrypt для хешування
        // Переконайтеся, що ви включили залежність для бібліотеки BCrypt у вашому проекті
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
