import java.util.Scanner;

public class SurvivalGame {
    private static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_ITEMS = 3;

    public static void main(String[] args) {
        // Introduction to the game
        System.out.println("**");
        System.out.println("SURVIVAL");
        System.out.println("**");

        Scanner userInput = new Scanner(System.in);

        // Game initialization
        System.out.println("You wake up to the smell of rain.");
        System.out.println("There is a chill in the air unlike no other.");
        System.out.println("There's something else too... it's quiet... too quiet.");
        System.out.println("Where is everyone?");
        System.out.println("Type 'yes' to continue...");
        String userResponse = userInput.nextLine().toUpperCase();

        if (userResponse.equals("YES")) {
            User user = initializeUser(userInput);
            Backstage backstage = new Backstage();



            // Day 1
            System.out.println("DAY 1");
            executeDayOne(user, backstage);

            // Day 2
            System.out.println("DAY 2");
            executeDayTwo(user);

            // Day 3
            System.out.println("DAY 3");
            executeDayThree(user, backstage);
            System.out.println("Day 4 is waiting...");

            // Day 4
            System.out.println("DAY 4");
            executeDayFour(user);

        } else {
            System.out.println("OK then...");
        }

        userInput.close();
        scanner.close();
    }

    private static User initializeUser(Scanner userInput) {
        System.out.println("Hello brave user. What's your name?");
        String userName = userInput.nextLine();
        User user = new User(userName);
        user.userDetails();

        System.out.println("Your hiking group left you behind in this cold, haunted, and lifeless campsite.\n" +
                "The choices you make, or the choices you don’t make, will decide whether or not you make it out alive.\n" +
                "Choose wisely and stay alert. We suggest you begin by collecting resources to survive.\n" +
                "However, you’re only allowed to store three. Again, choose wisely. Good luck.");

        return user;
    }

