/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entity.User;
import java.util.Collection;
import java.util.Collections;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import jsf.abstraction.AbstractUserListBean;

@ManagedBean
@ViewScoped
public class AllUsersListBean extends AbstractUserListBean {


    @ManagedProperty(value = "#{authenticationBean}")
    private AuthenticationBean authenticationBean;

    public void setAuthenticationBean(AuthenticationBean authenticationBean) {
        this.authenticationBean = authenticationBean;
    }

    /**
     * Creates a new instance of UsersBean
     */
    public AllUsersListBean() {
    }

    @Override
    protected Collection<User> getSpecificItems() {
        return userFacade.findAllExcept(Collections.singletonList(authenticationBean.getUser()));
    }


}
