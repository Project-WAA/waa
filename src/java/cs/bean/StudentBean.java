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
import javax.faces.event.ActionEvent;
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
    private Quiz currentQuiz = new Quiz();
    String QuizLinkId = "";

    public Quiz getCurrentQuiz() {
        return currentQuiz;
    }

    public void setCurrentQuiz(Quiz currentQuiz) {
        this.currentQuiz = currentQuiz;
    }

    public String getQuizLinkId() {
        return QuizLinkId;
    }

    public void setQuizLinkId(String QuizLinkId) {
        this.QuizLinkId = QuizLinkId;
    }

    public ArrayList<Quiz> getQuizesList() {
        return quizesList;
    }

    public void setQuizesList(ArrayList<Quiz> quizesList) {
        this.quizesList = quizesList;
    }
    
    public StudentBean()
    {
        getStudentQuizes();
    }
    
    public String attemptQuiz()
    {
        
        return "AttemptQuiz";
    }
    
    public void attemptClicked(ActionEvent event) 
    {
        QuizLinkId = event.getComponent().getId();
        System.out.println("buttonid:"+QuizLinkId);
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
                
                
            }
            
            
        } 
        catch (SQLException ex) 
        {
            System.out.println("get all questions..." + ex.getMessage());
        }
        
        
    } 
}
