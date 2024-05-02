import java.util.Scanner;

public class SurvivalGame {
    private static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_ITEMS = 3;
    public static final int MAX2_ITEMS = 2;

    public static void main(String[] args) {
        // Introduction to the game
        System.out.println("**");
        System.out.println("SURVIVAL");
        System.out.println("**");

        // Scanner userInput = new Scanner(System.in);

        // Game initialization
        System.out.println("You wake up to the smell of rain.");
        System.out.println("There is a chill in the air unlike no other.");
        System.out.println("There's something else too... it's quiet... too quiet.");
        System.out.println("Where is everyone?");
        System.out.println("Type 'yes' to continue...");
        String userResponse = scanner.nextLine().toUpperCase(); //userInput.

        if (userResponse.equals("YES")) {
            User user = initializeUser(); //userInput
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

            // Day 5
            System.out.println("DAY 5");
            executeDayFive(user, scanner);

            // Day 6
            System.out.println("DAY 6");
            executeDaySix(user);

        } else {
            System.out.println("OK then...");
        }

        // userInput.close();
        scanner.close();
    }

    private static User initializeUser() { //Scanner userInput
        System.out.println("Hello brave user. What's your name?");
        String userName = scanner.nextLine(); //userInput
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
                    if (backstag.explore(user, false));
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
                    user.removeItem("Matches");
                    user.removeItem("Wood");
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
        "NOTE: New items have been added to some locations. These may help you in future situations.");

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
        System.out.println("During the day, it's difficult to accept the cruel hand the universe has dealt you,\n" +
        "but when the sun goes down, it becomes almost unbearable. Not only that, it's cold!");
    
