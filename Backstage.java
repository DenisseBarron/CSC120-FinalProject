import java.util.Scanner;
// import java.util.Hashtable;

public class Backstage {
    private static final Scanner scanner = new Scanner(System.in);

    //Method to explore the firepit location
    public static void explore() {
        System.out.println("You are at the stage of the campsite. \n" + 
        "The floors are creeking and tehre is a strange feeling to it. \n" +
        "Would you like to go backstage? (yes/no)");
        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            System.out.println("You are in the backstage and noticed a large old trunk that is closed. \n" +
            "As you are about to get close t the trunk, something catches your eye...a snipet of an old news paper. \n" +
            "The headline reads '19 year old man disapears at Campers Hollow Camp'");
            // SurvivalGame.itemsCollected++; //Increment items collected counter in main class
        }

        System.out.println("Choose a resource...");
}
}