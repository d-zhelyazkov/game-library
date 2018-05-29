/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entity.Game;
import entity.User;
import entity.UserData;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import jsf.abstraction.IEntityBean;
import session.GameFacade;
import session.UserDataFacade;

/**
 *
 * @author XRC_7331
 */
@ManagedBean
@SessionScoped
public class GameBean implements IEntityBean<Game> {

    private Integer observedGameID;

    @EJB
    private GameFacade gameFacade;

    @EJB
    private UserDataFacade userDataFacade;

    @ManagedProperty(value = "#{authenticationBean}")
    private AuthenticationBean authenticationBean;

    public void setAuthenticationBean(AuthenticationBean authenticationBean) {
        this.authenticationBean = authenticationBean;
    }

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    @ManagedProperty(value = "#{gameEditBean}")
    private GameEditBean gameEditBean;

    public void setGameEditBean(GameEditBean gameEditBean) {
        this.gameEditBean = gameEditBean;
    }

    public boolean getAuthUserPlayThisGame() {
        Game game = getGame();
        Collection<UserData> userData = authenticationBean.getUser().getUserDataCollection();
        for (UserData data : userData) {
            if (data.getGame().equals(game)) {
                return true;
            }
        }

        return false;
//        return userData.stream().anyMatch(
//                (data) -> {
//                    Game dataGame = data.getGame();
//                    return dataGame.equals(game);
//                }
//        );
    }

    public void addGame() {
        UserData data = new UserData();
        data.setUser(authenticationBean.getUser());
        data.setGame(getGame());
        userDataFacade.create(data);
    }

    public boolean getIsAuthUserDistributor() {
        User user = authenticationBean.getUser();
        return ((user.getIsGameDistributor()) && (getGame().getDistributor().equals(user)));
    }

    public String displayDistributor() {
        return userBean.preparePage(getGame().getDistributor());
    }

    public String edit() {
        return gameEditBean.edit(getGame());
    }

    public Integer getObservedGameID() {
        return observedGameID;
    }

    public void setObservedGameID(Integer observedGameID) {
        this.observedGameID = observedGameID;
    }

    public Game getGame() {
        return gameFacade.find(observedGameID);
    }


    /**
     * Creates a new instance of GameBean
     */
    public GameBean() {
    }

    @Override
    public String preparePage(Game entity) {
        observedGameID = entity.getId();
        return "/game";
    }

}
