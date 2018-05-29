/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.abstraction;

public interface IEntityBean<T> {
    String preparePage(T entity);
}
