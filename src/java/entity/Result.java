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

import java.util.Date;

/**
 * This class contain entities of <code>Result</code> object. Contain methods which use to get
 * and set all of attributes. 2 Constructor with parameter and no parameter
 * <p>
 * Bugs: None   
 *
 * @author DINH PHUONG THAO
 */

public class Result {
    private int id;
    private int userID;
    private double mark;
    private Date start;
    private Date end;
    private boolean passed;

    /**
     * Used to initialize Result with no parameter
     */
    public Result() {
    }

    /**
     * Used to initialize <code>Result</code> with its properties as parameters
     *
     * @param userID the id of User. It is an int number
     * @param mark the mark of Result. It is a double number
     * @param start the start time of test. It is <code>java.util.Date</code>
     * @param end the end time of test. It is <code>java.util.Date</code>
     * @param passed the type of Result. It is a <code>java.lang.boolean</code>
     * object
     */   
    public Result(int userID, double mark, Date start, Date end, boolean passed) {
        this.userID = userID;
        this.mark = mark;
        this.start = start;
        this.end = end;
        this.passed = passed;
    }

    /**
     * Get value from id attribute of <code>Result</code> object
     *
     * @return id of object
     */
    public int getId() {
        return id;
    }

    /**
     * Set value for id attribute of <code>Result</code> object
     *
     * @param id the id of Result. It is an int number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from userID attribute of <code>Result</code> object
     *
     * @return userID of object
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Set value for id attribute of <code>User</code> object
     *
     * @param userID the id of User. It is an int number
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Get value from mark attribute of <code>Result</code> object
     *
     * @return mark of object
     */
    public double getMark() {
        return mark;
    }

    /**
     * Set value for mark attribute of <code>Result</code> object
     *
     * @param mark the id of Result. It is a double number
     */
    public void setMark(double mark) {
        this.mark = mark;
    }

    /**
     * Get value from start attribute of <code>Result</code> object
     *
     * @return start of object
     */
    public Date getStart() {
        return start;
    }

    /**
     * Set value for start attribute of <code>Result</code> object
     *
     * @param start the start time of test. 
     * It is a <code>java.util.Date</code> object
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * Get value from "end" attribute of <code>Result</code> object
     *
     * @return end of object
     */
    public Date getEnd() {
        return end;
    }

    /**
     * Set value for "end" attribute of <code>Result</code> object
     *
     * @param end the start time of test. 
     * It is a <code>java.util.Date</code> object
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * Get value from passed attribute of <code>Result</code> object
     *
     * @return passed of object
     */
    public boolean isPassed() {
        return passed;
    }

    /**
     * Set value for passed attribute of <code>Result</code> object
     *
     * @param passed the type of Result. It is a
     * <code>java.lang.boolean</code> object
     */
    public void setPassed(boolean passed) {
        this.passed = passed;
    }

}
