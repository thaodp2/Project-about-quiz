/**
 * Copyright(C) 2021, DINH PHUONG THAO
 * J3.L.P0001
 * Online Quiz
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-21      1.0                 THAODP           First Implement
 * 2021-07-21      2.0                 THAODP           Second Implement
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Connect with the database Close all of connection
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */
public class DBContext {

    private InitialContext initial;
    private Context context;
    private String serverName;
    private String dbName;
    private String portNumber;
    private String userName;
    private String password;

    /**
     * To get value from context file
     *
     * @throw NamingException
     */
    public DBContext() {
        try {
            initial = new InitialContext();
            Object obj = initial.lookup("java:comp/env");
            context = (Context) obj;
            serverName = context.lookup("serverName").toString();
            dbName = context.lookup("dbName").toString();
            portNumber = context.lookup("portNumber").toString();
            userName = context.lookup("username").toString();
            password = context.lookup("password").toString();
        } catch (NamingException e) {
        }
    }

    /**
     * To connect with the database
     *
     * @return a connection to given database URL
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userName, password);
    }

    /**
     * Close ResultSet
     *
     * @param rs the ResultSet. It is a <code>java.sql.ResultSet</code> object
     * @throws SQLException
     */
    public void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * Close Prepared Statement
     *
     * @param ps the PreparedStatement. It is a
     * <code>java.sql.PreparedStatement</code> object
     * @throws SQLException
     */
    public void closePreparedStatement(PreparedStatement ps) throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    /**
     * Close Connection
     *
     * @param con the Connection. It is a <code>java.sql.Connection</code>
     * object
     * @throws SQLException
     */
    public void closeConnection(Connection con) throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

}
