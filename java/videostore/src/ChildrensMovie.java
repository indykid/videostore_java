public class ChildrensMovie extends Movie {

    public ChildrensMovie(String title) {
        super(title, CHILDRENS);
    }

    @Override
    public double calculateCharge(int daysRented) {
        double rentalAmount = 1.5;
        if (daysRented > 3)
            rentalAmount += (daysRented - 3) * 1.5;
        return rentalAmount;
    }
}
