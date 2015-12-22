public class ChildrensPriceCode extends PriceCode {

    @Override
    public double calculateCharge(int daysRented) {
        double rentalAmount = 1.5;
        if (daysRented > 3)
            rentalAmount += (daysRented - 3) * 1.5;
        return rentalAmount;
    }
}