        if (user.hasItem("Warm clothes")) {
            System.out.println("You have some warm clothes in your inventory.");
            System.out.println("Would you like to put them on?");
    
            String response = scanner.nextLine();

            // Validate user input
            while (!response.equals("yes") && !response.equals("no")) {
                System.out.println("(yes/no)");
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

        System.out.println("It's chilly and nightfall is nearing.");
        System.out.println("Would you like to get a fire going? (yes/no)"); // NOT TAKING IN USER RESPONSE FIX

        String response = scanner.nextLine().toLowerCase();

        if (response.equals("yes")){
            if (!user.hasItem("Matches") || !user.hasItem("Wood")) {
                user.printInventory();
                System.out.println("You seem to be missing either matches or wood to start the fire. Go find some.");
                exploreLocationsForDayFour(user, scanner);
                user.removeItem("Matches");
                user.removeItem("Wood");
    
            } else {
                user.removeItem("Matches");
                user.removeItem("Wood");
                System.out.println("Nice! You have the necessary items to get a fire going! And just in time too. It's dark out.");
                user.increaseHealth(1);
                System.out.println("Feeling the warmth of the fire, you start to get drowsy. However, before you can let yourself go, you begin to register \n" +
                "the severity of your situation and a pang of anxiety soars throughout your entire body.");
            }
        } else {
            user.decreaseHealth(1);
            System.out.println("It's dark out. Now you're really cold and begin to shiver, rocking back and forth when out of nowhere-");
        }

        System.out.println("*SNAP*");
        System.out.println("*"+ "\033[3mwhispers\033[0m"+"*");
        System.out.println("*"+ "\033[3mwhispers\033[0m"+"*");
        System.out.println("*"+ "\033[3mwhispers\033[0m"+"*");
        System.out.println("Slowly, you slip out of your trance and turn in the direction of the sudden sounds. It's near the woods. \n" +
        "In the four days and nights you've been at the camp, you have encountered a number of unsettling sounds. But this one is different...");
        System.out.println("That sound isn't just a sound...");
        System.out.println("'"+ user.name + "'" + "");
        System.out.println("It's a voice... A voice you know.");
        System.out.println("'"+ user.name + "'" + "");
        System.out.println("\033[3mA friend!\033[0m");
        System.out.println("Before you can think any further, you dash into the woods frantically looking for your 'friend'.");
        System.out.println("What you find instead is a dreadful sight: A young man holding a lantern is staring directly at you. His skin is pale and he's wearing a tattered red shirt with the words 'Campers Hallow' on it. 'Help,' he croaks before taking a step towards you and aggressively reaches to touch your arm.");  
        System.out.println("Do you help or fight him off?");

        boolean validChoice = false;
        while (!validChoice) {
            String choice = scanner.nextLine().toLowerCase();
            
            if (choice.equals("help")){
                ghostHelp(user, scanner);
                validChoice = true; // Exit lopp of choice is valid
            } else if (choice.equals("fight")){
                ghostFight(user, scanner); 
                validChoice = true; // Exit loop if choice is valid
            } else {
                System.out.println("Please type 'help' or 'fight'.");
            }
        }
        System.out.println("Here is your status after Day 4:");
        user.userDetails();
        user.printInventory();
    }

    private static void exploreLocationsForDayFour (User user, Scanner scanner) {
        int itemsCollected = 0;

        // Main loop to choose locations until all items are collected
        while (itemsCollected < MAX2_ITEMS) {
            // User chooses a location
            System.out.println("Choose a place to explore: (1) Woods, (2) Firepit");
            int choice = scanner.nextInt();

            // Handle user's choice based on location
            switch (choice) {
                case 1:
                    Woods woods = new Woods();
                    if (woods.explore(user)) {
                        itemsCollected++;
                    }
                    break;
                case 2:
                    Firepit firepit = new Firepit();
                    if (firepit.explore(user)){
                    itemsCollected++;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }

    private static void ghostHelp (User user, Scanner scanner) {
        // help ghost -- ask him what went wrong -- storytime -- recover idk 
        System.out.println("You let yourself relax when you realize the ghost is crying. His hand barely grazes your arm, but you can feel how clammy and cold his skin is. 'What's wrong?' you ask.");
        System.out.println("'I don't know what to do! My group left me and it feels like I've been looking for them forever. No one has ever come back for me,' he manages to say in between sobs.");
        System.out.println("It dawns on you that this man is in the exact position as you, or was. 'What's your name?' you ask again.");
        System.out.println("'George,' he responds. 'But my friends call me Georgie,' he adds. Then, sniffiling, he asks, 'Why are you here?'");
        System.out.println("After the two of you get acquanited and realize you're experiencing the same situation years apart George says,'" + user.name+ ", I know this is a lot to ask from you, but will you please bury my body?'");
        System.out.println("Will you bury George's body?");
        String choice = scanner.nextLine().toLowerCase(); 
        System.out.println(choice);
        if (choice.equals("yes")){
            System.out.println("You bury George's body. Before his ghost gets into the ground, he tells you something.");
            System.out.println("'You will find what you're in need of most in the kitchen or in the tent or in the lockers. Thank you for helping me.'");
            System.out.println("Confused you ask a small, 'What?' He gives you a smile before getting into the ground. He begins to glow and slowly disappears.");
        } else {
            System.out.println("'I understand. It's a lot to ask from someone you've only just met,' he says sadly. 'Thank you for talking to me. You will find what you're in need of most in the kitchen or in the tent or in the lockers.'");
            System.out.println("Confused you ask a small, 'What?' He says,'At least one of us deserves to make it out of this old place,' before disappearing back into the woods.");
        }
        System.out.println("In that moment you feel your eyelids grow very heavy and suddenly-");
        System.out.println("*THUD*");
    }

    private static void ghostFight (User user, Scanner scanner) {
        if (user.hasItem("Weapon")) {
            System.out.println("You have a weapon! Do you want to attack?"); 
            String choice = scanner.nextLine().toLowerCase();        
            if(choice.equals("yes")){
                System.out.println("You attack the ghost and hit him on the head. However, he lifts his lantern and fights back, hitting you right on the head.");
                user.decreaseHealth(5);
                System.out.println("Do you want to keep attacking? Warning: This may be fatal.");
                String choice2 = scanner.nextLine().toLowerCase();
                if (choice2.equals("yes")){
                    user.decreaseHealth(5);
                    System.out.println("You're dead! And now you haunt Campers Hallow too.");
                } else {
                    System.out.println("Good choice! You throw your weapon down.");
                    user.removeItem("Weapon");
                    System.out.println("The ghost backs down too.");
                    ghostHelp(user, scanner);
                }
            } else {
                System.out.println("Nice choice! Fighting a ghost can kill you.");
            }
        } else {
            System.out.println("You lift your arm ready to punch the ghost, but he knocks you out before you can hit.");
            System.out.println("*BAM*");
            user.decreaseHealth(10);
            System.out.println("Who fights a ghost without a weapon?! You're dead! And now you haunt Campers Hallow too.");
        }
    }

    private static void executeDayFive(User user, Scanner scanner) {
        System.out.println("After the helping the gohst, you are tired and dehydrated.\n" +
        "Go to the lake to get water...");
        
        // Explore the lake to find water
        Lake lake = new Lake();
        boolean foundWater = lake.explore(user);
        
        // If water is found, prompt the user to drink it for health gain
        if (foundWater) {
            System.out.println("You collected water at the lake. Would you like to drink it to regain health? (yes/no)");
            String drinkChoice = scanner.nextLine().toLowerCase();
        
            if (drinkChoice.equals("yes")) {
                user.increaseHealth(3); // Gain 3 hearts of health by drinking water
                System.out.println("You drank water and regained 3 hearts of health.");
            } else {
                System.out.println("You decided not to drink the water.");
                user.decreaseHealth(1); // Lose 1 heart due to not drinking water
            }
        } else {
            System.out.println("You didn't collect any water at the lake.");
            System.out.println("Your health decreases by 1 heart due to thirst.");
            user.decreaseHealth(1); // Lose 1 heart due to not collecting water
        }

        System.out.println("You remember what George said about the things you might need...");
        System.out.println("He mentioned you would find them in the kitchen, tent, or lockers...");

        // Explore the tent, kitchen, and lockers for specific items
        Tent tent = new Tent();
        Kitchen kitchen = new Kitchen();
        Lockers lockers = new Lockers();

        boolean visitedTent = false;
        boolean visitedKitchen = false;
        boolean visitedLockers = false;

        // Explore all three locations at least once
        while (!(visitedTent && visitedKitchen && visitedLockers)) {
            System.out.println("Choose a place to explore: (1) Tent, (2) Kitchen, (3) Lockers");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after nextInt()

            switch (choice) {
                case 1:
                    if (!visitedTent) {
                        visitedTent = true;
                        tent.exploreDay5(user); // Explore the tent
                    } else {
                        System.out.println("You've already explored the Tent.");
                    }
                    break;
                case 2:
                    if (!visitedKitchen) {
                        visitedKitchen = true;
                        kitchen.exploreDay5(user); // Explore the kitchen
                    } else {
                        System.out.println("You've already explored the Kitchen.");
                    }
                    break;
                case 3:
                    if (!visitedLockers) {
                        visitedLockers = true;
                        lockers.exploreDay5(user); // Explore the lockers
                    } else {
                        System.out.println("You've already explored the Lockers.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        
        // Check if all required items are collected
        if (tent.hasBatteries() && kitchen.hasTinfoil() && lockers.hasRadio()) {
            System.out.println("Congratulations! You've collected all essential items.");
        } else {
            System.out.println("You failed to collect all the items needed.");
            // Handle game over or other consequences here...
        }
    }

    private static void executeDaySix(User user){



    }


        
    
    
        // day 6 - trying to set up new items, but massive storm makes you seek shelter (in lockers, showers, ot backstage)
        // no seek shelter --> struck by lightening!
        // day 7 - calm after the storm, beautiful day, and able to contact help!

}

