import java.util.Scanner;
import java.util.Hashtable;

public class Kitchen {
    private static final Scanner scanner = new Scanner(System.in);
    private Hashtable<String, Boolean> location;

    public Kitchen (){
        this.location = new Hashtable<String, Boolean>();
        location.put("Kitchen", false);
    }

    //Method to explore the firepit location
    public static void explore() {
        //location.put("Kitchen", false);
        System.out.println("You are inside the kitchen. \n" +
        "There is a large cooler in the corner. \n" +
        "Would you like to approach it? (yes/no)");
        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            System.out.println("You walk towards it and open it \n" +
            "The smell of rotten meat fills the room and flies emerge from the cooler \n" +
            "Startled you close the cooler and take a step back, and continue to look for other food \n" +
            "You find a couple cans of corn, fruit, pasta, marshmallow fluff, and spam in the pantry \n" +
            "You can only pick one can for now. Which one would you take?");
            choice = scanner.next();

            if (choice.equalsIgnoreCase("corn"));
            System.out.println();            
            SurvivalGame.itemsCollected++; //Increment items collected counter in main class
        }

        System.out.println("Choose place to explore...");
}
}
