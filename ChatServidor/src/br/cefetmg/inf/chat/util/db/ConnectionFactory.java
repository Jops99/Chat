package br.cefetmg.inf.chat.util.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Alice
 */
public interface ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException, SQLException;
}
