package VendingMachine;

import VendingMachine.Exceptions.NotValidCoinException;
import VendingMachine.Exceptions.SoldOutException;
import VendingMachine.Impl.VendingMachineImpl;
import VendingMachine.Item.Item;
import VendingMachine.Storage.Storage;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        VendingMachineImpl vendingMachine = new VendingMachineImpl();
        Scanner userInput = new Scanner(System.in);
        Queue<Item> items = new LinkedList<>();
        boolean isRunning = true;


        while (isRunning) {

            Utils.options();

            char optionChosen = userInput.next().charAt(0);

            switch (optionChosen) {
                case 'A':
                    boolean aIsRunning = true;

                    while (aIsRunning) {

                        Utils.coinList();

                        while (!userInput.hasNextDouble()) {
                            Utils.userNumberError();
                            userInput.next();
                        }

                        double coinChosen = userInput.nextDouble();
                        if (coinChosen > 0) {
                            try {
                                vendingMachine.insertMoney(Utils.choseCoin(coinChosen, vendingMachine.getCoinStorage()));
                            } catch (NotValidCoinException e) {
                                Utils.userNumberError();
                            }
                        } else {
                            aIsRunning = false;
                        }

                    }
                    break;
                case 'B':

                    Utils.itemList(vendingMachine.getStorage());
                    while (!userInput.hasNextInt()) {
                        Utils.userNumberError();
                        userInput.next();
                    }

                    int itemNumber = userInput.nextInt();

                    while (itemNumber < 0 || itemNumber > vendingMachine.getStorage().getItems().size() - 1) {
                        Utils.userNumberError();
                        Utils.itemList(vendingMachine.getStorage());
                        itemNumber = userInput.nextInt();
                    }

                    try {
                        items = vendingMachine.selectItem(itemNumber);
                    } catch (SoldOutException e) {
                        System.out.println("The item has been sold out.");
                    }
                    break;
                case 'C':
                    if (vendingMachine.isMoneyEnough(items.peek())) {

                        vendingMachine.returnItem(items);

                    }else {
                        System.out.println("You don't have enough money. Please input more.");
                    }
                    break;
                case 'D':
                    vendingMachine.getChange();
                    break;
                case 'E':
                    System.out.println("You've got " + vendingMachine.getUserMoney() + "RON left.");
                    break;
                case 'F':
                    isRunning = false;
                    break;
                default:
                    System.out.println("Please input a character from the menu. UpperCase, no numbers.");
                    break;

            }

        }


    }

}
