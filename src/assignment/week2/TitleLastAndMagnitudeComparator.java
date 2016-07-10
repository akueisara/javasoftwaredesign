package assignment.week2;

import java.util.Comparator;

/**
 * Sorting at Scale
 * Assignment 3: Last Word in Title Comparator
 * 
 * @version July 10, 2016
 */

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
	public int compare(QuakeEntry qe1, QuakeEntry qe2) {
		String qe1LastWord = qe1.getInfo().substring(qe1.getInfo().lastIndexOf(" ")+1);
		String qe2LastWord = qe2.getInfo().substring(qe2.getInfo().lastIndexOf(" ")+1);
        if(qe1LastWord.compareTo(qe2LastWord)>0)
        	return 1;
        else if (qe1LastWord.compareTo(qe2LastWord)<0)
        	return -1;
        else
        	return Double.compare(qe1.getMagnitude(), qe2.getMagnitude());
    }
}
