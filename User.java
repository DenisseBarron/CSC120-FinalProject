import java.util.ArrayList;

public class User {
    String name;
    ArrayList<String> backpack;
    int health;
    String location;

    public User(String name){
        this.name = name;
        this.backpack = new ArrayList <>();
        this.health = 10;
        this.location = "location";
    }

    public int getHealth() {
        return health;
    }
    
    public void userDetails (){
        System.out.println(name + ", you current health level is of: " + health + " hearts");
    }
    public void useraddInventory (String item){
        backpack.add(item);
    }

    public void removeItem(String item){
        if (backpack.contains(item)){
            backpack.remove(item);
            System.out.println(item + " has been removed from your inventory.");
        } else {
            System.out.println("You do not have " + item + " in your inventory.");
        }
    }

    public boolean hasItem(String item) {
        return backpack.contains(item);
    }

    public void decreaseHealth(int amount){
        if (health > 0) {
            health -= amount;
            if (health <= 0){
                System.out.println("Your health has reached zerio. Game over!");
                //Implement game over here, idk how yet
            } else {
                System.out.println("You lost " + amount + " hearts. Your current health is " + health + " hearts.");
            }
        }
    }

    public void increaseHealth(int amount){
        if (health < 10) {
            health += amount;
            if (health > 10){
                health = 10; //Cap health at max (10 hearts)
            }
            System.out.println("Your health has increased by " + amount + " hearts. Your current health is " + health + " hearts.");
        } else {
            System.out.println("Your health is already at maximum (10 hearts.)");
        }
    }

    public void printInventory(){
        System.out.println("Inventory:");
        for (String item : backpack){
            System.out.println("- " + item);
        }
    }

    public boolean hasFood(){
        for (String item : backpack) {
            if (isFood(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean isFood(String item) {
        return item.equalsIgnoreCase("corn") ||
               item.equalsIgnoreCase("pasta") ||
               item.equalsIgnoreCase("marshmallows") ||
               item.equalsIgnoreCase("fruit") ||
               item.equalsIgnoreCase("spam");
    }


    public int calculateHealthGain(String foodType){
        switch (foodType.toLowerCase()) {
            case "corn":
            case "pasta":
                return 2; // +2 hearts for corn or pasta
            case "marshmallows":
            case "fruit":
                return 1; // +1 heart for marshmallows or fruit
            case "spam":
                return 3; // +3 hearts for spam
            default:
                return 0; // No health gain for invalid food types
        }
    }
}


 