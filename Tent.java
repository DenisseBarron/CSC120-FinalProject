import java.util.Scanner;
import java.util.Hashtable;

public class Tent {
    private static final Scanner scanner = new Scanner(System.in);
    
    //Method to explore the Tent location
    public static void explore() {
        System.out.println("You are inside the tent. You noticed a flashlight left behind.");
        System.out.println("Would you like to pick it up? (yes/no)");
        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            System.out.println("Item collected: Flashlight");
            SurvivalGame.itemsCollected++; //Increment items collected counter in main class
        }

        System.out.println("Returning to start.");
    }
}