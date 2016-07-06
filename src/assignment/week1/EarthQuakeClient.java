package assignment.week1;

/**
 * Assignment
 * Filtering by Magnitude and Distance
 * Filtering by Depth
 * Filtering by Phrase in Title
 * 
 * @version July 3, 2016
 */

import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
	public EarthQuakeClient() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
			double magMin) {
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		// TODO
		for (QuakeEntry qe: quakeData) {
			if (qe.getMagnitude() > magMin) {
				answer.add(qe);
			}
		}
		return answer;
	}

	public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, 
			double distMax, Location from) {
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		// TODO
		for (QuakeEntry qe: quakeData) {
			if (qe.getLocation().distanceTo(from) < distMax) {
				answer.add(qe);
			}
		}

		return answer;
	}

	public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, 
			double minDepth, double maxDepth) {
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		for (QuakeEntry qe: quakeData) {
			if (qe.getDepth() > minDepth && qe.getDepth() < maxDepth) {
				answer.add(qe);
			}
		}
		return answer;
	}

	public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData,
			String indicator, String phrase){
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		
		if(indicator.equals("start")) {
			for (QuakeEntry qe: quakeData) {
				if (qe.getInfo().startsWith(phrase)) {
					answer.add(qe);
				}
			}
		}
		else if (indicator.equals("any")) {
			for (QuakeEntry qe: quakeData) {
				if (qe.getInfo().contains(phrase)) {
					answer.add(qe);
				}
			}
			
		}
		else if (indicator.equals("end")) {
			for (QuakeEntry qe: quakeData) {
				if (qe.getInfo().endsWith(phrase)) {
					answer.add(qe);
				}
			}
			
		}
		return answer;
	}

	public void dumpCSV(ArrayList<QuakeEntry> list){
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
					qe.getLocation().getLatitude(),
					qe.getLocation().getLongitude(),
					qe.getMagnitude(),
					qe.getInfo());
		}

	}

	public void bigQuakes() {
		EarthQuakeParser parser = new EarthQuakeParser();
		//String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		String source = "data/nov20quakedatasmall.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		System.out.println("read data for "+list.size()+" quakes");

		//      for (QuakeEntry qe : list) {
		//      	if (qe.getMagnitude() > 5.0 ) {
		//        		System.out.println(qe);
		//        	}
		//      }
		ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
		for (QuakeEntry qe : listBig) {
			System.out.println(qe);
		}

		System.out.println("Found " + listBig.size() + " quakes that match that criteria\n");
	}

	public void closeToMe(){
		EarthQuakeParser parser = new EarthQuakeParser();
		//        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		String source = "data/nov20quakedatasmall.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		System.out.println("read data for "+list.size()+" quakes");

		// This location is Durham, NC
		// Location city = new Location(35.988, -78.907);

		// This location is Bridgeport, CA
		Location city =  new Location(38.17, -118.82);

		ArrayList<QuakeEntry> listClose = filterByDistanceFrom(list, 1000*1000, city);
		for (QuakeEntry qe : listClose) {
			System.out.println(qe.getLocation().distanceTo(city)/1000.0 + " " + qe.getInfo());
		}

		System.out.println("Found " + listClose.size() + " quakes that match that criteria\n");
	}

	public void quakesOfDepth(){
		EarthQuakeParser parser = new EarthQuakeParser();
		// String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		String source = "data/nov20quakedatasmall.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		System.out.println("read data for "+list.size()+" quakes");
		double minDepth = -10000.0;
		double maxDepth = -5000.0;
		System.out.println("Find quakes with depth between " + minDepth + " and " + maxDepth);

		ArrayList<QuakeEntry> listDeep = filterByDepth(list, minDepth, maxDepth);
		for (QuakeEntry qe : listDeep) {
			System.out.println(qe);
		}

		System.out.println("Found " + listDeep.size() + " quakes that match that criteria\n");
	}
	
	public void quakesByPhrase(){
		EarthQuakeParser parser = new EarthQuakeParser();
		// String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		String source = "data/nov20quakedatasmall.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		System.out.println("read data for "+list.size()+" quakes");
//		String indicator = "end";
//		String phrase = "California";
//		String indicator = "any";
//		String phrase = "Can";		
		String indicator = "start";
		String phrase = "Explosion";
		ArrayList<QuakeEntry> listCalfornia = filterByPhrase(list, indicator , phrase);
		for (QuakeEntry qe :  listCalfornia) {
			System.out.println(qe);
		}

		System.out.println("Found " +  listCalfornia.size() + " quakes that match " + phrase  + " at " + indicator + "\n");
		
	}

	public void createCSV(){
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "data/nov20quakedatasmall.atom";
		//String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		dumpCSV(list);
		System.out.println("# quakes read: " + list.size());
		for (QuakeEntry qe : list) {
			System.out.println(qe);
		}
	}

}
