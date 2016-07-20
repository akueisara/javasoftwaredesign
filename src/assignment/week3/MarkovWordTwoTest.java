package assignment.week3;

/**
 * Word N-Grams
 * Assignment 2: MarkovWordTwo
 * 
 * @author Kuei
 * @version July 20, 2016
 */

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MarkovWordTwoTest {
	private MarkovWordTwo mwt;

	@Before
	public void setUp() throws Exception {
		mwt = new MarkovWordTwo();
	}

	@After
	public void tearDown() throws Exception {
		mwt = null;
	}

	@Test
	public void testIndexOfTest() {
		PrintStream original = System.out;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		mwt.testIndexOf();
		assertEquals("0\n1\n6\n", outContent.toString());
		System.setOut(original);

	}

}
