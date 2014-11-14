package lab1.Exceptions;

public class AddNotPerticulareItemException extends ItemStoreException {

    public AddNotPerticulareItemException() {
        super("Добавляемый объект не является свойственным для данной коллекции!");
    }

    public AddNotPerticulareItemException(lab1.Models.AbstractItem _elem) {
        this.addMessage("Имя объекта"+_elem.getName());
    }
}
