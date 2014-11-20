/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.bean;

import cs.classes.User;
import cs.database.Entity;
import cs.database.util;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Prdp
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {

    private ArrayList<User> userList = new ArrayList<User>();
    private Entity entity;
    private String logineErrorMsg = null;

    public String getLogineErrorMsg() {
        return logineErrorMsg;
    }

    public void setLogineErrorMsg(String logineErrorMsg) {
        this.logineErrorMsg = logineErrorMsg;
    }

    private User loginUser = new User();
    private User currentUser = new User();

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    public LoginBean() {
        //System.out.println("LOGIN HERE");
        loginUser = new User();
        entity = new Entity();
        displayUser();
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

        displayUser();
        //return "createQuestion";
    }
    util Util = new util();

    public String submitLogin() {
        ResultSet rs1 = entity.checkuser(currentUser);

        try {
            int validUser = 0;
            while (rs1.next()) {
                validUser = rs1.getInt("usercheck");
                System.out.println("User Type " + validUser);
                if (validUser == 1) { //professor
                    //Session
                    HttpSession session = Util.getSession();
                    session.setAttribute("username", currentUser.getUserName());
                    return "CreateQuiz";
                } else if (validUser == 2) { //student
                    //Session
                    HttpSession session = Util.getSession();
                    session.setAttribute("username", currentUser.getUserName());
                    return "welcomePrimefaces";
                } else if (validUser == 3) { //admin
                    //Session
                    HttpSession session = Util.getSession();
                    session.setAttribute("username", currentUser.getUserName());
                    return "createUser";
                } else { //all other
                    logineErrorMsg = "Please try Again!!, login Unsuccess :(";
                    return "login";
                }

            }
        } catch (Exception e) {
        }
//        if(currentUser.getUserName().equals("admin"))
//            return "createUser";
        return "createQuestion";
    }

    public String logout() {
        HttpSession session = Util.getSession();
        session.invalidate();
        return "login";
    }

    public void createUserClear() {
        loginUser = new User();
    }

    public ArrayList displayUser() {
        //entity.displayUser();
//        System.out.println("I'm @ try1");
        ResultSet rs = entity.displayUser();
//        System.out.println("I'm @ try2");
        userList = new ArrayList<User>();
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
