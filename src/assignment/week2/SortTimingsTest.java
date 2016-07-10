package assignment.week2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortTimingsTest {
	private SortTimings st;

	@Before
	public void setUp() throws Exception {
		this.st = new SortTimings();
	}

	@After
	public void tearDown() throws Exception {
		this.st = null;
	}

	@Test
	public void test() {
		st.runner();
	}

}
