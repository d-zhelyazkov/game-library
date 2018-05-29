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
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import jsf.abstraction.AbstractGameListBean;
import session.GameFacade;

@ManagedBean
@ViewScoped
public class AuthUserNotPlayedGamesBean extends AbstractGameListBean {

    @EJB
    private GameFacade gameFacade;

    @ManagedProperty(value = "#{authenticationBean}")
    private AuthenticationBean authenticationBean;

    public void setAuthenticationBean(AuthenticationBean authenticationBean) {
        this.authenticationBean = authenticationBean;
    }

    /**
     * Creates a new instance of AuthUserNotPlayedGamesBean
     */
    public AuthUserNotPlayedGamesBean() {
    }

    @Override
    protected Collection<Game> getSpecificItems() {
        Collection<Game> playedGames = new LinkedList();
        for (UserData data : authenticationBean.getUser().getUserDataCollection()) {
            playedGames.add(data.getGame());
        }

        return gameFacade.findAllExcept(playedGames);
    }
}
