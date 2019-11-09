package VendingMachine.Storage;

import VendingMachine.Coin.Coin;
import VendingMachine.Item.Item;

import java.util.*;

import static VendingMachine.Coin.Coin.*;

public class Storage {

    ArrayList<Queue<Item>> items = new ArrayList<>();

    Map<Double, Queue<Coin>> coins = new HashMap<>();

    double userMoney;

    private Queue<Coin> oneCoins = new LinkedList<>();
    private Queue<Coin> fiveCoins = new LinkedList<>();
    private Queue<Coin> tenCoins = new LinkedList<>();
    private Queue<Coin> fiftyCoins = new LinkedList<>();

    public Storage() {

        coinsBuild();
    }


    public void newItem(String name, double price, int amount) {

        Queue<Item> item = new LinkedList<>();

        for (int i = 0; i < amount; i++) {

            item.add(new Item(name, price));

        }
        items.add(item);

    }

    private void coinsBuild() {

        for (int i = 0; i < 20; i++){
            oneCoins.add(ONE);
        }
        coins.put(ONE.getValue(), oneCoins);

        for (int i = 0; i < 20; i++){
            fiveCoins.add(FIVE);
        }
        coins.put(FIVE.getValue(), fiveCoins);

        for (int i = 0; i<20; i++){
            tenCoins.add(TEN);
        }
        coins.put(TEN.getValue(), tenCoins);

        for (int i = 0; i < 20; i++){
            fiftyCoins.add(FIFTY);
        }
        coins.put(FIFTY.getValue(), fiftyCoins);

    }

    public void removeCoins(Coin coinToRemove){

        coins.get(coinToRemove.getValue()).remove();

    }

    public Map<Double, Queue<Coin>> getCoins() {
        return coins;
    }

    public ArrayList<Queue<Item>> getItems() {
        return items;
    }
}
