/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.classes;

/**
 *
 * @author Prdp
 */
public class User 
{
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String userType;
    private String[] selectedUsers = {};

    public String[] getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(String[] selectedUsers) {
        this.selectedUsers = selectedUsers;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    
    
}
