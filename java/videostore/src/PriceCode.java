public abstract class PriceCode {

    public static final int BONUS_CODE = 1;
    protected int code;

    public boolean isBonus() {
        return code == BONUS_CODE;
    }

    public abstract double calculateCharge(int daysRented);
}
