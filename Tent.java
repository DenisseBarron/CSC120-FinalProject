import java.util.Scanner;
// import java.util.Hashtable;

public class Tent {
    private static final Scanner scanner = new Scanner(System.in);
    
    //Method to explore the Tent location
    public boolean explore(User user) {
        System.out.println("You are inside the tent. You noticed a flashlight left behind.");
        System.out.println("Would you like to pick it up? (yes/no)");
        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            user.useraddInventory("Flashlight");
            System.out.println("Flashlight has been added to your inventory.");
            return true; // Flashlight collected
        } else {
        System.out.println("You decided to not pick up the flashlight...");
        return false; // Flashlight not collected
        }
    }
}