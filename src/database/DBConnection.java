package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection = null;

    public Connection getDBConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/dvdrental", "postgres", "toor");
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion à la base de données");
            ex.printStackTrace();
        }

        return connection;
    }
}
