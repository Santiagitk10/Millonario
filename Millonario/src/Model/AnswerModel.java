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
public class AnswerModel {
    
    private int answerId;
    private String answerStatus;
    private String answer;
    private int questionIdFk;

    public AnswerModel(int answerId, String answerStatus, String answer, int questionIdFk) {
        this.answerId = answerId;
        this.answerStatus = answerStatus;
        this.answer = answer;
        this.questionIdFk = questionIdFk;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerStatus() {
        return answerStatus;
    }

    public void setAnswerStatus(String answerStatus) {
        this.answerStatus = answerStatus;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionIdFk() {
        return questionIdFk;
    }

    public void setQuestionIdFk(int questionIdFk) {
        this.questionIdFk = questionIdFk;
    }
    
    
   
    
}
