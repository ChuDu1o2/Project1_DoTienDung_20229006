/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Zoro
 */
public class Account {
    private int id;
    private String fullName;
    private String email;
    private String user;
    private String pass;
    private int isAdmin;

    public Account() {
    }

    public Account(int id, String fullName, String email, String user, String pass, int isAdmin) {
        this.id = id;
        this.fullName = fullName;
        this.user = user;
        this.email = email;
        this.pass = pass;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", fullName=" + fullName + ", email=" + email + ", user=" + user + ", pass=" + pass + ", isAdmin=" + isAdmin + '}';
    }

    


    
}
