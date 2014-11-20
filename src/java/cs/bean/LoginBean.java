/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.bean;

import cs.classes.User;
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
public class LoginBean implements Serializable
{
     private ArrayList<User> userList = new ArrayList<User>();
     private Entity entity;
     
    private User loginUser = new User();
    private User currentUser = new User();

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }
    
    public LoginBean()
    {
        //System.out.println("LOGIN HERE");
        loginUser = new User();   
        entity = new Entity();
    }
    
    public String submitLogin()
    {
        if(currentUser.getUserName().equals("admin"))
            return "createUser";
        return "createQuestion";
    }
    
    
    
    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    public void createUser() {
        System.out.println("create USer");
        //User user= new User();
        entity.CreateUsers(loginUser);
        createUserClear();
       
        displayUser() ;
        //return "createQuestion";
    }

    public void createUserClear() {
        loginUser = new User();
    }

    public ArrayList displayUser() {
        //entity.displayUser();
//        System.out.println("I'm @ try1");
        ResultSet rs = entity.displayUser();
//        System.out.println("I'm @ try2");
        userList=new ArrayList<User>();
        try {
            User user;
            while (rs.next()) {
                user = new User();
                user.setUserName(rs.getString("username"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("LastName"));
                user.setUserType(rs.getString("userType"));
                userList.add(user);
//                System.out.println("I'm @ try3");
            }
             return userList;
        } catch (SQLException ex) {
            System.out.println("get all User..." + ex.getMessage());
        }
        return userList;
    }
    
}
