package cs.classes;
// Generated Nov 18, 2014 7:49:01 PM by Hibernate Tools 3.6.0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Questions generated by hbm2java
 */
public class Questions  implements java.io.Serializable {


     private Integer questionId;
     private Quiz quiz;
     private String questionDescription;
     private ArrayList<Answeroptions> answeroptionses  = new ArrayList<Answeroptions>();

    public ArrayList<Answeroptions> getAnsweroptionses() {
        return answeroptionses;
    }

    public void setAnsweroptionses(ArrayList<Answeroptions> answeroptionses) {
        this.answeroptionses = answeroptionses;
    }
     private Integer mark;
     private String course;
     private boolean isSelected;
     private String EnteredBy;
     private String[] selectedQuestion = {};

    public String[] getSelectedQuestion() {
        return selectedQuestion;
    }

    public void setSelectedQuestion(String[] selectedQuestion) {
        this.selectedQuestion = selectedQuestion;
    }
     

    public String getEnteredBy() {
        return EnteredBy;
    }

    public void setEnteredBy(String EnteredBy) {
        this.EnteredBy = EnteredBy;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    

    public Questions() {
    }

    public Questions(Quiz quiz, String questionDescription, ArrayList<Answeroptions> answeroptionses, Integer mark,String course) {
       this.quiz = quiz;
       this.questionDescription = questionDescription;
       this.answeroptionses = answeroptionses;
       this.mark = mark;
       this.course = course;
    }
   
    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
    
    public Integer getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
    public Quiz getQuiz() {
        return this.quiz;
    }
    
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    public String getQuestionDescription() {
        return this.questionDescription;
    }
    
    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }


}


