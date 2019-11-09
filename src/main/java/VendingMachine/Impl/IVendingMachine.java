package VendingMachine.Impl;

import VendingMachine.Coin.Coin;
import VendingMachine.Item.Item;
import VendingMachine.Storage.Storage;

public interface IVendingMachine {



//    double userMoney = 0;
    Storage storage = null;

    void selectItem(int itemIndex);
    void insertMoney(Coin coinGiven);
    Item getItem();

    void getChange();




}
