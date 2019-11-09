package VendingMachine.Exceptions;

public class NotFullPaidException extends RuntimeException {

    public NotFullPaidException() {
        super("The amount is not enough. Please input more.");
    }
}
