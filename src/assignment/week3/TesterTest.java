package assignment.week3;

/**
 * Generating Random Text
 * Assignment 1: MarkovZero and MarkovOne
 * Assignment 2: MarkovFour and MarkovModel
 * 
 * @author Kuei
 * @version July 11, 2016
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesterTest {
	private Tester t;

	@Before
	public void setUp() throws Exception {
		t = new Tester();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void GetFollowstest() {
		t.testGetFollows();
	}
	
	@Test
	public void GetFollowsWithFileTest() {
		t.testGetFollowsWithFile();
	}

}
