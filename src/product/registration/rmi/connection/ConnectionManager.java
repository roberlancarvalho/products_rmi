package product.registration.rmi.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author roberlan-carvalho
 */
public class ConnectionManager {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/ap2";
    private static final String USER = "postgres";
    private static final String PASSWORD = "banco123";

    private Connection connection;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("######################### Classe do Driver não encontrada #########################");
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.err.println("######################### Erro ao retornar conexão #########################");
        }
        return null;
    }

}
