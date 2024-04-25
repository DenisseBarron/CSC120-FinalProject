import java.util.Scanner;
// import java.util.Hashtable;

public class Woods {
    private static final Scanner scanner = new Scanner(System.in);

    //Method to explore the firepit location
    public static void explore() {
        System.out.println("You are inside the woods. \n" +
        "You noticed a shadow pass behind you but decide to ignore it and continue walking... \n" +
        "You see some wood that seems to be dry \n" +
        "Would you like to pick it up? (yes/no)");
        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            System.out.println("Item collected: Woods"); // needs to be added to inventory
            SurvivalGame.itemsCollected++; //Increment items collected counter in main class
        }

        System.out.println("Returning to start.");
}
}
