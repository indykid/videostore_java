public class Movie {

    private String title;
    private PriceCode priceCode;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public double calculateCharge(int daysRented) {
        return priceCode.calculateCharge(daysRented);
    }

    public int calculateFrequentRenterPoints(int daysRented) {
        return priceCode.calculateFrequentRenterPoints(daysRented);
    }
}
