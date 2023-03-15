package view;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.BoardGames;
import model.Toys;

public class AppMenuTest {

    private AppMenu appMenu;
    private ArrayList<Toys> toys;
    private ArrayList<BoardGames> boardGames;

    @Before
    public void setUp() {
        appMenu = new AppMenu();
        toys = new ArrayList<Toys>();
        boardGames = new ArrayList<BoardGames>();
    }

    @Test
    public void testShowmainmenu() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(1, appMenu.showmainmenu());
    }

    @Test
    public void testShowSubMenu() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(2, appMenu.showSubMenu());
    }

    @Test
    public void testGetSerialNumber() {
        String input = "1234567890\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("1234567890", appMenu.getSerialNumber());
    }

    @Test
    public void testNotValid() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        appMenu.notValid();
    }

    @Test
    public void testGetToyName() {
        String input = "Test Toy\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("Test", appMenu.getToyName());
    }

    @Test
    public void testGetType() {
        String input = "Board Game\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("Board Game", appMenu.getType());
    }

    @Test
    public void testPrintToys() {
        toys.add(new Toys("1234567890", "Test Toy", "Doll", 9.99, 10));
        toys.add(new Toys("0987654321", "Test Board Game", "Board Game", 19.99, 5));
        String expectedOutput = "(1) SN: 1234567890 | Name: Test Toy | Type: Doll | Price: $9.99 | Quantity: 10\n"
                + "(2) SN: 0987654321 | Name: Test Board Game | Type: Board Game | Price: $19.99 | Quantity: 5\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPurchaseListIndex() {
        toys.add(new Toys("1234567890", "Test Toy", "Doll", 9.99, 10));
        toys.add(new Toys("0987654321", "Test Board Game", "Board Game", 19.99, 0));
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(toys.get(0), appMenu.PurchaseListIndex(toys));
    }

    @Test
    public void testRemoveToy() {
        String input = "1234567890\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("1234567890", appMenu.removetoy());
    }

}