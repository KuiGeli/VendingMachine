package VendingMachine;

import VendingMachine.Coin.Coin;
import VendingMachine.Exceptions.NotValidCoinException;
import VendingMachine.Impl.VendingMachineImpl;
import VendingMachine.Item.Item;
import VendingMachine.Storage.CoinStorage;
import VendingMachine.Storage.Storage;

import java.util.InputMismatchException;
import java.util.Queue;

public class Utils {

    public static void options() {

        System.out.println("Input the character of the option you want to choose.");
        System.out.println("A) Input coins");
        System.out.println("B) Choose an item.");
        System.out.println("C) Get the chosen item.");
        System.out.println("D) Return change.");
        System.out.println("E) Check you current balance.");
        System.out.println("F) Leave.");

    }

    public static void itemList(Storage storage) {

        int index = 0;

        for (Queue<Item> item : storage.getItems()) {

            System.out.println("For " + item.peek().getName() + " input the number:" + index + ". Price : " + item.peek().getPrice());

            index++;
        }

    }

    public static void coinList() {

        System.out.println("Type in the number of the coin you want to input.");
        System.out.println("For a coin of 0.01 RON, input '0.01'.");
        System.out.println("For a coin of 0.05 RON, input '0.05'.");
        System.out.println("For a coin of 0.10 RON, input '0.10'.");
        System.out.println("For a coin of 0.50 RON, input '0.50'.");
        System.out.println("If you're finished, input '0' to go back to the options menu.");

    }

    public static void userNumberError(){
        System.out.println("Please insert the number as seen on the list.");
    }



    public static Coin choseCoin(double coinValue, CoinStorage coinStorage)  {

        int validCheck = 0;

        for (double key : coinStorage.getCoins().keySet()) {
            if (coinValue == key) {
                validCheck++;
                return coinStorage.getCoins().get(coinValue).peek();
            }
        }
        if (validCheck == 0) {
            throw new NotValidCoinException();
        }
        return null;

    }
}