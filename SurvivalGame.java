import java.util.Scanner;
// import java.util.Hashtable;

public class SurvivalGame {
    /**
     * main method that runs the game
     */
    private static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_ITEMS = 3;

    public static void main(String[] args){
         //Introduction to the game
         System.out.println("**");
         System.out.println("SURVIVAL");
         System.out.println("**");

         Scanner userInput = new Scanner(System.in);

         // Instructions are sometimes helpful
         System.out.println("You wake up to the smell of rain.");
         System.out.println("There is a chill in the air unlike no other.");
         System.out.println("There's something else too... it's quiet... too quiet.");
         System.out.println("Where is everyone?");
         System.out.println("Type 'yes' to continue...");
         String userResponse = userInput.nextLine().toUpperCase();

         if (userResponse.equals("YES")) {
             System.out.println("DAY 1");
             System.out.println("Hello brave user. What's your name?");
             String userName = userInput.nextLine();
             User user = new User(userName);
             user.userDetails();

             System.out.println("Your hiking group left you behind in this cold, haunted, and lifeless campsite. \n"+
             "The choices you make, or the choices you don’t make, will decide whether or not you make it out alive. \n"+
             "Choose wisely and stay alert. We suggest you begin by collecting resources to survive. \n" + 
             "However, you’re only allowed to store three. Again, choose wisely. Good luck. ");

             int itemsCollected = 0;

             //Main loop to choose locations until all items are collected
             while (itemsCollected < MAX_ITEMS) {
                //User choose a location
                System.out.println("Choose a place: (1) Kitchen, (2) Woods, (3) Backstage, (4) Lake, (5) Firepit, (6) Tent, (7) Showers, (8) Lockers");
                int choice = scanner.nextInt();
    
                //Handle user's choice based on location
                switch (choice) {
                    case 1:
                        Kitchen kitchen = new Kitchen();
                        if (kitchen.explore(user)){ //Call explore method in Kitchen class
                        itemsCollected++;
                        }
                        break;
                    case 2:
                        Woods woods = new Woods();
                        if (woods.explore(user)){
                        itemsCollected++;
                        }
                        break;
                    case 3:
                        Backstage backstage = new Backstage();
                        if (backstage.explore(user)){
                        itemsCollected++;
                        }
                        break;
                    case 4:
                        Lake lake = new Lake();
                        if (lake.explore(user)){
                        itemsCollected++;
                        }
                        break;
                    case 5:
                        Firepit firepit = new Firepit();
                        if (firepit.explore(user)){
                        itemsCollected++;
                        }
                        break;
                    case 6:
                        Tent tent = new Tent();
                        if (tent.explore(user)){
                        itemsCollected++;
                        }
                        break;
                    case 7:
                        Showers showers = new Showers();
                        showers.explore(user);
                        break;
                    case 8:
                        Lockers lockers = new Lockers();
                        if (lockers.explore(user)){
                        itemsCollected++;
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                        break;
                }
             }
             //Display message when all items are collected
             System.out.println("These are the items you collected:");
             user.printInventory();

             //Narrative for day two
             System.out.println("Time to sleep. We will see you in day two...");
         } else {
             System.out.println("OK then...");
         }
         userInput.close();
     }
}