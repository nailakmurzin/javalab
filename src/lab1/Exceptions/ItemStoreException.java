package lab1.Exceptions;

public class ItemStoreException extends Exception {

    private String msg = "";

    public ItemStoreException() {
        msg = "Исключение хранилища! ";
    }

    protected ItemStoreException(String _msg) {
        this();
        msg += _msg;
    }
    
    protected void addMessage(String _msg){
        msg += _msg;
    }

    @Override
    public String toString() {
        return "Ошибка: " + msg;
    }
}
