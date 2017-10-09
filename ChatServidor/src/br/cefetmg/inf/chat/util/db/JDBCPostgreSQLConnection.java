package br.cefetmg.inf.chat.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCPostgreSQLConnection implements br.cefetmg.inf.chat.util.db.ConnectionFactory{
    
    private final static String dbDriver = "org.postgresql.Driver";
    private final static String dbURL = "jdbc:postgresql://localhost:5432/Chat";
    private final static String user = "postgres";
    private final static String pass = "admin";
    
    public JDBCPostgreSQLConnection() {
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL, user, pass);
    }    
    
    public static void main(String[] args){
        try {
            ConnectionFactory c = new JDBCPostgreSQLConnection();
            c.getConnection();
        } catch (Exception e) {
        }
    }

}
