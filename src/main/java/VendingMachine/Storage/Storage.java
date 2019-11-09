package VendingMachine.Storage;

import VendingMachine.Coin.Coin;
import VendingMachine.Item.Item;

import java.util.*;

import static VendingMachine.Coin.Coin.*;

public class Storage {

    private ArrayList<Queue<Item>> items = new ArrayList<>();


    double userMoney;


    public void newItem(String name, double price, int amount) {

        Queue<Item> item = new LinkedList<>();

        for (int i = 0; i < amount; i++) {

            item.add(new Item(name, price));

        }
        items.add(item);

    }


    public ArrayList<Queue<Item>> getItems() {
        return items;
    }
}
