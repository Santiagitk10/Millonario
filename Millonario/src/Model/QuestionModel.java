/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author SANTIAGO SIERRA
 */
public class QuestionModel {
    
    private int questionId;
    private String question;
    private int categoryIdFk;

    public QuestionModel() {
    }
    

    public QuestionModel(int questionId, String question, int categoryIdFk) {
        this.questionId = questionId;
        this.question = question;
        this.categoryIdFk = categoryIdFk;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getCategoryIdFk() {
        return categoryIdFk;
    }

    public void setCategoryIdFk(int categoryIdFk) {
        this.categoryIdFk = categoryIdFk;
    }
    
    
    
}