    private static void executeDayOne(User user, Backstage backstage) {
        int itemsCollected = 0;
        Backstage backstag = new Backstage();


        // Day 1 loop to choose locations until all items are collected
        while (itemsCollected < MAX_ITEMS) {
            System.out.println("Choose a place: (1) Kitchen, (2) Woods, (3) Backstage, (4) Lake, (5) Firepit, (6) Tent, (7) Showers, (8) Lockers");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after nextInt()

            // Handle user's choice based on location
            switch (choice) {
                case 1:
                    Kitchen kitchen = new Kitchen();
                    if (kitchen.explore(user)) {
                        itemsCollected++;
                    }
                    break;
                case 2:
                    Woods woods = new Woods();
                    if (woods.explore(user)) {
                        itemsCollected++;
                    }
                    break;
                case 3:
                    // Explore Backstage on Day 1 (no weapon collection)
                if (itemsCollected < MAX_ITEMS) {
                    if (backstag.explore(user, false)) {
                        itemsCollected++;
                    }
                } else {
                    System.out.println("You've collected the maximum number of items for today.");
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

        // Display message when all items are collected
        System.out.println("These are the items you collected on Day 1:");
        user.printInventory();
    }

    private static void executeDayTwo(User user) {
        System.out.println("You start to feel hungry...");

        // Check if user needs wood
        if (!user.hasItem("Wood")){
            System.out.println("Since you did not collect wood on Day 1. \n" +
            "You decide to explore the woods to collect wood for fire");
            user.useraddInventory("Wood");

            //Encounter wild animal
            System.out.println("While collecting wood, you encounter a wild animal! \n"+
            "It attacks you but you eventually fight it off");
            user.decreaseHealth(2); //Lose 2 hearts due to animal attack
        }

        // Check if user needs matches
        if (!user.hasItem("Matches")){
            System.out.println("You did not collect any matches on Day 1 \n" +
            "You now need to find some to start a fire for cooking. \n" +
            "You decide to explore the firepit to find left over macthes.");
            user.useraddInventory("Matches");

            // Stepping on a sharp piece of wood
            System.out.println("While searching for matches, you accidentally step in a sharp piece of wood.");
            user.decreaseHealth(1); // Lose 1 heart due to injury
        }

        // Check if user needs food
        if (!user.hasFood()){
            System.out.println("Since you did not collect any food in Day 1... \n" +
            "Let's explore the kitchen.");
            exploreKitchen(user, scanner);
        }

        // Cook food if all necessary items are available
        if (user.hasItem("Wood") && user.hasItem("Matches") && user.hasFood()){
            String foodType = chooseFoodType(user, scanner);
            if (foodType != null){
                int healthGain = user.calculateHealthGain(foodType);
                user.increaseHealth(healthGain);
                System.out.println("You cooked " + foodType + " . Health increased by " + healthGain + " hearts.");
            }
        }

        // Start fire event
        if (user.hasItem("Wood") && user.hasItem ("Matches")){
            boolean hasWater = user.hasItem("Water");
            System.out.println("A fire has started!");
            handleFireEvent(user, hasWater);
        }
     }

     //Method to explore the kitchen and collect food
     public static void exploreKitchen(User user, Scanner scanner){
        boolean validChoice = false;
        
        while(!validChoice){
            System.out.println("You are in the kitchen... \n" +
            "You find a couple cans of food in the pantry. \n" +
            "Which one would you like to take? (corn/fruit/pasta/marshmallows/spam)");

            String choice = scanner.next().trim().toLowerCase();

            if (isValidItem(choice)){
                user.useraddInventory(choice);
                System.out.println(choice.toUpperCase() + " has been added to your inventory.");
                validChoice = true; // Set validChoice to true to exit loop
            } else {
                System.out.println("That is not a valid option. Try again");
            } 
        }
     }

        // private method to validate food item selection
        private static boolean isValidItem(String choice){
            return choice.equalsIgnoreCase("corn") ||
            choice.equalsIgnoreCase("fruit") ||
            choice.equalsIgnoreCase("pasta") ||
            choice.equalsIgnoreCase("marshmallows") ||
            choice.equalsIgnoreCase("spam");
        }

        // Method to choose a food item from inventory
        public static String chooseFoodType(User user, Scanner scanner) {
            System.out.println("Choose a food item from your inventory:");
            user.printInventory();
        
            String chosenFood = null;
            boolean isValidFood = false;
        
            while (!isValidFood) {
                String input = scanner.nextLine().trim().toLowerCase();
                    
                if (input.isEmpty()){
                    System.out.println("Enter the food item you want to cook: ");
                } else if (user.hasItem(input)) {
                    chosenFood = input;
                    user.removeItem(input); // Remove the chosen food item from inventory
                    isValidFood = true; // Set flag to exit loop
                } else {
                    System.out.println("You do not have " + input + " in your inventory.");
                    System.out.println("Please enter a food item from your inventory.");
                    System.out.println("Enter the food item you want to cook: ");
                }
            }
        
            return chosenFood;
        }

        //Method to handle fire event
        public static void handleFireEvent(User user, boolean hasWater){
            if (hasWater) {
                System.out.println("You have water in your inventory. Do you want to use it to extinguish the fire? (yes/no)");
                String choice = scanner.nextLine().trim().toLowerCase();

                if (choice.equals("yes")){
                    user.removeItem("Water");
                    System.out.println("You used water to extinguish the fire. It is no longer in your inventory.");
            } else {
                System.out.println("You chose not to use water. Instead, you have to fan the fire out, causing you to lose energy");
                user.decreaseHealth(1); // Lose 1 heart due to exhaustion from fanning
            }
        } else {
            System.out.println("You do not have water to extinguish the fire... \n" +
            "You now have to fan the fire out, causing you to lose energy");
            user.decreaseHealth(1); // Lose 1 heart due to exhaustion from faning
        }
        
        // Display updated status after Day 2
        System.out.println("Here is your status after Day 2:");
        user.userDetails();
        user.printInventory();
    }

    private static void executeDayThree(User user, Backstage backstage) {
        System.out.println("Use this day to gather resources since some of them were lost yesterday... \n" +
        "But your backpack can only hold three more items so choose wisely...\n" +
        "Note: New items have been added to some locations. These may help you in future situations.");

    // Explore different locations to gather resources for Day 3
    exploreLocationsForDayThree(user, scanner);

    // Display updated status after Day 3
    System.out.println("Here is your status after Day 3:");
    user.userDetails();
    user.printInventory();
}

    private static void exploreLocationsForDayThree(User user, Scanner scanner) {
        int itemsCollected = 0;
        Backstage backstage = new Backstage();


        // Main loop to choose locations until all items are collected
        while (itemsCollected < MAX_ITEMS) {
            // User chooses a location
            System.out.println("Choose a place to explore: (1) Kitchen, (2) Woods, (3) Backstage, (4) Lake, (5) Firepit, (6) Tent, (7) Showers, (8) Lockers");
            int choice = scanner.nextInt();

            // Handle user's choice based on location
            switch (choice) {
                case 1:
                    Kitchen kitchen = new Kitchen();
                    if (kitchen.explore(user)) {
                        itemsCollected++;
                    }
                    break;
                case 2:
                    Woods woods = new Woods();
                    if (woods.explore(user)) {
                        itemsCollected++;
                    }
                    break;
                case 3:
                    // Check if it's Day 3 to allow Backstage exploration with weapon collection
                    if (itemsCollected < MAX_ITEMS) {
                        if (backstage.explore(user, true)) 
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
    }

    private static void executeDayFour(User user) {
        System.out.println("It's been 4 days since you were left by your group.");
        System.out.println("During the day, it's difficult to accept the cruel hand the universe has dealt you,");
        System.out.println("but when the sun goes down, it becomes almost unbearable. Not only that, it's cold!");
    
        if (user.hasItem("Warm clothes")) {
            System.out.println("You have some warm clothes in your inventory.");
            System.out.println("Would you like to put them on? (yes/no)");
    
            String response = scanner.nextLine().trim().toLowerCase();
    
            // Validate user input
            while (!response.equals("yes") && !response.equals("no")) {
                System.out.println("Invalid response. Please enter 'yes' or 'no'.");
                response = scanner.nextLine().trim().toLowerCase();
            }
    
            if (response.equals("yes")) {
                user.removeItem("Warm clothes");
                System.out.println("That's an improvement!");
                user.increaseHealth(1);
            } else {
                System.out.println("You're going to catch a cold if you don't put something warm on soon...");
                user.decreaseHealth(1);
            }
        } else {
            System.out.println("It's too bad you don't have some warm clothes in your inventory...");
            user.decreaseHealth(1);
        }
    }
    
        // methods / storyline
        // it's cold, getting dark, and this camp is haunted.
        // warm clothes(), light a fire (need wood&lighter)
        // hear something in the woods. to explore in the dark - need lamp. give option to look for one. 
        // once lamp is acquired: 
        //  the wolves howl. you shudder. vaguely remembering (if they went into kitchen and read 
        // story == true) the missing man.. who was never found... 

}

