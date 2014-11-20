/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import cs.classes.Answeroptions;
import cs.classes.Questions;
import cs.classes.Quiz;
import cs.classes.User;
import java.util.ArrayList;

/**
 *
 * @author Prdp
 */
public class Entity 
{
    String currentUserName="admin";

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }
    
    
    public Entity()
    {
        
    }
    
   
    
    public int SaveQuestion(Questions question) throws SQLException
    {
        int courseId = 0;
        if(question.getCourse()!= null && !question.getCourse().isEmpty())
        {
            courseId = Integer.parseInt(question.getCourse());
        }
        String qry="Insert into Questions(CourseId,QuestionDescription,Answer,Mark,EnteredBy)"+
                "values("+courseId+",'"+question.getQuestionDescription()+"'," + currentUserName +"," +
                question.getMark()+"," +question.getMark()+ ")";
        
        System.out.println(qry);
        int id = connectMySql.insetAndGetID(qry);
        return id;
    }

    public void SaveOptions(int questionID, Answeroptions options)
    {
        String qry="Insert into AnswerOptions(QuestionID,Answer,isAnswer)"+
                "values("+questionID+",'"+options.getAnswerItem()+"',"+options.getIsAnswer()+")";
        
        System.out.println(qry);
        boolean result = connectMySql.insert(qry);
        System.out.println(result);
    }
    
    public ResultSet getAllQuestions(int courseId)
    {
        String qry="Select * from Questions q where q.courseid = " + courseId;
        
        System.out.println(qry);
        ResultSet result = connectMySql.select(qry);
        
        return result;
    }
  
    public int SaveQuiz(Quiz quiz)
    {
        String qry="Insert into Quiz(QuizDescription,quizStartDatetime,quizendDatetime,Enteredby)"+
                "values('"+quiz.getQuizDescription()+"','"+quiz.getQuizStartDatetime()+"','"+
                quiz.getQuizStartDatetime()+"','"+quiz.getQuizEndDatetime()+"')";
        
        System.out.println(qry);
        int id = connectMySql.insetAndGetID(qry);
        return id;

    }
    
    public boolean SaveQuizQuestions(int quizId, String[] questionList)
    {
        for(String q : questionList)
        {
            //if(q.equals(q))
            {
                String qry="Insert into Quiz(QuestionID,QuizID)"+
                    "values('"+q+"','"+quizId+"')";

                System.out.println(qry);
                boolean result = connectMySql.insert(qry);
            }
        }
        
        return true;

    }
    
    public void CreateUsers(User user)
    {
        String qry="Insert into users(username,password,firstName,LastName,userType) "+
                "values('"+user.getUserName()+"',md5('"+user.getPassword()+"'),'"+user.getFirstName()+"','"+user.getLastName()+"',"+user.getUserType()+")";
        System.out.println(qry);
        boolean result = connectMySql.insert(qry);
        System.out.println(result);
    }
     
     public ResultSet displayUser(){
         String qry="Select * from Users;";
         System.out.println(qry);
         ResultSet reasult=connectMySql.select(qry);
         return reasult;
         
         
     }
     
    
}
