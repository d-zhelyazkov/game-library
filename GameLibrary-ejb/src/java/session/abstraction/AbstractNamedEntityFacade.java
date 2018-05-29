/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.abstraction;

import entity.abstraction.INamed;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import session.tool.QueryHelpers;

public abstract class AbstractNamedEntityFacade<T extends INamed> extends AbstractFacade<T> {

    public AbstractNamedEntityFacade(Class<T> entityClass) {
        super(entityClass);
    }

    public T findByName(String name) {
        QueryHelpers qh = super.getQueryHelpers();
        CriteriaBuilder cb = qh.getCriteriaBuilder();
        CriteriaQuery cq = qh.getCriteriaQuery();
        Root root = qh.getRoot();
        cq.select(root);
        cq.where(cb.equal(root.get("name"), name));

        T result = null;
        try {
            result = (T) getEntityManager().createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
        }

        return result;
    }
}
