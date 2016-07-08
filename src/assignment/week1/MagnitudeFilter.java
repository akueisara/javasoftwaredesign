package assignment.week1;

/**
 * Assignment
 * Implementing Filters
 * 
 * @version July 7, 2016
 */

public class MagnitudeFilter implements Filter {
	private double magMin;
	private double magMax;
	
	public MagnitudeFilter(double min, double max) { 
		magMin = min;
		magMax = max;
	}
	
	public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin && qe.getMagnitude() <= magMax; 
    } 
	
	public String getName(){
		return "MagnitudeFilter";
	}
}
