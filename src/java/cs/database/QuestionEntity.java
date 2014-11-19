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
import waa.demo.hibernate.Answeroptions;
import waa.demo.hibernate.Questions;

/**
 *
 * @author Prdp
 */
public class QuestionEntity 
{
    public QuestionEntity()
    {
        
    }
    
   
    
    public int SaveQuestion(Questions question) throws SQLException
    {
        String qry="Insert into Questions(quizID,QuestionDescription,mark)"+
                "values("+1+",'"+question.getQuestionDescription()+"',"+question.getMark()+")";
        System.out.println(qry);
        int id = connectMySql.insetAndGetID(qry);
        return id;
    }
    
    public void SaveOptions(int questionID, Answeroptions options)
    {
        String qry="Insert into AnswerOptions(QuestionID,AnswerItem,isAnswer)"+
                "values("+questionID+",'"+options.getAnswerItem()+"',"+options.getIsAnswer()+")";
        System.out.println(qry);
        boolean result = connectMySql.insert(qry);
        System.out.println(result);
    }
    
}
