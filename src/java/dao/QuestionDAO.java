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

import entity.Question;
import java.util.List;

/**
 * This interface defines method used to retrieve information from database
 * relating to <code>Question</code> object
 * <p>
 * Bugs: None
 *
 * @author DINH PHUONG THAO
 */
public interface QuestionDAO {

    /**
     * Get list question to paging from question table in database. The result
     * contains a list of <code>entity.Question</code> objects with id,
     * question, dateCreate, list <code>entity.Answer</code>
     *
     * @param pageIndex the index of page. It is an int number
     * @param pageSize the max number of question in each page. It is an int
     * number
     * @return a list of <code>Question</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Question> getQuestion(int pageIndex, int pageSize) throws Exception;

    /**
     * Get total of true answer from answer table in database. The result
     * contain an int number
     *
     * @return an int number
     * @throws java.lang.Exception
     */
    public int getTotalQuestion() throws Exception;

    /**
     * Get list random question from question table in database.The result 
     * contains a list of <code>entity.Question</code> objects with
     * id, question, dateCreate, list <code>entity.Answer</code>
     *
     * @param totalOfQuestion the total of question. It is an int number
     * @return a list of <code>Question</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Question> getRandomQuestion(int totalOfQuestion) throws Exception;
      
    /**
     * Insert data of question object and answer object into question table and 
     * answer table.
     * 
     * @param question the content of question. It is a <code>java.lang.String</code> 
     * object
     * @param listAnswer the array containing the content of the questions. 
     * It is an array of <code>java.lang.String</code> object
     * @param listPosTrueAnswer the list position of true answer. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public void addQuestionAndAnswer(String question, String [] listAnswer, 
            List<Integer> listPosTrueAnswer) throws Exception;
    
    
        
   
}
