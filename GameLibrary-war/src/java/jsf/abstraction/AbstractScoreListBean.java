/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.abstraction;

import entity.Score;
import javax.faces.bean.ManagedProperty;
import jsf.UserBean;

public abstract class AbstractScoreListBean extends AbstractEntityListBean<Score> {

    private static final String DEF_SHOW = "10";

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public AbstractScoreListBean() {
        super("score");
        setMax(DEF_SHOW);
    }

    public final String userSelected() {
        return userBean.preparePage(((Score) items.getRowData()).getUserData().getUser());
    }
}
