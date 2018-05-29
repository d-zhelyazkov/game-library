/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.abstraction;

import entity.User;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import jsf.UserBean;
import session.UserFacade;

public abstract class AbstractUserListBean extends AbstractEntityListBean<User> {

    @EJB
    protected UserFacade userFacade;

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    public AbstractUserListBean() {
        super("date");
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
        super.setEntityBean(userBean);
    }

}
