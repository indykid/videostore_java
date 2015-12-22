public class RegularPriceCode extends PriceCode {

    private static final double BASE_RATE = 2;
    private static final double EXCESS_RATE = 1.5;
    private static final int INCLUSIVE_DAYS = 2;

    @Override
    public double calculateCharge(int daysRented) {
        return daysRented > INCLUSIVE_DAYS ? chargeFor(daysRented) : BASE_RATE;
    }

    private double chargeFor(int daysRented) {
        return BASE_RATE + excessFor(daysRented - INCLUSIVE_DAYS);
    }

    private double excessFor(int days) {
        return days * EXCESS_RATE;
    }
}
