/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.database;

import cs.bean.LoginBean;
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
        String qry="Insert into Questions(CourseId,QuestionDescription,EnteredBy,Mark)"+
                "values("+courseId+",'"+question.getQuestionDescription()+"'," + currentUserName +"," +
                question.getMark()+")";
        
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
        String qry="Insert into Quiz(QuizDescription,Enteredby)"+ //quizStartDatetime,quizendDatetime,
                "values('"+quiz.getQuizDescription()+"','"+
                //quiz.getStartDateTime()+"','"+
                //quiz.getEndDateTime()+"','"+
                currentUserName+"')";
        
        System.out.println(qry);
        int id = connectMySql.insetAndGetID(qry);
        return id;

    }
    
    public boolean SaveQuizQuestions(int quizId, ArrayList<Questions> questionList)
    {
        for(Questions as:questionList){
            for(String a:as.getSelectedQuestion())
            {
                String qry="Insert into QuizQuestions(QuestionID,QuizID)"+
                    "values('"+a+"','"+quizId+"')";

                System.out.println(qry);
                boolean result = connectMySql.insert(qry);
            }
        }
        
        
        
        return true;

    }
    
    public boolean AssignQuizToUser(ArrayList<User> userList, int quizId)
    {
        for(User as:userList){
            for(String a:as.getSelectedUsers())
            {
                String qry="Insert into QuizUser(QuizID,UserID)"+
                    "values('"+quizId+"','"+a+"')";

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
     
     public ResultSet getAllStudentUser(int type){
         String qry="Select * from Users where userType = " + type +";";
         System.out.println(qry);
         ResultSet reasult=connectMySql.select(qry);
         return reasult;
         
         
     }
     
     public ResultSet getAllQuizes(){
         String qry="Select * from Quiz;";
         System.out.println(qry);
         ResultSet reasult=connectMySql.select(qry);
         return reasult;
         
         
     }
     
    public ResultSet checkuser(User currentUser){
         
         String qry="SELECT IF( EXISTS(SELECT * FROM users WHERE  username=  '"+currentUser.getUserName()+"' and password=md5('"+currentUser.getPassword()+"')) , (SELECT userType FROM users WHERE  username=  '"+currentUser.getUserName()+"' and password=md5('"+currentUser.getPassword()+"') ),(select 0) )as usercheck;";
         System.out.println(qry);
         ResultSet reasult1=connectMySql.select(qry);
        return reasult1;      
     }
    
}
