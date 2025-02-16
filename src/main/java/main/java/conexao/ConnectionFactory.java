/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class ConnectionFactory {
    private static final String PROPERTIES_FILE = "main.conexao.db.properties";

    public static Connection getConnection() {
        try (InputStream input = ConnectionFactory.class.getResourceAsStream(PROPERTIES_FILE)) {
            Properties properties = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find " + PROPERTIES_FILE);
                return null;
            }
            properties.load(input);
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
