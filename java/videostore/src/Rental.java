public class Rental {
    private Movie movie;
    private int daysRented;
    private static final int BASE_FREQUENTER_POINT = 1;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double calculateCharge() {
        return movie.calculateCharge(daysRented);
    }

    public int calculateFrequentRenterPoints() {
        return BASE_FREQUENTER_POINT + bonusPoints();
    }

    private int bonusPoints() {
        int points = 0;
        if (isDueBonusPoints()) {
            points++;
        }
        return points;
    }

    private boolean isDueBonusPoints() {
        return movie.qualifiesForBonusPoints() && meetsMinRentalDuration();
    }

    private boolean meetsMinRentalDuration() {
        return daysRented > 1;
    }

    public String getTitle() {
        return movie.getTitle();
    }
}
