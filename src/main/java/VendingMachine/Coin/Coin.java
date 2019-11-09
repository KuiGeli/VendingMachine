package VendingMachine.Coin;

public enum Coin {

    ONE(0.01),
    FIVE(0.05),
    TEN(0.1),
    FIFTY(0.5);

    double value;

    Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
