/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.abstraction;

import entity.User;
import javax.ejb.EJB;
import session.UserFacade;

/**
 *
 * @author XRC_7331
 */
public abstract class AbstractUserHandler {

    @EJB
    protected UserFacade userFacade;

    protected String username;

    public User getUser() {
        return userFacade.findByName(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
