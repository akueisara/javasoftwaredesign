package assignment.week2;

/**
 * [Assignment]
 * Sort by Depth
 * Bubble Sort
 * Check for Completion
 * 
 * @version July 9, 2016
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuakeSortInPlaceTest {
	private QuakeSortInPlace qs;
	
	@Before
	public void setUp() throws Exception {
		this.qs = new QuakeSortInPlace();
	}

	@After
	public void tearDown() throws Exception {
		this.qs = null;
	}

	@Test
	public void test() {
		qs.testSort();
	}

}
