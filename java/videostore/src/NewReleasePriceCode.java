public class NewReleasePriceCode extends PriceCode {

    private static final int BASE_RATE = 3;

    public int calculateFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }

    @Override
    public double calculateCharge(int daysRented) {
        return daysRented * BASE_RATE;
    }
}
