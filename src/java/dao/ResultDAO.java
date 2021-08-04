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

import entity.Result;

/**
 * This interface defines method used to retrieve information from database 
 * relating to <code>Result</code> object
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */

public interface ResultDAO {
    
    /**
     * Insert result object into Result table. After taking the quiz, the 
     * results will be saved in Resutl table in database. 
     *
     * @param result the result object. It is a <code>Result</code> object
     * @throws java.lang.Exception
     */
    public void addResult (Result result) throws Exception;
}
