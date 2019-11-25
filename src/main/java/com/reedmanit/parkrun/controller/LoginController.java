package com.reedmanit.parkrun.controller;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;

import com.reedmanit.parkrun.dao.LoginDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginController implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String newpassword;

    public LoginController() {
        super();
    }

  //  @PostConstruct
  //  public void init() {

  //      try {
 //           com.reedmanit.parkrun.util.Connection.getInstance().createDBConnection();
  //      } catch (SQLException ex) {
  //          Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
  //      }
  //  }

    public String validateUser() throws SQLException {
        FacesMessage msg = null;
        boolean isValidUser = false;

        LoginDAO dao = new LoginDAO();
        isValidUser = dao.validateUser(username, password);

        if (isValidUser) {

            System.out.println("Valid User");
       //     return "/views/bicycletable.xhtml?faces-redirect=true";
              return "/welcomePrimeFaces.xhtml?faces-redirect=true";
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
                    "Invalid credentials");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

}
