package waa.demo.hibernate;
// Generated Nov 18, 2014 7:49:01 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Quiz generated by hbm2java
 */
public class Quiz  implements java.io.Serializable {


     private Integer quizId;
     private String quizDescription;
     private Date quizStartDatetime;
     private Date quizendDatetime;
     private Set<Questions> questionses = new HashSet<Questions>(0);

    public Quiz() {
    }

    public Quiz(String quizDescription, Date quizStartDatetime, Date quizendDatetime, Set<Questions> questionses) {
       this.quizDescription = quizDescription;
       this.quizStartDatetime = quizStartDatetime;
       this.quizendDatetime = quizendDatetime;
       this.questionses = questionses;
    }
   
    public Integer getQuizId() {
        return this.quizId;
    }
    
    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }
    public String getQuizDescription() {
        return this.quizDescription;
    }
    
    public void setQuizDescription(String quizDescription) {
        this.quizDescription = quizDescription;
    }
    public Date getQuizStartDatetime() {
        return this.quizStartDatetime;
    }
    
    public void setQuizStartDatetime(Date quizStartDatetime) {
        this.quizStartDatetime = quizStartDatetime;
    }
    public Date getQuizendDatetime() {
        return this.quizendDatetime;
    }
    
    public void setQuizendDatetime(Date quizendDatetime) {
        this.quizendDatetime = quizendDatetime;
    }
    public Set<Questions> getQuestionses() {
        return this.questionses;
    }
    
    public void setQuestionses(Set<Questions> questionses) {
        this.questionses = questionses;
    }




}


