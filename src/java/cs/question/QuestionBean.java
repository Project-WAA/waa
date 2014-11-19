/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.question;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import waa.demo.hibernate.Answeroptions;
import waa.demo.hibernate.Questions;

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
    private Answeroptions option = new Answeroptions();
    
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
        for(int i=0;i<selectedOptionsList.size();i++)
        {
            for(int j=0;j<optionsList.size();j++)
            {
                if(selectedOptionsList.get(i).getAnswerOptionsId() == optionsList.get(j).getAnswerOptionsId())
                {
                    //optionsList.get(j).setIsAnswer(Boolean.TRUE);
                    break;
                }
            }
        }
        
        if(optionsList != null && optionsList.size() > 0 )
        {
            System.out.println(selectedOptionsList.size());
            //System.out.println(optionsList.get(0).getIsAnswer().toString());
            //System.out.println(optionsList.get(1).getAnswerItem());
            
        }
        else
        {
            System.out.println("no items");
        }
    }
}
