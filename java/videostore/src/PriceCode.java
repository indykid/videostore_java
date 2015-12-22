public abstract class PriceCode {

    public int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }

    public abstract double calculateCharge(int daysRented);
}
