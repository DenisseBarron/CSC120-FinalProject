import java.util.Scanner;

public class Backstage {
    private static final Scanner scanner = new Scanner(System.in);

    public boolean explore(User user, boolean allowWeaponCollection) {
        System.out.println("You are at the stage of the campsite.");
        System.out.println("The floors are creaking and there is a strange feeling to it.");
        System.out.println("Would you like to go backstage? (yes/no)");

        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("You are in the backstage and notice a large old trunk that is closed.");
            System.out.println("As you are about to get close to the trunk, something catches your eye... a snippet of an old newspaper.");
            System.out.println("The headline reads '19-year-old man disappears at Campers Hollow Camp'");
            System.out.println("Would you like to continue reading? (yes/no)");

            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("You continue reading...");
                System.out.println("He was left behind by a group of campers...");
                System.out.println("A week went by without anyone noticing he had been left behind...");
                System.out.println("When they came back for him...");
                System.out.println("He was gone and he was never found...");
            }

            if (allowWeaponCollection) {
                System.out.println("You spot some weapons behind the trunk!");
                System.out.println("Would you like to pick up a weapon? (yes/no)");

                choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("yes")) {
                    // Give the player a weapon (e.g., add "Weapon" to user's inventory)
                    user.useraddInventory("Weapon");
                    System.out.println("You picked up a weapon!");
                }
            }

            return true; // User explored backstage
        } else {
            System.out.println("You decided not to go backstage.");
            return false; // User did not explore backstage
        }
    }
}

