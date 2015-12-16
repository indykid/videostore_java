public class Rental {
    private Movie movie;
    private int daysRented;
    private static final int BASE_FREQUENTER_POINT = 1;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double calculateLineAmount() {
        double lineAmount = 0;

        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                lineAmount += 2;
                if (daysRented > 2)
                    lineAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                lineAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                lineAmount += 1.5;
                if (daysRented > 3)
                    lineAmount += (daysRented - 3) * 1.5;
                break;
        }
        return lineAmount;
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
