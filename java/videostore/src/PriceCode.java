public abstract class PriceCode {

    protected static final int BASE_POINT = 1;

    public int calculateFrequentRenterPoints(int daysRented) {
        return BASE_POINT;
    }

    public abstract double calculateCharge(int daysRented);
}
