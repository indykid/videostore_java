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

    public Movie getMovie() {
        return movie;
    }

    double calculateLineAmount() {
        double lineAmount = 0;

        switch (getMovie().getPriceCode()) {
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
}
