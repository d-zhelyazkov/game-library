/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import session.tool.QueryHelpers;
import session.abstraction.AbstractNamedEntityFacade;
import entity.User;
import entity.User_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author XRC_7331
 */
@Stateless
public class UserFacade extends AbstractNamedEntityFacade<User> {
    @PersistenceContext(unitName = "GameLibrary-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    public User find(String name, byte[] password) {
        QueryHelpers qh = super.getQueryHelpers();
        CriteriaBuilder cb = qh.getCriteriaBuilder();
        CriteriaQuery cq = qh.getCriteriaQuery();
        Root root = qh.getRoot();

        cq.select(root);
        cq.where(
                cb.equal(root.get(User_.name), name),
                cb.equal(root.get(User_.password), password)
        );

        User result = null;
        try {
            result = (User) em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
        }

        return result;

    }


}
