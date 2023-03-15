package storeTest;

import org.junit.Test;

import model.Animals;
import model.Puzzles;
import model.Toys;

import static org.junit.Assert.*;

public class ToysTest {

    @Test
    public void testSetAndGetSerialNumber() {
        Toys toy = new Toys();
        String serialNumber = "ABC123";
        toy.setSerialNumber(serialNumber);
        assertEquals(serialNumber, toy.getSerialNumber());
    }

    @Test
    public void testSetAndGetName() {
        Toys toy = new Toys();
        String name = "Teddy Bear";
        toy.setName(name);
        assertEquals(name, toy.getName());
    }

    @Test
    public void testSetAndGetBrand() {
        Toys toy = new Toys();
        String brand = "Mattel";
        toy.setBrand(brand);
        assertEquals(brand, toy.getBrand());
    }

    @Test
    public void testSetAndGetPrice() {
        Toys toy = new Toys();
        double price = 19.99;
        toy.setPrice(price);
        assertEquals(price, toy.getPrice(), 0.001);
    }

    @Test
    public void testSetAndGetAvailableCount() {
        Toys toy = new Toys();
        int availableCount = 5;
        toy.setAvailableCount(availableCount);
        assertEquals(availableCount, toy.getAvailableCount());
    }

    @Test
    public void testSetAndGetAgeAppropriate() {
        Toys toy = new Toys();
        int ageappropriate = 3;
        toy.setAgeappropriate(ageappropriate);
        assertEquals(ageappropriate, toy.getAgeappropriate());
    }

    @Test
    public void testFormatToScreen() {
        Toys toy = new Animals();
        toy.setSerialNumber("ABC123");
        toy.setName("Fluffy");
        toy.setBrand("PetCo");
        toy.setPrice(9.99);
        toy.setAvailableCount(10);
        toy.setAgeappropriate(3);
        ((Animals) toy).setMaterial("Plush");
        ((Animals) toy).setSize("Small");
        String expected = "category:Animals, SerialNumber:ABC123, Name:Fluffy, Brands:PetCo, Price:9.99, Available Count:10, Age Appropriate:3, Material:Plush, Size:Small";
        assertEquals(expected, toy.formatToScreen());
    }

    @Test
    public void testFormatToFile() {
        Toys toy = new Puzzles();
        toy.setSerialNumber("XYZ789");
        toy.setName("Space Puzzle");
        toy.setBrand("Ravensburger");
        toy.setPrice(14.99);
        toy.setAvailableCount(20);
        toy.setAgeappropriate(8);
        ((Puzzles) toy).setPuzzletype("Jigsaw");
        String expected = "XYZ789;Space Puzzle;Ravensburger;14.99;20;8;Jigsaw";
        assertEquals(expected, toy.formatToFile());
    }

}