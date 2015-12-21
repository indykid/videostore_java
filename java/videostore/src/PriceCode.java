public abstract class PriceCode {

    protected int code;

    public int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }

    public abstract double calculateCharge(int daysRented);
}
