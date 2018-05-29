/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import jsf.abstraction.AbstractUserHandler;
import entity.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import tool.StringHashingTool;

/**
 *
 * @author XRC_7331
 */
@ManagedBean(name = "authenticationBean")
@SessionScoped
public class AuthenticationBean extends AbstractUserHandler {

    private static final String LOGIN_FAIL = "Username and password don't match our records!";

    private String password;
    private String message;
    private boolean logged;

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String displayUser() {
        userBean.setUsername(username);
        return "user";
    }

    /**
     * Get the value of logged
     *
     * @return the value of logged
     */
    public boolean isLogged() {
        return logged;
    }

    /**
     * Set the value of logged
     *
     * @param logged new value of logged
     */
    public void setLogged(boolean logged) {
        this.logged = logged;
    }


    /**
     * Get the value of message
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the value of message
     *
     * @param message new value of message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public void logout() {
        logged = false;
        username = "";
        password = "";
        message = "";
    }

    public void login() {
        byte[] encodedPass = StringHashingTool.getInstance().hashUsingMD5(password);
        User user = userFacade.find(username, encodedPass);

        if (user == null) {
            message = LOGIN_FAIL;
        } else {
            logged = true;
            message = "";
        }
    }


    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Creates a new instance of loginBean
     */
    public AuthenticationBean() {
    }

}
