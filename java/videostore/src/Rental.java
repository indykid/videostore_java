public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double rentalCharge() {
        return movie.calculateCharge(daysRented);
    }

    public int countFrequentRenterPoints() {
        if (qualifiesForBonusPoints()) return 2;
        return 1;
    }

    public String getTitle() {
        return movie.getTitle();
    }

    private boolean qualifiesForBonusPoints() {
        return movie.isBonusTitle() && daysRented > 1;
    }
}
