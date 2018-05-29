/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool.comparator;

import entity.abstraction.INamed;
import java.util.Comparator;

public class NameComparator<T extends INamed> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return ((INamed) o1).getName().compareToIgnoreCase(((INamed) o2).getName());
    }

}
