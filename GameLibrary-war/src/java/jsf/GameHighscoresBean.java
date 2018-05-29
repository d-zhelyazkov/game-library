/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

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
public class GameHighscoresBean extends AbstractScoreListBean {

    @ManagedProperty(value = "#{gameBean}")
    private GameBean gameBean;

    public void setGameBean(GameBean gameBean) {
        this.gameBean = gameBean;
    }

    /**
     * Creates a new instance of GameHighscoresBean
     */
    public GameHighscoresBean() {
    }

    @Override
    protected Collection<Score> getSpecificItems() {
        final Collection<Score> result = new LinkedList();
        for (UserData data : gameBean.getGame().getUserDataCollection()) {
            result.addAll(data.getScoreCollection());
        }

        return result;
    }

}
