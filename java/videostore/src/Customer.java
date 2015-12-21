import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();
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
        String result = "Rental Record for " + getName() + "\n";

        result += lineEntries();

        result += "You owed " + getTotalAmount() + "\n";
        result += "You earned " + totalFrequentRenterPoints() + " frequent renter points\n";

        return result;
    }

    private String lineEntries() {
        String result = "";
        for ( Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + rental.rentalAmount() + "\n";
        }
        return result;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.rentalAmount();
        }
        return totalAmount;
    }

    private int totalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.calculateFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }
}
