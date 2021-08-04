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
package dao;

import entity.User;

/**
 * This interface defines method used to retrieve information from database 
 * relating to <code>User</code> object
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */

public interface UserDAO {
    
    /**
     * Check user exist or not. The result is true if user exist, false if user 
     * does not exist
     *
     * @param username the username. It is a
     * <code>java.lang.String</code> object
     * @return true or false. It is a <code>java.lang.boolean</code> objects.
     * @throws java.lang.Exception
     */
    public boolean checkExitUser(String username) throws Exception;
    
    /**
     * Insert user object into User table. User can login after register successfully
     * 
     * @param user the user object. It is a <code>User</code> object
     * @throws java.lang.Exception
     */
    public void registerUser (User user) throws Exception;
    
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
    public User getUserLoggedIn(String username, String password) throws Exception;
     
}
