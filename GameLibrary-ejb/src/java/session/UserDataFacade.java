/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Game_;
import entity.UserData;
import entity.UserData_;
import entity.User_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import session.abstraction.AbstractFacade;
import session.tool.QueryHelpers;

/**
 *
 * @author XRC_7331
 */
@Stateless
public class UserDataFacade extends AbstractFacade<UserData> {
    @PersistenceContext(unitName = "GameLibrary-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserDataFacade() {
        super(UserData.class);
    }

    public UserData find(String gameName, String username) {
        QueryHelpers qh = super.getQueryHelpers();
        CriteriaBuilder cb = qh.getCriteriaBuilder();
        CriteriaQuery cq = qh.getCriteriaQuery();
        Root root = qh.getRoot();

        cq.select(root);
        cq.where(
                cb.equal(root.join(UserData_.game).get(Game_.name), gameName),
                cb.equal(root.join(UserData_.user).get(User_.name), username)
        );

        UserData result = null;
        try {
            result = (UserData) em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
        }

        return result;
    }

}
