import java.util.Scanner;
// import java.util.Hashtable;

public class Woods {
    private static final Scanner scanner = new Scanner(System.in);

    //Method to explore the firepit location
    public boolean explore(User user) {
        System.out.println("You are inside the woods. \n" +
        "You noticed a shadow pass behind you but decide to ignore it and continue walking... \n" +
        "You see some wood that seems to be dry \n" +
        "Would you like to pick it up? (yes/no)");
        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            user.useraddInventory("Wood");
            System.out.println("Wood has been added to your inventory.");
            return true; // Wood collected
        } else {
        System.out.println("You decided to not collect wood...");
        return false; // Wood not collected
        }  
    }
}
