import java.util.Scanner;
// import java.util.Hashtable;

public class Lake {
    private static final Scanner scanner = new Scanner(System.in);

    //Method to explore the firepit location
    public static void explore() {
        System.out.println("You are by the lake. It is cold and humid but you really need water. \n" +
        "Would you like to pick them up? (yes/no)");
        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            System.out.println("Item collected: Water"); // needs to be added to inventory
            SurvivalGame.itemsCollected++; //Increment items collected counter in main class
        }

        System.out.println("Choose a resource...");
}
}
