/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entity.Game;
import entity.Score;
import entity.UserData;
import java.util.Collection;
import java.util.LinkedList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import jsf.abstraction.AbstractScoreListBean;

/**
 *
 * @author XRC_7331
 */
@ManagedBean
@ViewScoped
public class AuthUserGameHighscores extends AbstractScoreListBean {

    @ManagedProperty(value = "#{gameBean}")
    private GameBean gameBean;

    public void setGameBean(GameBean gameBean) {
        this.gameBean = gameBean;
    }

    @ManagedProperty(value = "#{authenticationBean}")
    private AuthenticationBean authenticationBean;

    public void setAuthenticationBean(AuthenticationBean authenticationBean) {
        this.authenticationBean = authenticationBean;
    }

    /**
     * Creates a new instance of AuthUserGameHighscores
     */
    public AuthUserGameHighscores() {
    }

    @Override
    protected Collection<Score> getSpecificItems() {
        final Game game = gameBean.getGame();
        for (UserData data : authenticationBean.getUser().getUserDataCollection()) {
            if (game.equals(data.getGame())) {
                return data.getScoreCollection();
            }
        }

        return new LinkedList();
    }

}
