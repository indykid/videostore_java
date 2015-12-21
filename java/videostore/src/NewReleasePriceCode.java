public class NewReleasePriceCode extends PriceCode {

    public NewReleasePriceCode() {
        this.code = 1;
    }

    @Override
    public double calculateCharge(int daysRented) {
        return daysRented * 3;
    }
}
