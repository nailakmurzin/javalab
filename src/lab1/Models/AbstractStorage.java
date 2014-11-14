package lab1.Models;

import lab1.Exceptions.*;
import java.util.*;

public abstract class AbstractStorage extends AbstractItem implements Iterable<AbstractItem>, Storage {

    protected double getWeightContent() {
        double summWeight = 0;
        Iterator<AbstractItem> it = this.iterator();
        while (it.hasNext()) {
            summWeight += it.next().getWeight();
        }
        return summWeight;
    }

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

    protected String getItemsInfo() {
        String text = "{ ";
        Iterator<AbstractItem> it = this.iterator();
        while (it.hasNext()) {
            AbstractItem elem = it.next();
            text += elem.getName() + "[" + elem.getWeight() + "]" + " ";
        }
        return text + "}";
    }

    @Override
    public boolean addItem(AbstractItem _elem) throws ItemStoreException {
        if (_elem == null) {
            throw new NullAddItemException();
        }
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

    @Override
    public double getWeight() {
        return super.getWeight() + this.getWeightContent();
    }

}
