import java.util.Scanner;

public class Backstage {
    private static final Scanner scanner = new Scanner(System.in);

    //Method to explore the firepit location
    public static void explore() {
        System.out.println("You are at the firepit. You noticed some matches left behind. Would you like to pick them up? (yes/no)");
        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            System.out.println("Item collected: Matches");
            SurvivalGame.itemsCollected++; //Increment items collected counter in main class
        }

        System.out.println("Returning to start.");
}
}