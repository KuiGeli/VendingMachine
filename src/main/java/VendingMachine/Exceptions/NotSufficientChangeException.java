package VendingMachine.Exceptions;

public class NotSufficientChangeException extends RuntimeException {
    public NotSufficientChangeException() {
        super("There is not enough change in the machine.");
    }
}
