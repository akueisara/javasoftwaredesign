package assignment.week3;

/**
 * Word N-Grams
 * Assignment 1: Generating Random Words with Prediction
 * 
 * @author Kuei
 * @version July 20, 2016
 */

import static org.junit.Assert.*;

import java.io.*;
import org.junit.*;


public class MarkovWordOneTest {
	private MarkovWordOne mwo;

	@Before
	public void setUp() throws Exception {
		mwo = new MarkovWordOne();	
	}

	@After
	public void tearDown() throws Exception {
		mwo = null;
	}

	@Test
	public void testIndexOfTest() {
		PrintStream original = System.out;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		mwo.testIndexOf();
		assertEquals("0\n6\n-1\n-1\n9\n10\n", outContent.toString());
		System.setOut(original);
	}

}
