/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entity.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jsf.abstraction.AbstractUserHandler;
import jsf.abstraction.IEntityBean;

@ManagedBean
@SessionScoped
public class UserBean extends AbstractUserHandler implements IEntityBean<User> {

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }

    public void makeAdmin() {
        User user = getUser();
        user.setIsAdmin(true);
        userFacade.edit(user);
    }

    public void makeDistributor() {
        User user = getUser();
        user.setIsGameDistributor(true);
        userFacade.edit(user);
    }

    @Override
    public String preparePage(User user) {
        super.setUsername(user.getName());
        return "/user";
    }
}
