package assignment.week1;

/**
 * Assignment
 * Finding the Closest Earthquakes to a Location
 * 
 * @version July 3, 2016
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClosestQuakesTest {
	private ClosestQuakes cq;

	@Before
	public void setUp() throws Exception {
		this.cq = new ClosestQuakes();
	}

	@After
	public void tearDown() throws Exception {
		this.cq = null;
	}

	@Test
	public void test() {
		cq.findClosestQuakes();
	}

}
