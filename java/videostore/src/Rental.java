public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    double calculateLineAmount() {
        double lineAmount = 0;

        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                lineAmount += 2;
                if (getDaysRented() > 2)
                    lineAmount += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                lineAmount += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                lineAmount += 1.5;
                if (getDaysRented() > 3)
                    lineAmount += (getDaysRented() - 3) * 1.5;
                break;
        }
        return lineAmount;
    }

    int calculateFrequentRenterPoints() {
        int basePoint = 1;
        return basePoint + bonusPoints();
    }

    private int bonusPoints() {
        int points = 0;
        if (isDueBonusPoints()) {
            points++;
        }
        return points;
    }

    private boolean isDueBonusPoints() {
        return movie.getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1;
    }

    String getTitle() {
        return movie.getTitle();
    }
}
