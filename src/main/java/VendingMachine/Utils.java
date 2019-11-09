package VendingMachine;

import VendingMachine.Item.Item;
import VendingMachine.Storage.Storage;

import java.util.Queue;

public class Utils {

    public static void options(){

        System.out.println("Input the character of the option you want to choose.");
        System.out.println("A) Choose an item.");
        System.out.println("B) Return change.");
        System.out.println("C) Leave.");

    }

    public static void itemList(Storage storage){

        int index = 0;

        for (Queue<Item> item : storage.getItems()){

            System.out.println("For " + item.peek().getName() + " input the number:" + index );

            index++;
        }

    }

    public static void coinList(){

        System.out.println("Type in the number of the coin you want to input.");
        System.out.println("For a coin of 0.01 RON, input '1'");
        System.out.println("For a coin of 0.05 RON, input '5'");
        System.out.println("For a coin of 0.10 RON, input '10'");
        System.out.println("For a coin of 0.50 RON, input '50'");

    }



}
