import java.util.Scanner;
// import java.util.Hashtable;

public class Lake {
    private static final Scanner scanner = new Scanner(System.in);

    //Method to explore the firepit location
    public boolean explore(User user) {
        System.out.println("You are by the lake. It is cold and humid but you really need water. \n" +
        "Would you like to approach the lake and collect water? (yes/no)");
        String choice = scanner.next();

        //handle user's choice
        if (choice.equalsIgnoreCase("yes")){
            user.useraddInventory("Water"); 
            System.out.println("Water has been added to your inventory.");
            return true; // Water collected
        } else {
            System.out.println("You decided to not take the water...");
            return false; // Water not collected
    }
    }
}
