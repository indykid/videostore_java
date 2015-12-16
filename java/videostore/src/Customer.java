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

    public String statement() {
        return header() + rentalBreakdown() + footer();
    }

    public String getName() {
        return name;
    }


    private String header() {
        return "Rental Record for " + getName() + "\n";
    }

    private String rentalBreakdown() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rental.calculateLineAmount()) + "\n";
        }
        return result;
    }

    private String footer() {
        return total() + pointsTotal();
    }

    private String total() {
        return "You owed " + String.valueOf(calculateTotalAmount()) + "\n";
    }

    private String pointsTotal() {
        return "You earned " + String.valueOf(totalFrequentRenterPoints()) + " frequent renter points\n";
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
