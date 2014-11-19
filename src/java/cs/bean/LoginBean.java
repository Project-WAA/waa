/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.bean;

import cs.classes.User;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Prdp
 */
@Named
@SessionScoped
public class LoginBean implements Serializable
{
    public User loginUser = new User();

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }
    
    public LoginBean()
    {
        //System.out.println("LOGIN HERE");
        //loginUser = new User();   
    }
    
    public String Login()
    {
        System.out.println("IS HERE");
        System.out.println(loginUser.getUserName());
        return "createQuestion";
    }
    
    
}
