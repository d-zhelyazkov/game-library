/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.abstraction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import tool.comparator.ComparatorFactory;

public abstract class AbstractEntityListBean<T> {
    private static final int DEF_MAX = 0;

    protected DataModel items = null;

    protected String comparatorName;
    private Comparator<T> comparator;
    private IEntityBean<T> entityBean;

    private int max = DEF_MAX;

    public AbstractEntityListBean(String comparatorName) {
        setComparatorName(comparatorName);
    }

    public DataModel getItems() {
        List<T> specificData = new ArrayList(getSpecificItems());
        specificData.sort(comparator);
        if ((max > 0) && (max < specificData.size())) {
            specificData = specificData.subList(0, (max - 1));
        }
        items = new ListDataModel(specificData);
        return items;
    }

    protected abstract Collection<T> getSpecificItems();

    public final String itemSelected() {
        return entityBean.preparePage((T) items.getRowData());
    }

    public final void setComparatorName(String name) {
        comparatorName = name;
        if (comparatorName != null) {
            comparator = ComparatorFactory.getInstance().getComparatorByName(name);
        }
        
    }

    public String getComparatorName() {
        return comparatorName;
    }

    public void setEntityBean(IEntityBean<T> entityBean) {
        this.entityBean = entityBean;
    }

    public void setMax(String s) {
        int givenValue = Integer.parseInt(s);
        max = (givenValue < 0) ? DEF_MAX : givenValue;
    }

    public String getMax() {
        return Integer.toString(max);
    }


}
