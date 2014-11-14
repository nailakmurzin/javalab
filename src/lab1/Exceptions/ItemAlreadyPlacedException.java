package lab1.Exceptions;

public class ItemAlreadyPlacedException extends ItemStoreException {

    public ItemAlreadyPlacedException() {
        super("Попытка поместить объект в хранилище которое одновременно находится в другом хранилище!");
    }
}
