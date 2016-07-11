package assignment.week1;

/**
 * Assignment
 * Implementing Filters
 * 
 * @version July 7, 2016
 */

import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
	public EarthQuakeClient2() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		for(QuakeEntry qe : quakeData) { 
			if (f.satisfies(qe)) { 
				answer.add(qe); 
			} 
		} 

		return answer;
	} 

	public void quakesWithFilter() { 
		EarthQuakeParser parser = new EarthQuakeParser(); 
		//String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
//		String source = "data/nov20quakedatasmall.atom";
		String source = "data/nov20quakedata.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);         
		System.out.println("read data for "+list.size()+" quakes");

		// Filter f = new MinMagFilter(4.0); 
//		Filter f1 = new MagnitudeFilter(4.0, 5.0);
//		Filter f2 = new DepthFilter(-35000.0, -12000.0);
//		Location japan = new Location(35.42, 139.43);
//		Filter f1 = new DistanceFilter(japan, 10000000.0);
//		Filter f2 = new PhraseFilter("end", "Japan");
//		Location colorade = new Location(39.7392, -104.9903);
//		Filter f1 = new DistanceFilter(colorade, 1000000.0);
//		Filter f2 = new PhraseFilter("end", "a");		
		Filter f1 = new MagnitudeFilter(3.5, 4.5);
		Filter f2 = new DepthFilter(-55000.0, -20000.0);
		ArrayList<QuakeEntry> m7  = filter(list, f1); 
		m7 = filter(m7, f2); 
		for (QuakeEntry qe: m7) { 
			System.out.println(qe);
		} 
		
		System.out.println("Found " + m7.size() + " quakes that match that criteria\n");
	}

	public void createCSV() {
		EarthQuakeParser parser = new EarthQuakeParser();
		//String source = "../data/nov20quakedata.atom";
		String source = "data/nov20quakedatasmall.atom";
		//String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		dumpCSV(list);
		System.out.println("# quakes read: "+list.size());
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

	public void testMatchAllFilter(){
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "data/nov20quakedata.atom";
//		String source = "data/nov20quakedatasmall.atom";
		//String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		System.out.println("read data for "+list.size()+" quakes");
		
		
		MatchAllFilter maf = new MatchAllFilter();
//		Location Oklahoma = new Location(36.1314, -95.9372);
//		maf.addFilter(new MagnitudeFilter(0.0, 3.0));
//		maf.addFilter(new DistanceFilter(Oklahoma, 10000000.0));
//		maf.addFilter(new PhraseFilter("any", "Ca"));
		
//		maf.addFilter(new MagnitudeFilter(0.0, 2.0));
//		maf.addFilter(new DepthFilter( -100000.0, -10000.0));
//		maf.addFilter(new PhraseFilter("any", "a"));
		
//		maf.addFilter(new MagnitudeFilter(1.0, 4.0));
//		maf.addFilter(new DepthFilter( -180000.0, -30000.0));
//		maf.addFilter(new PhraseFilter("any", "o"));
		
		maf.addFilter(new MagnitudeFilter(0.0, 5.0));
		Location BillundDenmark = new Location(55.7308, 9.1153);
		maf.addFilter(new DistanceFilter(BillundDenmark, 3000000.0));
		maf.addFilter(new PhraseFilter("any", "e"));

		ArrayList<QuakeEntry> m7  = filter(list, maf); 
		for (QuakeEntry qe: m7) { 
			System.out.println(qe);
		} 
		
		System.out.println("Found " + m7.size() + " quakes that match that criteria");
		System.out.println("Filters used are: " + maf.getName() + "\n");
	}
	
	public void testMatchAllFilter2(){
		EarthQuakeParser parser = new EarthQuakeParser();
		//String source = "../data/nov20quakedata.atom";
		String source = "data/nov20quakedatasmall.atom";
		//String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		System.out.println("read data for "+list.size()+" quakes");
		
		MatchAllFilter maf = new MatchAllFilter();
		maf.addFilter(new MagnitudeFilter(0.0, 2.0));
		maf.addFilter(new DepthFilter( -100000.0, -10000.0));
		maf.addFilter(new PhraseFilter("any", "a"));
		ArrayList<QuakeEntry> m7  = filter(list, maf); 
		for (QuakeEntry qe: m7) { 
			System.out.println(qe);
		} 
		System.out.println("Found " + m7.size() + " quakes that match that criteria\n");
	}

}
