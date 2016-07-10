package assignment.week2;

/**
 * Sorting at Scale
 * Assignment 1: compareTo Method
 * Assignment 2: Title Comparator
 * Assignment 3: Last Word in Title Comparator
 * 
 * @version July 10, 2016
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DifferentSortersTest {
	private DifferentSorters ds;

	@Before
	public void setUp() throws Exception {
		this.ds = new DifferentSorters();
	}

	@After
	public void tearDown() throws Exception {
		this.ds = null;
	}

	@Test
	public void sortWithCompareToTest() {
		ds.sortWithCompareTo();
	}
	
	@Test
	public void sortByTitleAndDepthTest() {
		ds.sortByTitleAndDepth();
	}
	
	@Test
	public void sortByLastWordInTitleThenByMagnitudeTest() {
		ds.sortByLastWordInTitleThenByMagnitude();
	}

}
