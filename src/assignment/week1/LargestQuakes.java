package assignment.week1;

import java.util.ArrayList;

public class LargestQuakes {
	public void findLargestQuakes(){
		EarthQuakeParser parser = new EarthQuakeParser();
//		String source = "data/nov20quakedatasmall.atom";
		String source = "data/nov20quakedata.atom";
		//String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		System.out.println("read data for "+list.size());
		//int index = indexOfLargest(list);
		//System.out.println(list.get(index));
		ArrayList<QuakeEntry> large = getLargest(list,5);
//		ArrayList<QuakeEntry> large = getLargest(list,3);
		for(int k=0; k < large.size(); k++){
			QuakeEntry entry = large.get(k);
			System.out.println(entry);
		}
	}

	public int indexOfLargest(ArrayList<QuakeEntry> data){
		ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(data);
		int largeIndex = 0;
		double maxMagnitude = 0.0;
		for(int k=1; k < copy.size(); k++) {
			QuakeEntry quake = copy.get(k);
			double mag = quake.getMagnitude();
			if(mag > maxMagnitude) {
				largeIndex = k;
				maxMagnitude = mag;
			}
		}
		return largeIndex;
	}

	public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
		ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
		ArrayList<QuakeEntry> result = new ArrayList<QuakeEntry>();
		if(howMany > copy.size()) 
			howMany = copy.size();
		int largeIndex = 0;
		for(int j=0; j<howMany; j++){
			largeIndex = indexOfLargest(copy);
			result.add(copy.get(largeIndex));
			copy.remove(largeIndex);
		}
		return result;
	}
}
