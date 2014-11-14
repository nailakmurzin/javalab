package lab1.Exceptions;

public class AddYourselfException extends ItemStoreException {

    public AddYourselfException() {
        super("Попытка добавления хранилища самого в себя!");
    }
}
