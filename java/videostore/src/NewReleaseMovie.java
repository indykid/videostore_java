public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title, NEW_RELEASE);
    }

    @Override
    public double calculateCharge(int daysRented) {
        return daysRented * 3;
    }
}
