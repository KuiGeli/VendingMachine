package VendingMachine.Exceptions;

public class NotValidCoinException extends RuntimeException {

    public NotValidCoinException() {
        super("Not a valid coin.");
    }
}
