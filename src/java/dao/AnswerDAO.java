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

import entity.Answer;
import java.util.List;

/**
 * This interface defines method used to retrieve information from database 
 * relating to <code>Answer</code> object
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */
public interface AnswerDAO {
       
    /**
     * Get list answer from answer table in database. The result contains a list of 
     * <code>entity.Answer</code> objects with id, questionId, answer, isTrue
     *
     * @param quesId the id of question. It is an int number
     * @return a list of <code>Answer</code> objects. It is a 
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Answer> getAnswerByQuestionId(int quesId) throws Exception;
    
    /**
     * Get total of true answer from answer table in database. The result 
     * contain an int number
     * @param  questionId the id of <code>Question</code> object. It is an int number
     * @return an int number
     * @throws java.lang.Exception
     */
    public int getTotalTrueAnswerByQuestionId(int questionId) throws Exception;
    
    /**
     * Get answer from answer table in database. The result is a 
     * <code>Answer</code> objects with ID, questionId, answer, isTrue
     *
     * @param answerId the id of answer. It is an int number
     * @return a <code>Answer</code> objects.
     * @throws java.lang.Exception
     */
    public Answer getAnswerById(int answerId) throws Exception;
}
