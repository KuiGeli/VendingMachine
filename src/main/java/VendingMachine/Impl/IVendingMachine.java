package VendingMachine.Impl;

import VendingMachine.Coin.Coin;
import VendingMachine.Item.Item;
import VendingMachine.Storage.Storage;

import java.util.Queue;

public interface IVendingMachine {



//    double userMoney = 0;
    Storage storage = null;

    Queue<Item> selectItem(int itemIndex);
    void insertMoney(Coin coinGiven);
    Item returnItem(Queue<Item> items);
    void getChange();
    boolean isMoneyEnough(Item item);




}
