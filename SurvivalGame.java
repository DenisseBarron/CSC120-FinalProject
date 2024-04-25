import java.util.Scanner;
// import java.util.Hashtable;

public class SurvivalGame {
    /**
     * main method that runs the game
     */
    private static final Scanner scanner = new Scanner(System.in);
    public static int itemsCollected = 0;

    public static void main(String[] args){
         //Introduction to the game
         Scanner userInput = new Scanner(System.in);

         // Storage for user's responses
         String userResponse = "";

         System.out.println("**");
         System.out.println("SURVIVAL");
         System.out.println("**");

         // Instructions are sometimes helpful
         System.out.println("You wake up to the smell of rain.");
         System.out.println("There is a chill in the air unlike no other.");
         System.out.println("There's something else too... it's quiet... too quiet.");
         System.out.println("Where is everyone?");

         System.out.println("Type 'yes' to continue...");
         userResponse = userInput.nextLine().toUpperCase();

         Kitchen userKitchen = new Kitchen();

         if (userResponse.equals("YES")) {
             System.out.println("DAY 1");
             System.out.println("Hello brave user. What's your name?");
             userResponse = userInput.nextLine();
             User user = new User(userResponse);
             //Kitchen userKitchen = new Kitchen(user);
             user.userDetails();
             System.out.println("Your hiking group left you behind in this cold, haunted, and lifeless campsite. \n"+
             "The choices you make, or the choices you don’t make, will decide whether or not you make it out alive. \n"+
             "Choose wisely and stay alert. We suggest you begin by collecting resources to survive. \n" + 
             "However, you’re only allowed to store three. Again, choose wisely. Good luck. ");
             while (itemsCollected < 3) {
                //User choose a location
                System.out.println("Choose a place: (1) Kitchen, (2) Woods, (3) Backstage, (4) Lake, (5) Firepit, (6) Tent, (7) Showers, (8) Lockers");
                int choice = scanner.nextInt();
    
                //Handle user's choice based on location
                switch (choice) {
                    case 1:
                        userKitchen.explore(); //Call explore method in Kitchen class
                        break;
                    case 2:
                        Woods.explore();
                        break;
                    case 3:
                        Backstage.explore();
                        break;
                    case 4:
                        Lake.explore();
                        break;
                    case 5:
                        Firepit.explore();
                        break;
                    case 6:
                        Tent.explore();
                        break;
                    case 7:
                        Showers.explore();
                        break;
                    case 8:
                        Lockers.explore();
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                        break;
                }
             }
             //Main loop to choose locations until all items are collected
             //Display message when all items are collected
             System.out.println("Congradulations! You have collected all necessary items to survive.");
             //
         } else {
             System.out.println("OK then...");
             userInput.close();
         }
     }
}