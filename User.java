//import java.util.Scanner;
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
}


 