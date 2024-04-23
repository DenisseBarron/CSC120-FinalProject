import java.util.Scanner;

public class SurvivalGame {
    private static Scanner scanner = new Scanner(System.in);
    public static int itemsCollected = 0;

    public static void main(String[] args){
         //Introduction to the game
         System.out.println("Day...");
         System.out.println("You are left behind by your hinking group in a hunted campsite");
         System.out.println("You have to decide what to do next in order to survive");
         System.out.println("You need to collect resources to survuve, but you can only choose three.");

         //Main loop to choose locations until all items are collected
         while (itemsCollected < 3) {
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
         System.out.println("Congradulations! You have collected all necessary items to survive.");
     }
}