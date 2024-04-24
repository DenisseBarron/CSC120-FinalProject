import java.util.Scanner;
import java.util.ArrayList;

public class User {
    String name;
    ArrayList<String> backpack;
    int health;

    public User(String name){
        this.name = name;
        this.backpack = new ArrayList <>();
        this.health = 10;
    }

    public void userDetails (){
        System.out.println(name + ", you current health level is of: " + health + " hearts");
    }

    public static void main(String[] args) {
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

        if (userResponse.equals("YES")) {
            System.out.println("Hello brave user. What's your name?");
            userResponse = userInput.nextLine();
            User you = new User(userResponse);
            you.userDetails();
        }
        else {
            System.out.println("Try again...");
        }
        userInput.close();
    }

}


 