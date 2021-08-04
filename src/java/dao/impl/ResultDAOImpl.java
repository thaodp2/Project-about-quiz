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
import dao.ResultDAO;
import entity.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class has methods for retrieving data from Result tables in database.
 * The method will return an object of the class <code> java.lang.Exception</code>
 * when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */
public class ResultDAOImpl extends DBContext implements ResultDAO{
    
    /**
     * Insert result object into Result table. After taking the quiz, the 
     * results will be saved in Resutl table in database.
     *
     * @param result the result object. It is a <code>Result</code> object
     * @throws java.lang.Exception
     */
    @Override
    public void addResult (Result result) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "insert into resultTest(uId, mark, startTime, "
                    + "endTime, isPassed) values(?, ?, ?, ?, ?)";           
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, result.getUserID());
            ps.setObject(2, result.getMark());
            ps.setObject(3, new java.sql.Timestamp(result.getStart().getTime()));            
            ps.setObject(4, new java.sql.Timestamp(result.getEnd().getTime()));
            ps.setObject(5, result.isPassed());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }
  
}
