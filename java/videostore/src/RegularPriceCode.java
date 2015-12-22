public class RegularPriceCode extends PriceCode {

    private static final int INCLUSIVE_DAYS = 2;
    private static final double BASE_RATE = 2;
    private static final double EXCESS_RATE = 1.5;

    @Override
    public double calculateCharge(int daysRented) {
        return daysRented > INCLUSIVE_DAYS ? chargeFor(daysRented) : BASE_RATE;
    }

    private double chargeFor(int daysRented) {
        return BASE_RATE + excessFor(daysRented);
    }

    private double excessFor(int daysRented) {
        return (daysRented - INCLUSIVE_DAYS) * EXCESS_RATE;
    }
}
