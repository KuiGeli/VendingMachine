package VendingMachine.Impl;

import VendingMachine.Coin.Coin;
import VendingMachine.Item.Item;
import VendingMachine.Storage.Storage;

public class VendingMachineImpl implements IVendingMachine {


    Storage storage = new Storage();
    double userMoney = 0;

    public VendingMachineImpl() {
        storage.newItem("Coca-cola", 2.5, 10);
        storage.newItem("Pepsi", 3.0, 10);
        storage.newItem("Fanta", 2.5, 10);
    }

    @Override
    public void selectItem(int itemIndex) {

        Item item = storage.getItems().get(itemIndex).remove();

        System.out.println(String.format("The item you have selected is %s ", item.getName()));

    }

    @Override
    public void insertMoney(Coin coinGiven) {
        this.userMoney =+ coinGiven.getValue();
        storage.removeCoins(coinGiven);
    }

    @Override
    public Item getItem() {
        return null;
    }



    @Override
    public void getChange() {

    }
}
