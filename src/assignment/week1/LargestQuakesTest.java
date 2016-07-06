package assignment.week1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LargestQuakesTest {
	private LargestQuakes lq;

	@Before
	public void setUp() throws Exception {
		this.lq = new LargestQuakes();
	}

	@After
	public void tearDown() throws Exception {
		this.lq = null;
	}

	@Test
	public void indexOfLargestTest() {
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "data/nov20quakedatasmall.atom";
		//String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		int index = lq.indexOfLargest(list);
		assertEquals(3, index);
		assertEquals(5.5, list.get(index).getMagnitude(), 0.0000);
	}
	
	@Test
	public void findLargestQuakesTest() {
		lq.findLargestQuakes();
	}

}
