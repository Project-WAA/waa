/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.bean;

import cs.database.Entity;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import cs.classes.Answeroptions;
import cs.classes.Questions;

/**
 *
 * @author Prdp
 */
@Named
@SessionScoped 

public class QuestionBean implements Serializable{
    
    private Questions question = new Questions();
    private ArrayList<Answeroptions> optionsList  = new ArrayList<Answeroptions>();
   private ArrayList<Answeroptions> selectedOptionsList  = new ArrayList<Answeroptions>();
    private Answeroptions correctAnswer = new Answeroptions();
    private Answeroptions option = new Answeroptions();
    private String correctAnswerItem;

    public String getCorrectAnswerItem() {
        return correctAnswerItem;
    }

    public void setCorrectAnswerItem(String correctAnswerItem) {
        this.correctAnswerItem = correctAnswerItem;
    }
    
    public String redirectQuestion(){
        option = new Answeroptions();
        question = new Questions();
        optionsList = new ArrayList<Answeroptions>();
        return "createQuestion";
    }


    
    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }
    
    public ArrayList<Answeroptions> getSelectedOptionsList() {
        return selectedOptionsList;
    }

    public void setSelectedOptionsList(ArrayList<Answeroptions> selectedOptionsList) {
        this.selectedOptionsList = selectedOptionsList;
    }

    public Answeroptions getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answeroptions correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    

    public ArrayList<Answeroptions> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(ArrayList<Answeroptions> optionsList) {
        this.optionsList = optionsList;
    }

    public Answeroptions getOption() {
        return option;
    }

    public void setOption(Answeroptions option) {
        this.option = option;
    }
    
    public QuestionBean()
    {
        
    }
    
    public void addOptions()
    {
        option.setQuestions(question);
        optionsList.add(option);
        option = new Answeroptions();
        System.out.println(optionsList);
    }
    
    
    public void saveQuestion()
    {
        try 
        {
                Entity qe = new Entity();

                int qID = qe.SaveQuestion(question);
                if(qID > 0)
                {
                    for (Answeroptions opt : optionsList)
                    {
                        System.out.println("selected:" + correctAnswerItem);
                        if(opt.getAnswerItem().equals(correctAnswerItem))
                        {
                            opt.setIsAnswer(Boolean.TRUE);
                        }
                        else
                        {
                            opt.setIsAnswer(Boolean.FALSE);
                        }
                        qe.SaveOptions(qID,opt);
                        System.out.println("test");
                    }
                }
            } 
        catch (SQLException ex) 
                    {
            //Logger.getLogger(QuestionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
    }
    
    
}
