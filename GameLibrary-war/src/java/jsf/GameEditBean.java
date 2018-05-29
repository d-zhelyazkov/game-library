/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entity.Game;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import session.GameFacade;

/**
 *
 * @author XRC_7331
 */
@ManagedBean
@SessionScoped
public class GameEditBean {
    private static final String GAME_EXISTS = "Game with that title exists!";
    private static final String GAME_CREATED = "Game successfully created!";
    private static final String GAME_SAVED = "Game successfully saved!";

    private String descritpion;
    private String gameTitle;
    private String message = "";

    @EJB
    private GameFacade gameFacade;
    private Game editedGame;

    @ManagedProperty(value = "#{authenticationBean}")
    private AuthenticationBean authenticationBean;

    public void setAuthenticationBean(AuthenticationBean authenticationBean) {
        this.authenticationBean = authenticationBean;
    }

    public String createGame() {
        gameTitle = "";
        message = "";
        editedGame = null;
        descritpion = "";
        return "/gameEdit";
    }

    public void save() {
        if (editedGame != null) {
            if (!editedGame.getName().equals(gameTitle)) {
                Game game = gameFacade.findByName(gameTitle);
                if (game != null) {
                    message = GAME_EXISTS;
                    return;
                }
                editedGame.setName(gameTitle);
            }
            editedGame.setDescription(descritpion);
            gameFacade.edit(editedGame);
            message = GAME_SAVED;
        } else {
            editedGame = new Game();
            editedGame.setName(gameTitle);
            editedGame.setDescription(descritpion);
            editedGame.setDistributor(authenticationBean.getUser());
            gameFacade.create(editedGame);
            message = GAME_CREATED;
        }
    }

    public String getMessage() {
        return message;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    /**
     * Creates a new instance of GameEditBean
     */
    public GameEditBean() {
    }

    public String edit(Game game) {
        gameTitle = game.getName();
        descritpion = game.getDescription();
        message = "";
        editedGame = game;
        return "/gameEdit";
    }


}
