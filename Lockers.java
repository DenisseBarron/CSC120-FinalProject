import java.util.Scanner;
// import java.util.Hashtable;

public class Lockers {
    private static final Scanner scanner = new Scanner(System.in);

    //Method to explore the firepit location
    public boolean explore(User user) {
        System.out.println("You are inside the lockers. You noticed some warm clothes left behind. Would you like to pick them up? (yes/no)");
        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            user.useraddInventory("Warm clothes");
            System.out.println("Warm clothes has been added to your inventory.");
            return true; // Warm clothes collected
        } else {
        System.out.println("You decided to not pick up the warm clothes...");
        return false; // Warm clothes not collected
        }
    }
}
