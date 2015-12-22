public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    public boolean qualifiesForBonusPoints() {
        return getPriceCode() == NEW_RELEASE;
    }

    public double calculateCharge(int daysRented) {
        double lineAmount = 0;
        switch (getPriceCode()) {
            case REGULAR:
                lineAmount += 2;
                if (daysRented > 2)
                    lineAmount += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                lineAmount += daysRented * 3;
                break;
            case CHILDRENS:
                lineAmount += 1.5;
                if (daysRented > 3)
                    lineAmount += (daysRented - 3) * 1.5;
                break;
        }
        return lineAmount;
    }
}
