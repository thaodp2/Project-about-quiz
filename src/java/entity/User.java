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
package entity;

/**
 * This class contain entities of <code>User</code> object. Contain methods 
 * which use to get and set all of attributes. 2 Constructor with parameter and 
 * no parameter
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */
public class User {

    private int id;
    private String username;
    private String password;
    private boolean isTeacher;
    private String email;

    /**
     * Used to initialize <code>User</code> with no parameter
     */
    public User() {
    }

    /**
     * Constructor has parameters used to initialize an object with information
     * passed in Parameters that need to be passed include username, password,
     * isTeacher, email
     *
     * @param username the userName of User. It is a
     * <code>java.lang.String</code> object
     * @param password the password of User. It is a
     * <code>java.lang.String</code> object
     * @param isTeacher the type account of User. It is a
     * <code>java.lang.boolean</code>
     * @param email the email of User. It is a <code>java.lang.String</code>
     * object
     */
    public User(String username, String password, boolean isTeacher, String email) {
        this.username = username;
        this.password = password;
        this.isTeacher = isTeacher;
        this.email = email;
    }

    /**
     * Get value from username attribute of <code>User</code> object
     *
     * @return userName of object
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set value for username attribute of <code>User</code> object
     *
     * @param username the username of User. It is a
     * <code>java.lang.String</code> object
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get value from password attribute of <code>User</code> object
     *
     * @return password of object
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set value for password attribute of <code>User</code> object
     *
     * @param password the password of User. It is a
     * <code>java.lang.String</code> object
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get value from isTeacher attribute of <code>User</code> object
     *
     * @return isTeacher of object
     */
    public boolean isIsTeacher() {
        return isTeacher;
    }

    /**
     * Set value for isTeacher attribute of <code>User</code> object
     *
     * @param isTeacher the type of User. It is a
     * <code>java.lang.boolean</code> object
     */
    public void setIsTeacher(boolean isTeacher) {
        this.isTeacher = isTeacher;
    }

    /**
     * Get value from email attribute of <code>User</code> object
     *
     * @return email of object
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value for email attribute of <code>User</code> object
     *
     * @param email the email of User. It is a
     * <code>java.lang.String</code> object
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Get value from id attribute of <code>User</code> object
     *
     * @return id of object
     */
    public int getId() {
        return id;
    }
   
    /**
     * Set value for id attribute of <code>User</code> object
     *
     * @param id the id of User. It is an int number
     */
    public void setId(int id) {
        this.id = id;
    }

}
