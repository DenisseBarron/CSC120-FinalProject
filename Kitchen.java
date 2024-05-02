import java.util.Scanner;
// import java.util.Hashtable;

public class Kitchen {
    private static final Scanner scanner = new Scanner(System.in);

    // Method to explore the kitchen location
    public boolean explore(User user){
        System.out.println("You are inside the kicthen. \n"+
        "There is a large cooler in the corner. It seems to have food. \n" +
        "Would you like to approach it? (yes/no)");

        String choice = scanner.next();

        if(choice.equalsIgnoreCase("yes")){
            System.out.println("You walk towards it and open it... \n"+
            "The smell of rotten meats filld the room and flies emerge from the cooler. \n" +
            "Startled, you close the cooler and take a step back. \n" +
            "You continue to look for other food...");

            System.out.println("You find a couple cans of corn, fruit, pasta, mashmallows, and spam in the pantry. \n" +
            "Would you like to take one? (yes/no)");
            choice = scanner.next();

            if(choice.equalsIgnoreCase("yes")) {
                System.out.println("You can only pick one can for now. \n" +
                "Which one would you take? (corn/fruit/pasta/masrhmallows/spam)");
                choice = scanner.next();

                if (isValidItem(choice)){
                    user.useraddInventory(choice);
                    System.out.println(choice.toUpperCase() + " has been added to your inventory.");
                    return true; // Item successfully collected
                } else {
                    System.out.println("That is not a valid option. Try again");
                }
            } else {
                System.out.println("You decided not to take anything from the kitchen");
                return false;
            }
        } else {
            System.out.println("You decide not to approach the cooler \n"+
            "You keep looking around and find a couple cans of food in the pantry. \n" +
            "Would you like to take one? (yes/no)");
            choice = scanner.next();

            if (choice.equalsIgnoreCase("yes")){
                System.out.println("You can only pick one can for now. \n" +
                "Which one would you take? (corn/fruit/pasta/masrhmallows/spam)");
                choice = scanner.next();

                if (isValidItem(choice)){
                    user.useraddInventory(choice);
                    System.out.println(choice.toUpperCase() + " has been added to your inventory.");
                    return true;
                } else {
                    System.out.println("That is not a valid option. Try again");
                }
            } else {
                System.out.println("You decided not to take anything from the kitchen");
                return false;
            }
        }
        return false; // Default return in case all conditions  fail
    }
    private boolean isValidItem(String item){
        return item.equalsIgnoreCase("corn") ||
               item.equalsIgnoreCase("fruit") ||
               item.equalsIgnoreCase("pasta") ||
               item.equalsIgnoreCase("marshmallows") ||
               item.equalsIgnoreCase("spam"); 
    }
    public boolean exploreDay5(User user) {
        System.out.println("You are inside the kitchen. You notice a roll of tinfoil on the counter.");
        System.out.println("Would you like to take it? (yes/no)");
        String choice = scanner.next();

        // Handle user's choice
        if (choice.equalsIgnoreCase("yes")) {
            user.useraddInventory("Tinfoil");
            System.out.println("Tinfoil has been added to your inventory.");
            return true; // Tinfoil collected
        } else {
            System.out.println("You decided not to take the tinfoil...");
            return false; // Tinfoil not collected
        }
    }
}
 