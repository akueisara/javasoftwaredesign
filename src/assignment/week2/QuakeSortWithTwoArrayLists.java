package assignment.week2;

import java.util.*;
import edu.duke.*;

public class QuakeSortWithTwoArrayLists {
    // This is the code from the Video of Selection Sort with Two ArrayLists
    
    public QuakeSortWithTwoArrayLists() {
        // TODO Auto-generated constructor stub
    }
   
    public QuakeEntry getSmallestMagnitude(ArrayList<QuakeEntry> quakes) {
        QuakeEntry min = quakes.get(0);
        for (QuakeEntry q: quakes) {
            if (q.getMagnitude() < min.getMagnitude()) {
                min = q;
            }
        }
        
        return min;
    }
    
    public ArrayList<QuakeEntry> sortByMagnitude(ArrayList<QuakeEntry> in) {
    	// out starts as empty ArrayList
        ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
        // As long as in is not empty
        while(!in.isEmpty()) {
        	// Find smallest element in in (minElement)
            QuakeEntry minElement = getSmallestMagnitude(in);
            // Remove minElement from in
            in.remove(minElement);
            // Add minElement to out
            out.add(minElement);
        }
        // out the answer
        return out;
    }
    
    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        list = sortByMagnitude(list);
        
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
    
    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();     
       // String source = "data/nov20quakedatasmall.atom";
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
	
}
