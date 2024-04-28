import java.util.Scanner;
// import java.util.Hashtable;

public class Firepit {
    private static final Scanner scanner = new Scanner(System.in);

    //Method to explore the firepit location
    public boolean explore(User user) {
        System.out.println("You are at the firepit. You noticed some matches left behind. \n" +
        "Would you like to pick them up? (yes/no)");

        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            user.useraddInventory("Matches");
            System.out.println("Matches have been added to your inventory.");
            return true; // Matches collected
        } else {
        System.out.println("You decided to not pick the matches...");
        return false; // Matches not collected
        }
    }
}