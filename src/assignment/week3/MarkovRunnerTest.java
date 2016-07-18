package assignment.week3;

/**
 * Generating Random Text
 * Assignment 1: MarkovZero and MarkovOne
 * Assignment 2: MarkovFour and MarkovModel
 * 
 * @author Kuei
 * @version July 11, 2016
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MarkovRunnerTest {
	private MarkovRunner mr;

	@Before
	public void setUp() throws Exception {
		mr = new MarkovRunner();
	}

	@After
	public void tearDown() throws Exception {
		mr = null;
	}

	@Test
	public void runMarkovZeroTest() {
		mr.runMarkovZero();
	}
	
	@Test
	public void runMarkovOneTest() {
		mr.runMarkovOne();
	}
	
	@Test
	public void runMarkovFourTest() {
		mr.runMarkovFour();
	}
	
	@Test
	public void runMarkovModelTest() {
		mr.runMarkovModel();
	}
}
