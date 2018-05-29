/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool.comparator;

import entity.abstraction.IScored;
import java.util.Comparator;

public class ScoreComparator<T extends IScored> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        IScored score1 = (IScored) o1;
        IScored score2 = (IScored) o2;

        int result = Integer.compare(score2.getScoreValue(), score1.getScoreValue());
        if (result == 0) {
            result = score1.getCreationDate().compareTo(score2.getCreationDate());
        }

        return result;
    }

}
