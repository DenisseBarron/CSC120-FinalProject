import java.util.Scanner;

public class Lockers {
    private static final Scanner scanner = new Scanner(System.in);
    private boolean radioCollected = false; // Track if radio is collected

    // Method to explore the lockers location
    public boolean explore(User user) {
        System.out.println("You are inside the lockers. You noticed some warm clothes left behind. Would you like to pick them up? (yes/no)");
        String choice = scanner.next();

        // Handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            user.useraddInventory("Warm clothes");
            System.out.println("Warm clothes has been added to your inventory.");
            return true; // Warm clothes collected
        } else {
            System.out.println("You decided to not pick up the warm clothes...");
            return false; // Warm clothes not collected
        }
    }

    // Method to explore the lockers location on Day 5
    public boolean exploreDay5(User user) {
        System.out.println("You are inside the lockers. You notice a radio hidden in one of the lockers.");
        System.out.println("Would you like to pick it up? (yes/no)");
        String choice = scanner.next();

        // Handle user's choice
        if (choice.equalsIgnoreCase("yes")) {
            user.useraddInventory("Radio");
            radioCollected = true; // Mark radio as collected
            System.out.println("Radio has been added to your inventory.");
            return true; // Radio collected
        } else {
            System.out.println("You decided not to pick up the radio...");
            return false; // Radio not collected
        }
    }

    // Method to check if radio is collected
    public boolean hasRadio() {
        return radioCollected;
    }
}

