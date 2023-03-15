package controller;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import model.Animals;
import model.BoardGames;
import model.Figures;
import model.Puzzles;

public class StoreManagerTest {
	
	private StoreManagerTest toyStore;
	
	@Before
	public void setUp() {
		toyStore = new StoreManagerTest();
	}
	
	@Test
	public void testLoadData() throws Exception {
		toyStore.testLoadData();
		List<Toy> listOfToys = toyStore.getListOfToys();
		assertEquals(4, listOfToys.size());
		
		// Check the first toy is a figure
		assertTrue(listOfToys.get(0) instanceof Figures);
		assertEquals("0001", listOfToys.get(0).getSerialNumber());
		assertEquals("Spiderman Action Figure", listOfToys.get(0).getName());
		assertEquals("Marvel", listOfToys.get(0).getBrand());
		assertEquals(12.99, listOfToys.get(0).getPrice(), 0.01);
		assertEquals(5, listOfToys.get(0).getAvailableCount());
		assertEquals(5, ((Figures)listOfToys.get(0)).getAgeappropriate());
		assertEquals("Superheroes", ((Figures)listOfToys.get(0)).getClassification());
		
		// Check the second toy is an animal
		assertTrue(listOfToys.get(1) instanceof Animals);
		assertEquals("2315", listOfToys.get(1).getSerialNumber());
		assertEquals("Stuffed Panda", listOfToys.get(1).getName());
		assertEquals("IKEA", listOfToys.get(1).getBrand());
		assertEquals(8.99, listOfToys.get(1).getPrice(), 0.01);
		assertEquals(7, listOfToys.get(1).getAvailableCount());
		assertEquals(3, ((Animals)listOfToys.get(1)).getAgeappropriate());
		assertEquals("Polyester", ((Animals)listOfToys.get(1)).getMaterial());
		assertEquals("30cm", ((Animals)listOfToys.get(1)).getSize());
		
		// Check the third toy is a puzzle
		assertTrue(listOfToys.get(2) instanceof Puzzles);
		assertEquals("5012", listOfToys.get(2).getSerialNumber());
		assertEquals("1000 Piece Puzzle - Cityscape", listOfToys.get(2).getName());
		assertEquals("Ravensburger", listOfToys.get(2).getBrand());
		assertEquals(24.99, listOfToys.get(2).getPrice(), 0.01);
		assertEquals(2, listOfToys.get(2).getAvailableCount());
		assertEquals(12, ((Puzzles)listOfToys.get(2)).getAgeappropriate());
		assertEquals("Jigsaw", ((Puzzles)listOfToys.get(2)).getPuzzletype());
		
		// Check the fourth toy is a board game
		assertTrue(listOfToys.get(3) instanceof BoardGames);
		assertEquals("7720", listOfToys.get(3).getSerialNumber());
		assertEquals("Monopoly", listOfToys.get(3).getName());
		assertEquals("Hasbro", listOfToys.get(3).getBrand());
		assertEquals(19.99, listOfToys.get(3).getPrice(), 0.01);
		assertEquals(10, listOfToys.get(3).getAvailableCount());
		assertEquals(8, ((BoardGames)listOfToys.get(3)).getAgeappropriate());
		assertEquals(6, ((BoardGames)listOfToys.get(3)).getMaxPlayers());
	}

	private List<Toy> getListOfToys() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
