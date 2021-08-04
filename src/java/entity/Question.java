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

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * This class contain entities of <code>Question</code> object. Contain methods 
 * which use to get and set all of attributes. 2 Constructor with parameter and 
 * no parameter
 * <p>
 * Bugs: None   
 *
 * @author DINH PHUONG THAO
 */

public class Question {

    private int id;
    private String question;
    private Date dateCreate;
    private List<Answer> answerList;

    /**
     * Used to initialize <code>Question</code> with no parameter
     */
    public Question() {
    }

    /**
     * Used to initialize <code>Question</code> with its properties as parameters
     *
     * @param id the id of Question. It is an int number
     * @param question the description of <code>Question</code>. It is a
     * <code>java.lang.String</code> object
     * @param dateCreate the question creation time of Question. 
     * It is <code>java.util.Date</code>
     * @param answerList the list of Answer. It is <code>java.util.List</code>
     */   
    public Question(int id, String question, Date dateCreate, List<Answer> answerList) {
        this.id = id;
        this.question = question;
        this.dateCreate = dateCreate;
        this.answerList = answerList;
    }

    /**
     * Get value from dateCreate attribute of <code>Question</code> object
     *
     * @return dateCreate of object
     */
    public Date getDateCreate() {
        return dateCreate;
    }

    /**
     * Set value for dateCreate attribute of <code>Question</code> object
     *
     * @param dateCreate the question creation time. 
     * It is a <code>java.util.Date</code> object
     */
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /**
     * Get value from answerList attribute of <code>Question</code> object
     *
     * @return answerList of object
     */
    public List<Answer> getAnswerList() {
        return answerList;
    }

    /**
     * Set value for answerList attribute of <code>Question</code> object
     *
     * @param answerList the list of answer. 
     * It is a <code>java.util.List</code> object
     */
    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    /**
     * Get value from id attribute of <code>Question</code> object
     *
     * @return id of object
     */
    public int getId() {
        return id;
    }

    /**
     * Set value for id attribute of <code>Question</code> object
     *
     * @param id the id of Question. It is an int number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from question attribute of <code>Question</code> object
     *
     * @return question of object
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Set value for question attribute of <code>Question</code> object
     *
     * @param question the description of Question. It is a
     * <code>java.lang.String</code> object
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Get value from dateCreate attribute after format
     *
     * @return format dateCreate of object
     */
    public String getDateFormat(){
        return new SimpleDateFormat("dd-MMM-yyyy").format(this.dateCreate);
    }

}
