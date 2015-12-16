import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {

        double totalAmount = calculateTotalAmount();

        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rental.calculateLineAmount()) + "\n";

        }
        result += "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(totalFrequentRenterPoints()) + " frequent renter points\n";

        return result;
    }

    private double calculateTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.calculateLineAmount();
        }
        return totalAmount;
    }

    private int totalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints = rental.calculateFrequentRenterPoints(frequentRenterPoints);
        }
        return frequentRenterPoints;
    }
}
