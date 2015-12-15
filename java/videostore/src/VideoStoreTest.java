import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoStoreTest {

    private final String newReleaseTitle = "The Cell";
    private final String childrensTitle = "The Tigger Movie";
    private final String regularTitle = "Eraserhead";

    @Before
    public void setUp() {
        customer = new Customer("Fred");
    }

    @Test
    public void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(new Movie(newReleaseTitle, Movie.NEW_RELEASE), 3));
        assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", customer.statement());
    }

    @Test
    public void testDualNewReleaseStatement() {
        customer.addRental(new Rental(new Movie(newReleaseTitle, Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie(newReleaseTitle, Movie.NEW_RELEASE), 3));
        assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Cell\t9.0\nYou owed 18.0\nYou earned 4 frequent " +
                "renter points\n", customer.statement());
    }

    @Test
    public void testSingleChildrensStatement() {
        customer.addRental(new Rental(new Movie(childrensTitle, Movie.CHILDRENS), 3));
        assertEquals("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", customer.statement());
    }

    @Test
    public void testMultipleRegularStatement() {
        customer.addRental(new Rental(new Movie(regularTitle, Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie(regularTitle, Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie(regularTitle, Movie.REGULAR), 3));

        assertEquals("Rental Record for Fred\n\tEraserhead\t2.0\n\tEraserhead\t2.0\n\tEraserhead\t3.5\nYou owed 7" +
                ".5\nYou " +
                "earned 3 frequent renter points\n", customer.statement());
    }

    private Customer customer;
}
