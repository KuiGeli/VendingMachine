package VendingMachine.Impl;

import VendingMachine.Coin.Coin;
import VendingMachine.Exceptions.SoldOutException;
import VendingMachine.Item.Item;
import VendingMachine.Storage.CoinStorage;
import VendingMachine.Storage.Storage;

import java.text.DecimalFormat;
import java.util.Queue;

import static VendingMachine.Coin.Coin.*;

public class VendingMachineImpl implements IVendingMachine {


    private String pattern = ".##";


    DecimalFormat decimalFormat = new DecimalFormat(pattern);

    CoinStorage coinStorage = new CoinStorage();
    Storage storage = new Storage();
    double userMoney = 0;


    public VendingMachineImpl() {


        storage.newItem("Coca-cola", 2.5, 10);
        storage.newItem("Pepsi", 3.0, 10);
        storage.newItem("Fanta", 2.5, 10);
    }

    @Override
    public Queue<Item> selectItem(int itemIndex) {


        Item item = storage.getItems().get(itemIndex).peek();

        if(item != null && !storage.getItems().get(itemIndex).isEmpty()) {
            System.out.println(String.format("The item you have selected is %s ", item.getName()));
        }else {
           throw new SoldOutException();
        }
        return storage.getItems().get(itemIndex);
    }

    @Override
    public void insertMoney(Coin coinGiven) {
        this.userMoney += coinGiven.getValue();
        coinStorage.addCoins(coinGiven);


    }

    @Override
    public Item returnItem(Queue<Item> items) {

        System.out.println("You received a " + items.peek().getName());
        System.out.println(items.peek().getPrice() + "Ron has been removed from you balance.");

        this.userMoney = items.peek().getPrice();
        return items.remove();
    }


    @Override
    public boolean isMoneyEnough(Item item) {
        if(item.getPrice() < userMoney){
            return true;
        }else {
            return false;
        }
    }


    @Override
    public void getChange() {

        decimalFormat.format(userMoney);

        System.out.println("Your change is:");
        int i = 0;
        while (userMoney >= FIFTY.getValue()){
            userMoney -= FIFTY.getValue();
            coinStorage.removeCoins(FIFTY);
            i++;

        }
        if(i > 0){
            System.out.println(i + "x: 0.50 RON");
            i = 0;
            userMoney = Math.round(userMoney * 100)/100.00;
        }
        while (userMoney >= TEN.getValue()){
            userMoney -= TEN.getValue();
            coinStorage.removeCoins(TEN);
            i++;
        }

        if(i > 0){
           System.out.println(i + "x: 0.10 RON");
           i = 0;
       }
        while (userMoney >= FIVE.getValue()){
            userMoney -= FIVE.getValue();
            coinStorage.removeCoins(FIVE);
            i++;
        }

        if(i > 0){
            System.out.println(i + "x: 0.05 RON");
            i = 0;
        }
        while (userMoney >= ONE.getValue()){
            userMoney -= ONE.getValue();
            coinStorage.removeCoins(ONE);
            i++;
        }

        if(i > 0){
            System.out.println(i + "x: 0.01 RON");
            i = 0;
        }

    }



    public CoinStorage getCoinStorage() {
        return coinStorage;
    }

    public Storage getStorage() {
        return storage;
    }

    public double getUserMoney() {
        return userMoney;
    }
}
