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
 * This class contain entities of <code>Answer</code> object. Contain methods which use to get
 * and set all of attributes. 2 Constructor with parameter and no parameter
 * <p>
 * Bugs: None   
 *
 * @author DINH PHUONG THAO
 */

public class Answer {
    private int id;
    private int questionId;
    private String answer;
    private boolean isTrue;

    /**
     * Used to initialize <code>Answer</code> with no parameter
     */
    public Answer() {
    }

    /**
     * Used to initialize <code>Answer</code> with its properties as parameters
     *
     * @param id the id of Answer. It is an int number
     * @param qestionId the id of Question. It is an int number
     * @param answer the description of Answer. It is a
     * <code>java.lang.String</code> object
     * @param isTrue the result of Answer. It is 
     * <code>java.lang.boolean</code>
     */ 
    public Answer(int id, int qestionId, String answer, boolean isTrue) {
        this.id = id;
        this.questionId = qestionId;
        this.answer = answer;
        this.isTrue = isTrue;
    }

    /**
     * Get value from id attribute of <code>Answer</code> object
     *
     * @return id of object
     */
    public int getId() {
        return id;
    }

    /**
     * Set value for id attribute of <code>Answer</code> object
     *
     * @param id the id of Answer. It is an int number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from questionId attribute of <code>Answer</code> object
     *
     * @return questionId of object
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * Set value for questionId attribute of <code>Answer</code> object
     *
     * @param questionId the id of Question. It is an int number
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * Get value from answer attribute of <code>Answer</code> object
     *
     * @return answer of object
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Set value for answer attribute of <code>Answer</code> object
     *
     * @param answer the description of Answer. 
     * It is a <code>java.lang.String</code> object
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Get value from isTrue attribute of <code>Answer</code> object
     *
     * @return isTrue of object
     */
    public boolean isIsTrue() {
        return isTrue;
    }

    /**
     * Set value for isTrue attribute of <code>Answer</code> object
     *
     * @param isTrue the result of Answer. 
     * It is a <code>java.lang.boolean</code> object
     */
    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }
    
    
}
