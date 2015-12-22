public class NewReleasePriceCode extends PriceCode {

    private static final int BASE_RATE = 3;
    private static final int BONUS_POINT = 2;

    public int calculateFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? BONUS_POINT : BASE_POINT;
    }

    @Override
    public double calculateCharge(int daysRented) {
        return daysRented * BASE_RATE;
    }
}
