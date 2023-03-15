package storeTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ToyStoreTest {
	 
private final InputStream systemIn = System.in;
	 private ByteArrayInputStream testIn;
	 @BeforeEach
	 public void setUp() {
	 // Prepare input for the test method
	 String input = "5\n3\n";
	 testIn = new ByteArrayInputStream(input.getBytes());
	 System.setIn(testIn);
	 }
	 @AfterEach
	 public void tearDown() {
	 // Restore normal input stream
	 System.setIn(systemIn);
	 }
	 @Test
	 public void testShowMainMenu() {
	 ToyStore toyStore = new ToyStore();
	 int expected = 3;
	 int actual = toyStore.showmainmenu();
	 assertEquals(expected, actual);
	 }
}