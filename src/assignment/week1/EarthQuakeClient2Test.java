package assignment.week1;

/**
 * Assignment
 * Implementing Filters
 * 
 * @version July 7, 2016
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EarthQuakeClient2Test {
	private EarthQuakeClient2 eq;

	@Before
	public void setUp() throws Exception {
		this.eq = new EarthQuakeClient2();
	}

	@After
	public void tearDown() throws Exception {
		this.eq = null;
	}

	@Test
	public void quakesWithFilterTest() {
		eq.quakesWithFilter(); 
	}

	@Test
	public void testMatchAllFilter(){
		eq.testMatchAllFilter();
	}
}
