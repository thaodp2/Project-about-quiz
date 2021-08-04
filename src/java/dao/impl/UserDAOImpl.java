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
package dao.impl;

import context.DBContext;
import dao.UserDAO;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class has methods for retrieving data from User tables in database.
 * The method will return an object of the class <code>java.lang.Exception</code>
 * when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */
public class UserDAOImpl extends DBContext implements UserDAO{
    
    /**
     * Check user exist. User based on userName will be returned. The
     * result is true if user exist, false if user does not exist
     *
     * @param username the username. It is a
     * <code>java.lang.String</code> object
     * @return true or false. It is a <code>java.lang.boolean</code> objects.
     * @throws java.lang.Exception
     */
    @Override
    public boolean checkExitUser(String username) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT username FROM  [user] where username = ?";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return false;
    }
    
    /**
     * Insert user object into User table. User can login after register successfully
     *
     * @param user the user object. It is a <code>User</code> object
     * @throws java.lang.Exception
     */
    @Override
    public void registerUser (User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        try {
            String sql = "INSERT INTO [user]([username],[password],[isTeacher],"
                    + "[email]) VALUES (?,?,?,?)";           
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, user.getUsername());
            ps.setObject(2, user.getPassword());
            ps.setObject(3, user.isIsTeacher());
            ps.setObject(4, user.getEmail());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }
    
    /**
     * Get user just logged in. User based on userName and password will be returned. The
     * result is a <code>User</code> objects with ID, userName, password,
     * type, email
     *
     * @param username the user name. It is a
     * <code>java.lang.String</code> object
     * @param password the password. It is a
     * <code>java.lang.String</code> object
     * @return a <code>User</code> objects.
     * @throws java.lang.Exception
     */
    @Override
    public User getUserLoggedIn(String username, String password) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM [user] where [username]= ? and [password] = ?";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setIsTeacher(rs.getBoolean("isTeacher"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }
}
