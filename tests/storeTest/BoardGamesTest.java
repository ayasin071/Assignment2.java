package storeTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.BoardGames;

public class BoardGamesTest {

	@Test
	public void testGetSetMaxPlayers() {
		BoardGames game = new BoardGames();
		game.setMaxPlayers(4);
		assertEquals(4, game.getMaxPlayers());
	}

	@Test
	public void testGetSetMinPlayers() {
		BoardGames game = new BoardGames();
		game.setMinPlayers(2);
		assertEquals(2, game.getMinPlayers());
	}

	@Test
	public void testGetSetDesigner() {
		BoardGames game = new BoardGames();
		game.setDesigner("Some Designer");
		assertEquals("Some Designer", game.getDesigner());
	}

}