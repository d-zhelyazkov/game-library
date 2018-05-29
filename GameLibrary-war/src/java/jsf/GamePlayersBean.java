/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entity.User;
import entity.UserData;
import java.util.Collection;
import java.util.LinkedList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import jsf.abstraction.AbstractUserListBean;

@ManagedBean
@ViewScoped
public class GamePlayersBean extends AbstractUserListBean {

    @ManagedProperty(value = "#{gameBean}")
    private GameBean gameBean;

    public void setGameBean(GameBean gameBean) {
        this.gameBean = gameBean;
    }

    /**
     * Creates a new instance of GamePlayersBean
     */
    public GamePlayersBean() {
    }

    @Override
    protected Collection<User> getSpecificItems() {
        final Collection<User> result = new LinkedList();

        for (UserData userData : gameBean.getGame().getUserDataCollection()) {
            result.add(userData.getUser());
        }

        return result;
    }

}
