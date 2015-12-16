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

        String result = "";
        result += "Rental Record for " + getName() + "\n";
        result = rentalBreakdown(result);
        result += "You owed " + String.valueOf(calculateTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(totalFrequentRenterPoints()) + " frequent renter points\n";

        return result;
    }

    private String rentalBreakdown(String result) {
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rental.calculateLineAmount()) + "\n";
        }
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
