package lab1.Models;

import lab1.Models.AbstractItem;
import lab1.Exceptions.*;
import java.util.*;

public abstract class AbstractStorage extends AbstractItem implements Iterable<AbstractItem>, Storage {

    protected boolean captureItem(AbstractItem elem) {
        if (elem.getStorage() == null) {
            elem.setStorage(this);
            return true;
        }
        return false;
    }

    protected void deleteItem(AbstractItem elem) {
        elem.setStorage(null);
    }

    @Override
    public boolean addItem(AbstractItem _elem) throws ItemStoreException {
        if (_elem == this) {
            throw new AddYourselfException();
        }
        if (!this.captureItem(_elem)) {
            throw new ItemAlreadyPlacedException();
        }
        return true;
    }

    @Override
    public AbstractItem findItem(String _name) {
        Iterator<AbstractItem> it = this.iterator();
        while (it.hasNext()) {
            AbstractItem elem = it.next();
            if (elem.getName().equals(_name)) {
                it.remove();
                return elem;
            }
        }
        return null;
    }

}
