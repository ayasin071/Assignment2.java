package storeTest;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import model.Puzzles;
public class PuzzlesTest {
private Puzzles puzzle;
@Before
public void setUp() {
	puzzle = new Puzzles();
	}
@Test
	public void testGetPuzzletype() {
	puzzle.setPuzzletype("Jigsaw");
	assertEquals("Jigsaw", puzzle.getPuzzletype());
	}
@Test
public void testSetPuzzletype() {
puzzle.setPuzzletype("Crossword");
assertEquals("Crossword", puzzle.getPuzzletype());
}
}
