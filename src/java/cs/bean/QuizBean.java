/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.bean;

import cs.classes.Questions;
import cs.classes.Quiz;
import cs.database.Entity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Prdp
 */
@Named
@SessionScoped 

public class QuizBean implements Serializable
{
    private Quiz quiz = new Quiz();
    private ArrayList<Questions> questionList = new ArrayList<Questions>();
    private String[] selectedQuestion = {};

    public String[] getSelectedQuestion() {
        return selectedQuestion;
    }

    public void setSelectedQuestion(String[] selectedQuestion) {
        this.selectedQuestion = selectedQuestion;
    }
    

    public ArrayList<Questions> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Questions> questionList) {
        this.questionList = questionList;
    }
            
    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    
    
    public void getAllQuestions(int courseId)
    {
        questionList = new ArrayList<>();
        
        Entity qe = new Entity();

        ResultSet rs = qe.getAllQuestions(courseId);
        
        try 
        {
            Questions ques ;
            while(rs.next())
            {
                ques = new Questions();
                ques.setQuestionId(rs.getInt("QuestionID"));
                ques.setCourse(rs.getString("CourseId"));
                ques.setQuestionDescription(rs.getString("QuestionDescription"));
                ques.setMark(rs.getInt("Mark"));
                ques.setEnteredBy(rs.getString("EnteredBy"));
                
                questionList.add(ques);
            }
            
            
        } 
        catch (SQLException ex) 
        {
            System.out.println("get all questions..." + ex.getMessage());
        }
        
        
    }
    
    public QuizBean()
    {
        getAllQuestions(Integer.parseInt(this.quiz.getCourseId()));
    }
    String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    
    public String createQuiz()
    {
        Entity qe = new Entity();
        int quizId = qe.SaveQuiz(quiz);
        for(Questions as:questionList){
            for(String a:as.getSelectedQuestion())
            {
                System.out.println("quiz selected:"+ a);
            }
        }
        if(quizId > 0)
        {
            qe.SaveQuizQuestions(quizId, selectedQuestion);
            System.out.println("quizQuestion saved");
        }
        return "";
    }
    
    public String redirectCreateQuiz(){
        
        quiz = new Quiz();
        getAllQuestions(Integer.parseInt(this.quiz.getCourseId()));
        return "CreateQuiz";
    }
    
}
