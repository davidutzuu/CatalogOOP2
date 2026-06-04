package catalog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static Connection conexiune;
    private static final String URL = "jdbc:sqlite:catalog_db.sqlite";

    private DatabaseConnection() {}

    public static Connection getConexiune() {
        try {
            if (conexiune == null || conexiune.isClosed()) {
                conexiune = DriverManager.getConnection(URL);
                creazaTabele(conexiune);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Eroare conectare SQLite!");
        }
        return conexiune;
    }

    private static void creazaTabele(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS departament (id INTEGER PRIMARY KEY AUTOINCREMENT, nume TEXT NOT NULL)");
            stmt.execute("CREATE TABLE IF NOT EXISTS grupa (id INTEGER PRIMARY KEY AUTOINCREMENT, cod_grupa TEXT NOT NULL)");
            stmt.execute("CREATE TABLE IF NOT EXISTS adresa (id INTEGER PRIMARY KEY AUTOINCREMENT, oras TEXT, strada TEXT)");
            stmt.execute("CREATE TABLE IF NOT EXISTS materie (id INTEGER PRIMARY KEY AUTOINCREMENT, nume TEXT NOT NULL)");
        } catch (SQLException e) {
            System.out.println("Eroare creare tabele: " + e.getMessage());
        }
    }
}