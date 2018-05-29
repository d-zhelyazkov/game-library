/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entity.Game;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import jsf.abstraction.AbstractGameListBean;

@ManagedBean
@ViewScoped
public class UserDistributedGamesBean extends AbstractGameListBean {

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    /**
     * Creates a new instance of UserDistributedGamesBean
     */
    public UserDistributedGamesBean() {
    }

    @Override
    protected Collection<Game> getSpecificItems() {
        return userBean.getUser().getDistributedGames();
    }

}
