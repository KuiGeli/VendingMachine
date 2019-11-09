package VendingMachine.Exceptions;

public class SoldOutException extends RuntimeException {
    public SoldOutException(){
        super("The item you are looking for is sold out.");
    }

}
