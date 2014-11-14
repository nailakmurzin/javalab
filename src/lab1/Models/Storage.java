package lab1.Models;

import lab1.Models.AbstractItem;
import lab1.Exceptions.*;

public interface Storage extends Iterable<AbstractItem> {

    public boolean addItem(AbstractItem _elem) throws ItemStoreException;

    public AbstractItem getItem();

    public AbstractItem findItem(String _name);
}
