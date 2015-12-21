import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Statement {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Statement(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String generate() {
        return format(statementEntries());
    }


    private String format(List<String> entries) {
        return String.join("\n", entries) + "\n";
    }

    private List<String> statementEntries() {
        return Arrays.asList(header(), rentalEntries(), totalCharge(), totalPoints());
    }

    private String header() {
        return "Rental Record for " + name;
    }

    private String rentalEntries() {
        ArrayList<String> entries = new ArrayList();
        for ( Rental rental : rentals) {
            entries.add(rentalEntry(rental));
        }
        return String.join("\n", entries);
    }

    private String totalCharge() {
        return "You owed " + countTotalCharge();
    }

    private String totalPoints() {
        return "You earned " + totalFrequentRenterPoints() + " frequent renter points";
    }

    private String rentalEntry(Rental rental) {
        return "\t" + rental.getTitle() + "\t" + rental.rentalCharge();
    }

    private double countTotalCharge() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.rentalCharge();
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
