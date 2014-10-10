import com.thoughtworks.iamcoach.pos.Cart;
import com.thoughtworks.iamcoach.pos.Item;

import java.io.*;
import java.util.ArrayList;

public class App {

    public static ArrayList<Item> items = new ArrayList<Item>();
    public static ArrayList<String> inputs = new ArrayList<String>();

    public static void main(String[] args) {

        initItems();
        getInputs();
        Cart cart = new Cart(items, inputs);
    }

    private static void initItems(){
        Item item1 = new Item("ITEM000001", "橙汁", "瓶", 5.00);
        Item item2 = new Item("ITEM000002", "可乐", "瓶", 3.00);
        Item item3 = new Item("ITEM000003", "苹果", "斤", 4.50);
        Item item4 = new Item("ITEM000004", "雪碧", "瓶", 5.00);
        Item item5 = new Item("ITEM000005", "方便面", "袋", 2.50);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
//        for(Item item: items){
//            System.out.println(item.name);
//        }
    }

    private static void getInputs(){
        try {
            File cartLocation = new File("src/main/resources/cart.txt");
            FileReader cartReader = new FileReader(cartLocation);
            BufferedReader reader = new BufferedReader(cartReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                inputs.add(line);
            }
//            System.out.println(inputs);
            reader.close();
        } catch (IOException ex) {
            System.out.println("fail read file!");
        }
    }


}