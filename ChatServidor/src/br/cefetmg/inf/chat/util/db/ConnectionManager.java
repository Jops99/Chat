package br.cefetmg.inf.chat.util.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Alice
 */
public class ConnectionManager {

    private static ConnectionManager CM;
    private static ConnectionFactory CR;

    private ConnectionManager() {
        ConnectionManager.CR = (ConnectionFactory) new JDBCPostgreSQLConnection();
    }

    public static ConnectionManager getInstance() {
        if (CM == null) {
            CM = new ConnectionManager();
        }

        return CM;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        return ConnectionManager.CR.getConnection();
    }
}
