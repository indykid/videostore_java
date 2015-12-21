public class RegularPriceCode extends PriceCode {

    public RegularPriceCode() {
        this.code = 0;
    }

    @Override
    public double calculateCharge(int daysRented) {
        double rentalCharge = 2;
        if (daysRented > 2)
            rentalCharge += (daysRented - 2) * 1.5;
        return rentalCharge;
    }
}
