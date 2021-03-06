/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entity.Game;
import java.util.Collection;
import java.util.LinkedList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import jsf.abstraction.AbstractGameListBean;

/**
 *
 * @author XRC_7331
 */
@ManagedBean
@ViewScoped
public class AuthUserDistributedGamesListBean extends AbstractGameListBean {

    @ManagedProperty(value = "#{authenticationBean}")
    private AuthenticationBean authenticationBean;

    public void setAuthenticationBean(AuthenticationBean authenticationBean) {
        this.authenticationBean = authenticationBean;
    }

    /**
     * Creates a new instance of DistributedGamesListBean
     */
    public AuthUserDistributedGamesListBean() {
        super();
    }

    @Override
    protected Collection<Game> getSpecificItems() {
        return new LinkedList(authenticationBean.getUser().getDistributedGames());
    }

}
