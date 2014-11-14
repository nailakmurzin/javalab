package lab1.Exceptions;

public class NullAddItemException extends ItemStoreException {

    public NullAddItemException() {
        super("Попытка добавить в хранилище элемент ссылающийся на null!");
    }
}
