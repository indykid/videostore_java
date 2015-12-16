import java.util.ArrayList;
import java.util.Arrays;

public class Customer {

    private String name;
    private ArrayList<Rental> rentals = new ArrayList<>();
    private static final String NEW_LINE = "\n";
    private static final String INDENTATION = "\t";

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        String[] entries = new String[]{header(), rentalsBreakdown(), total(), pointsTotal()};
        return String.join(NEW_LINE, Arrays.asList(entries)) + NEW_LINE;
    }

    public String getName() {
        return name;
    }


    private String header() {
        return "Rental Record for " + getName();
    }

    private String rentalsBreakdown() {
        ArrayList<String> lineEntries = new ArrayList<>();
        for (Rental rental : rentals) {
            lineEntries.add(lineEntry(rental));
        }
        return String.join(NEW_LINE, lineEntries);
    }

    private String lineEntry(Rental rental) {
        return INDENTATION + rental.getTitle() + INDENTATION
                + rental.calculateLineAmount();
    }

    private String total() {
        return "You owed " + calculateTotalAmount();
    }

    private String pointsTotal() {
        return "You earned " + totalFrequentRenterPoints() + " frequent renter points";
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
