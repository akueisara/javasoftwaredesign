package assignment.week1;

/**
 * Assignment
 * Filtering by Magnitude and Distance
 * Filtering by Depth
 * Filtering by Phrase in Title
 * 
 * @version July 3, 2016
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EarthQuakeClientTest {
    private EarthQuakeClient ec;
    
	@Before
	public void setUp() throws Exception {
		this.ec = new EarthQuakeClient();
	}

	@After
	public void tearDown() throws Exception {
		this.ec = null;
	}
	
	@Test
	public void bigQuakesTest(){
		ec.bigQuakes();
	}

	@Test
	public void closeToMeTest(){
		ec.closeToMe();
	}
	
	@Test
	public void quakesOfDepthTest(){
		ec.quakesOfDepth();
	}
	
	@Test
	public void quakesByPhraseTest(){
		ec.quakesByPhrase();
	}

}
