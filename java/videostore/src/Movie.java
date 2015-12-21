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

    public boolean isBonusTitle() {
        return priceCode.isBonus();
    }

    public double calculateCharge(int daysRented) {
        return priceCode.calculateCharge(daysRented);
    }
}
