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
        String qry="Insert into Questions(CourseId,QuestionDescription,Answer,Mark,EnteredBy)"+
                "values("+1+",'"+question.getQuestionDescription()+"',"+question.getMark()+")";
        System.out.println(qry);
        int id = connectMySql.insetAndGetID(qry);
        return id;
    }
//    QuestionID int primary key auto_increment,
//CourseId int, 
//QuestionDescription varchar(800),  
//Answer varchar(800),  
//Mark int,
//EnteredBy varchar(255)  
    public void SaveOptions(int questionID, Answeroptions options)
    {
        String qry="Insert into AnswerOptions(QuestionID,AnswerItem,isAnswer)"+
                "values("+questionID+",'"+options.getAnswerItem()+"',"+options.getIsAnswer()+")";
        System.out.println(qry);
        boolean result = connectMySql.insert(qry);
        System.out.println(result);
    }
    
}
