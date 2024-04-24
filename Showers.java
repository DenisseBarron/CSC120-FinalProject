import java.util.Scanner;
import java.util.Hashtable;

public class Showers {
    private static final Scanner scanner = new Scanner(System.in);

    //Method to explore the firepit location
    public static void explore() {
        System.out.println("You are inside the showers.");
        System.out.println("You noticed the showers seem to be working and try to collect water.");
        System.out.println("Oh no! The water is dirty water");
        System.out.println("Would you still like to collect it? (yes/no)");
        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            System.out.println("Item collected: Dirty Water");
            SurvivalGame.itemsCollected++; //Increment items collected counter in main class
        }

        System.out.println("Returning to start.");
    }
}
