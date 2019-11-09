package VendingMachine.Storage;

import VendingMachine.Coin.Coin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static VendingMachine.Coin.Coin.*;
import static VendingMachine.Coin.Coin.FIFTY;

public class CoinStorage {

    public CoinStorage(){

        coinBuild();

    }

    private Map<Double, Queue<Coin>> coins = new HashMap<>();

    private Queue<Coin> oneCoins = new LinkedList<>();
    private Queue<Coin> fiveCoins = new LinkedList<>();
    private Queue<Coin> tenCoins = new LinkedList<>();
    private Queue<Coin> fiftyCoins = new LinkedList<>();

    private void coinBuild() {

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

    public void addCoins(Coin coinToAdd){

        coins.get(coinToAdd.getValue()).add(coinToAdd);


    }

    public Map<Double, Queue<Coin>> getCoins() {
        return coins;
    }
}
