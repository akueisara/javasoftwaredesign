package assignment.week2;

/**
 * Sorting at Scale
 * Assignment 2: Title Comparator
 * 
 * @version July 10, 2016
 */

import java.util.Comparator;

public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
	public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        if(qe1.getInfo().compareTo(qe2.getInfo())>0)
        	return 1;
        else if (qe1.getInfo().compareTo(qe2.getInfo())<0)
        	return -1;
        else
        	return Double.compare(qe1.getDepth(), qe2.getDepth());
    }
}
