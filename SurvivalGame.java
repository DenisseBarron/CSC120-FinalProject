import java.util.Scanner;

public class SurvivalGame {
    private static Scanner scanner = new Scanner(System.in);
    private static int itemsCollected = 0;
    private static int health = 10;
    private static String userName;


    public static void main(String[] args){
         //Introduction to the game
         System.out.println("Day 1");
         System.out.println("You are left behind by your hinking group in a hunted campsite");
         System.out.println("You need to collect resources to survuve, but you can only choose three.");

         //Ask User for name
         System.out.println("What's your name?");
         userName = scanner.nextLine();
         System.out.println("Hello " + userName + "! Let's start your survival journey!");

         //Main loop to choose locations until all items are collected
         while (itemsCollected < 3 && health > 0) {
            //Display user's status
            displayUserDetails();

            //User choose a location
            System.out.println("Choose a place: (1) Kitchen, (2) Woods, (3) Backstage, (4) Lake, (5) Firepit, (6) Tent, (7) Showers, (8) Lockers");
            int choice = scanner.nextInt();

            //Handle user's choice based on location
            switch (choice) {
                case 1:
                    Kitchen.explore(); //Call explore method in Kitchen class
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
         //Display message when all items are collected
         if (itemsCollected >= 3) {
            System.out.println("Congradulations! You have collected all necessary items to survive.");
         } 
     }
     private static void displayUserDetails(){
        System.out.println("---------------------");
        System.out.println(userName + "'s Status:");
        System.out.println("Health: " + health);
        System.out.println("itemsCollected: " + itemsCollected);
        System.out.println("---------------------");
     }
}