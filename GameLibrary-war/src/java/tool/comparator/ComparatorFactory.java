/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool.comparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ComparatorFactory {
    private static final ComparatorFactory instance = new ComparatorFactory();

    public static ComparatorFactory getInstance() {
        return instance;
    }

    private final Map<String, Comparator> comparators;

    private ComparatorFactory() {
        comparators = new HashMap();
        comparators.put("date", new DateComparator());
        comparators.put("name", new NameComparator());
        comparators.put("score", new ScoreComparator());
    }

    public Comparator getComparatorByName(String name) {
        return comparators.get(name);
    }
}
