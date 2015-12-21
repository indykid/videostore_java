import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoStoreTest {

    private Statement statement;
    private final Movie newReleaseMovie = new Movie("New Release", Movie.NEW_RELEASE);
    private final Movie childrensMovie = new Movie("Childrens", Movie.CHILDRENS);
    private final Movie regularMovie = new Movie("Regular", Movie.REGULAR);

    @Before
    public void setUp() {
        statement = new Statement("Fred");
    }

    @Test
    public void testSingleNewReleaseStatement() {
        statement.addRental(new Rental(newReleaseMovie, 3));
        assertEquals("Rental Record for Fred\n\tNew Release\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n",
                statement.generate());
    }

    @Test
    public void testDualNewReleaseStatement() {
        statement.addRental(new Rental(newReleaseMovie, 3));
        statement.addRental(new Rental(newReleaseMovie, 3));
        assertEquals("Rental Record for Fred\n\tNew Release\t9.0\n\tNew Release\t9.0\nYou owed 18.0\nYou earned 4 " +
                "frequent " +
                "renter points\n", statement.generate());
    }

    @Test
    public void testSingleChildrensStatement() {
        statement.addRental(new Rental(childrensMovie, 3));
        assertEquals("Rental Record for Fred\n\tChildrens\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n",
                statement.generate());
    }

    @Test
    public void testMultipleRegularStatement() {
        statement.addRental(new Rental(regularMovie, 1));
        statement.addRental(new Rental(regularMovie, 2));
        statement.addRental(new Rental(regularMovie, 3));

        assertEquals("Rental Record for Fred\n\tRegular\t2.0\n\tRegular\t2.0\n\tRegular\t3.5\nYou " +
                "owed 7.5\nYou earned 3 frequent renter points\n", statement.generate());
    }
}
