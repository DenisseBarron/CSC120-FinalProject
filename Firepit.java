import java.util.Scanner;
// import java.util.Hashtable;

public class Firepit {
    private static final Scanner scanner = new Scanner(System.in);

    //Method to explore the firepit location
    public static void explore() {
        System.out.println("You are at the firepit. You noticed some matches left behind. \n" +
        "Would you like to pick them up? (yes/no)");
        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            System.out.println("Item collected: Matches"); // needs to be added to inventory
            SurvivalGame.itemsCollected++; //Increment items collected counter in main class
        }

        System.out.println("Choose a resource...");
    }
}