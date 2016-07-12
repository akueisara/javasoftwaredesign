package assignment.week3;

/**
 * Generating Random Text
 * Assignment 1: MarkovZero and MarkovOne
 * 
 * @author Kuei
 * @version July 11, 2016
 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MarkovOneTest {
	private MarkovOne mo;
	private String st;

	@Before
	public void setUp() throws Exception {
		mo = new MarkovOne();
		st = "this is a test yes this is a test.";
		mo.setTraining(st);
	}

	@After
	public void tearDown() throws Exception {
		mo = null;
	}

	@Test
	public void getFollowsTest() {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("h");
		list1.add("e");
		list1.add(" ");
		list1.add("h");
		list1.add("e");
		list1.add(".");
		assertEquals(list1 ,mo.getFollows("t") );
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("s");
		list2.add("s");
		list2.add("s");
		assertEquals(list2 ,mo.getFollows("e") );
		
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("t");
		list3.add(" ");
		list3.add("t");
		assertEquals(list3 ,mo.getFollows("es") );
	}

}
