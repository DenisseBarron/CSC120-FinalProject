import java.util.Scanner;
// import java.util.Hashtable;

public class Backstage {
    private static final Scanner scanner = new Scanner(System.in);

    //Method to explore the firepit location
    public boolean explore(User user) {
        System.out.println("You are at the stage of the campsite. \n" + 
        "The floors are creeking and tehre is a strange feeling to it. \n" +
        "Would you like to go backstage? (yes/no)");

        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            System.out.println("You are in the backstage and noticed a large old trunk that is closed. \n" +
            "As you are about to get close t the trunk, something catches your eye...a snipet of an old news paper. \n" +
            "The headline reads '19 year old man disapears at Campers Hollow Camp' \n" +
            "Would you like to continue reading? (yes/no)");

            choice = scanner.next();

            if (choice.equalsIgnoreCase("yes")){
            System.out.println("You continue reading... \n" +
            "He was left behing by a group of campers...\n" +
            "A week went by without anyone noticing he had been left behind...\n" +
            "When they came back for him...\n" +
            "He was gone and he was never found...");
        }
        return false; // User explore backstage but did not collect anything
        } else {
        System.out.println("You decided not to go backstage");
        return false; // User did not explore backstage
        }
    }
}