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
import dao.AnswerDAO;
import entity.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * This class has methods for retrieving data from Answer tables in database.
 * The method will return an object of the class <code> java.lang.Exception</code>
 * when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */

public class AnswerDAOImpl extends DBContext implements AnswerDAO{
    
    /**
     * Get list answer from answer table in database. All the answer matched 
     * with quesId will be returned. The result contains a list of 
     * <code>entity.Answer</code> objects with id, questionId, answer, isTrue
     *
     * @param quesId the id of question. It is an int number
     * @return a list of <code>Answer</code> objects. It is a 
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    @Override
    public List<Answer> getAnswerByQuestionId(int quesId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Answer> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [answer] where questionId = ?";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, quesId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Answer aswer = new Answer();
                aswer.setId(rs.getInt("id"));
                aswer.setQuestionId(rs.getInt("questionId"));
                aswer.setAnswer(rs.getString("answer"));
                aswer.setIsTrue(rs.getBoolean("isTrue"));
                list.add(aswer);
            }
            return list;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }
    
    /**
     * Get total of true answer from answer table in database. Number of true 
     * answer matched with questionId will be return. The result contain an int number
     *
     * @param  questionId the id of <code>Question</code> object. It is an int number
     * @return an int number
     * @throws java.lang.Exception
     */
    @Override
    public int getTotalTrueAnswerByQuestionId(int questionId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Answer> list = new ArrayList<>();
        int count = 0;
        try {
            String sql = "select count (*) from answer where questionId = ? and isTrue = 1";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return count;
    }
    
    /**
     * Get answer from answer table in database. All answer has id matched with 
     * answerId will be returned. The result is a <code>Answer</code> objects 
     * with ID, questionId, answer, isTrue
     *
     * @param answerId the id of answer. It is an int number
     * @return a <code>Answer</code> objects.
     * @throws java.lang.Exception
     */
    @Override
    public Answer getAnswerById(int answerId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from answer where id = ?";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, answerId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Answer answer = new Answer();
                answer.setId(rs.getInt("id"));
                answer.setQuestionId(rs.getInt("questionId"));
                answer.setAnswer(rs.getString("answer"));
                answer.setIsTrue(rs.getBoolean("isTrue"));
                return answer;
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
