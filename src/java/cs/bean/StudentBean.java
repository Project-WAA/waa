/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.bean;

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
public class StudentBean implements Serializable
{
    private ArrayList<Quiz> quizesList = new ArrayList<Quiz>();

    public ArrayList<Quiz> getQuizesList() {
        return quizesList;
    }

    public void setQuizesList(ArrayList<Quiz> quizesList) {
        this.quizesList = quizesList;
    }
    
    public StudentBean()
    {
        //getStudentQuizes();
    }
    
    public String attemptQuiz()
    {
        return "AttemptQuiz";
    }
    
    public String redirectQuizList()
    {
        return "QuizList";
    }
    
    public String redirectResult()
    {
        return "StudentResult";
    }
    
    public void getStudentQuizes()
    {
        quizesList = new ArrayList<>();
        
        Entity qe = new Entity();

        ResultSet rs = qe.getAllQuizes();
        
        try 
        {
            Quiz quiz ;
            while(rs.next())
            {
                quiz = new Quiz();
                quiz.setQuizId(rs.getInt("QuizID"));
                quiz.setQuizDescription(rs.getString("QuizDescription"));
                quiz.setEnteredBy(rs.getString("EnteredBy"));
                
                quizesList.add(quiz);
                
                System.out.println(rs.getString("QuizDescription"));
            }
            
            
        } 
        catch (SQLException ex) 
        {
            System.out.println("get all questions..." + ex.getMessage());
        }
        
        
    } 
}
