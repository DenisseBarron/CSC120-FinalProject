import java.util.Scanner;

public class Tent {
    private static final Scanner scanner = new Scanner(System.in);
    private boolean batteriesCollected = false; // Track if batteries are collected

    // Method to explore the Tent location
    public boolean explore(User user) {
        System.out.println("You are inside the tent. You noticed a flashlight left behind.");
        System.out.println("Would you like to pick it up? (yes/no)");
        String choice = scanner.next();

        // Handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            user.useraddInventory("Flashlight");
            System.out.println("Flashlight has been added to your inventory.");
            return true; // Flashlight collected
        } else {
            System.out.println("You decided not to pick up the flashlight...");
            return false; // Flashlight not collected
        }
    }

    // Method to explore the Tent location on Day 5
    public boolean exploreDay5(User user) {
        System.out.println("You are inside the tent. You notice a pack of batteries left behind.");
        System.out.println("Would you like to pick them up? (yes/no)");
        String choice = scanner.next();

        // Handle user's choice
        if (choice.equalsIgnoreCase("yes")) {
            user.useraddInventory("Batteries");
            batteriesCollected = true; // Mark batteries as collected
            System.out.println("Batteries have been added to your inventory.");
            return true; // Batteries collected
        } else {
            System.out.println("You decided not to pick up the batteries...");
            return false; // Batteries not collected
        }
    }

    // Method to check if batteries are collected
    public boolean hasBatteries() {
        return batteriesCollected;
    }
}
