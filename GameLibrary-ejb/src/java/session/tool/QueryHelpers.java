/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.tool;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author XRC_7331
 */
public class QueryHelpers<T> {

    private final CriteriaBuilder criteriaBuilder;
    private final CriteriaQuery<T> criteriaQuery;
    private final Root<T> root;

    public QueryHelpers(EntityManager em, Class<T> entityClass) {

        criteriaBuilder = em.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(entityClass);
        root = criteriaQuery.from(entityClass);
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return criteriaBuilder;
    }

    public CriteriaQuery<T> getCriteriaQuery() {
        return criteriaQuery;
    }

    public Root<T> getRoot() {
        return root;
    }


}
