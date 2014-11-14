package lab1.Exceptions;

public class ExcessWeightException extends ItemStoreException {

    public ExcessWeightException() {
        super("Привышение веса!");
    }
}
