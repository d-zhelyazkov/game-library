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
public class AuthUserPlayedGames extends AbstractGameListBean {

    @ManagedProperty(value = "#{authenticationBean}")
    private AuthenticationBean authenticationBean;

    public void setAuthenticationBean(AuthenticationBean authenticationBean) {
        this.authenticationBean = authenticationBean;
    }

    /**
     * Creates a new instance of AuthUserPlayedGames
     */
    public AuthUserPlayedGames() {
    }

    @Override
    protected Collection<Game> getSpecificItems() {
        Collection<Game> result = new LinkedList();
        for (UserData data : authenticationBean.getUser().getUserDataCollection()) {
            result.add(data.getGame());
        }

        return result;
    }

}
