package lab1.Exceptions;

public class ExcessAmountException extends ItemStoreException {

    public ExcessAmountException() {
        super("Привышение высоты!");
    }
}
