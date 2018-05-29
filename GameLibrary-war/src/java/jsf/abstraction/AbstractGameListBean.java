/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.abstraction;

import entity.Game;
import javax.faces.bean.ManagedProperty;
import jsf.GameBean;

/**
 *
 * @author XRC_7331
 */
public abstract class AbstractGameListBean extends AbstractEntityListBean<Game> {

    @ManagedProperty(value = "#{gameBean}")
    private GameBean gameBean;

    public void setGameBean(GameBean gameBean) {
        this.gameBean = gameBean;
        super.setEntityBean(gameBean);
    }

    public AbstractGameListBean() {
        super("date");
    }

    public String displayGame() {
        return null;
    }

}
