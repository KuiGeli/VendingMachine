package VendingMachine;

import VendingMachine.Impl.VendingMachineImpl;
import VendingMachine.Storage.Storage;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        VendingMachineImpl vendingMachine = new VendingMachineImpl();




        Scanner userInput = new Scanner(System.in);

        vendingMachine.selectItem(1);

        System.out.println("Please input money.");

//        Utils.coinList();
//
//
//
//
//        Utils.options();

    }

}
