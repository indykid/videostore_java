public class NewReleasePriceCode extends PriceCode {

    public int calculateFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }

    @Override
    public double calculateCharge(int daysRented) {
        return daysRented * 3;
    }
}
