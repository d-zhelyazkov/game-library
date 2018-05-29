/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entity.User;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import session.UserFacade;
import tool.StringHashingTool;

/**
 *
 * @author XRC_7331
 */
@ManagedBean
@ViewScoped
public class RegisterBean {

    private static final String REGISTER_SUCCESS = "User successfully registered.";
    private static final String PASSWORD_NOMATCH = "Passwords don't match!";

    @EJB
    private UserFacade userFacade;

    private String userName;
    private String password;
    private String repPwd;
    private String message;

    public void register() {

        if (password.equals(repPwd)) {
            User user = new User();
            user.setName(userName);
            user.setPassword(StringHashingTool.getInstance().hashUsingMD5(password));
            userFacade.create(user);

            message = REGISTER_SUCCESS;
        } else {
            message = PASSWORD_NOMATCH;
        }
    }

    /**
     * Creates a new instance of RegisterBean
     */
    public RegisterBean() {
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

    public String getRepPwd() {
        return repPwd;
    }

    public void setRepPwd(String repPwd) {
        this.repPwd = repPwd;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
