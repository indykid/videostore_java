import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoStoreTest {

    private final String newReleaseTitle = "New Release";
    private final String childrensTitle = "Childrens";
    private final String regularTitle = "Regular";
    private final Movie newReleaseMovie = new Movie(newReleaseTitle, Movie.NEW_RELEASE);
    private final Movie childrensMovie = new Movie(childrensTitle, Movie.CHILDRENS);
    private final Movie regularMovie = new Movie(regularTitle, Movie.REGULAR);
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Fred");
    }

    @Test
    public void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(newReleaseMovie, 3));
        assertEquals("Rental Record for Fred\n\tNew Release\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", customer.statement());
    }

    @Test
    public void testDualNewReleaseStatement() {
        customer.addRental(new Rental(newReleaseMovie, 3));
        customer.addRental(new Rental(newReleaseMovie, 3));
        assertEquals("Rental Record for Fred\n\tNew Release\t9.0\n\tNew Release\t9.0\nYou owed 18.0\nYou earned 4 frequent " +
                "renter points\n", customer.statement());
    }

    @Test
    public void testSingleChildrensStatement() {
        customer.addRental(new Rental(childrensMovie, 3));
        assertEquals("Rental Record for Fred\n\tChildrens\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", customer.statement());
    }

    @Test
    public void testMultipleRegularStatement() {
        customer.addRental(new Rental(regularMovie, 1));
        customer.addRental(new Rental(regularMovie, 2));
        customer.addRental(new Rental(regularMovie, 3));

        assertEquals("Rental Record for Fred\n\tRegular\t2.0\n\tRegular\t2.0\n\tRegular\t3.5\nYou owed 7" +
                ".5\nYou " +
                "earned 3 frequent renter points\n", customer.statement());
    }

}
