package storeTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Figures;

public class FiguresTest {

	private Figures f;

	@Before
	public void setUp() {
		f = new Figures();
	}

	@Test
	public void testSetAndGetClassification() {
		String classification = "Action Figure";
		f.setClassification(classification);
		assertEquals(classification, f.getClassification());
	}

}