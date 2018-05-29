/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entity.Game;
import entity.UserData;
import java.util.Collection;
import java.util.LinkedList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import jsf.abstraction.AbstractGameListBean;

@ManagedBean
@ViewScoped
public class UserPlayedGamesBean extends AbstractGameListBean {

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    /**
     * Creates a new instance of UserPlayedGamesBean
     */
    public UserPlayedGamesBean() {
    }

    @Override
    protected Collection<Game> getSpecificItems() {
        Collection<Game> result = new LinkedList();
        Collection<UserData> userData = userBean.getUser().getUserDataCollection();
        for (UserData data : userData) {
            result.add(data.getGame());
        }

        return result;
    }

}
