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

    public void userDetails (){
        System.out.println(name + ", you current health level is of: " + health + " hearts");
    }
    public void useraddInventory (String item){
        backpack.add(item);
    }
    public void printInventory(){
        System.out.println("Inventory:");
        for (String item : backpack){
            System.out.println("- " + item);
        }
    }
}


 