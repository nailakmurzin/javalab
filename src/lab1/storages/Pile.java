package lab1.storages;

import lab1.Models.*;
import java.util.*;
import lab1.Exceptions.*;

public class Pile extends AbstractStorage implements LimitedStorage {

    private final Stack<AbstractItem> items = new Stack();
    private int maxCount = 0;

    public Pile(String _name, int _maxCount, String... array) {
        this.init(_name, 0, array);
        this.setMaxCount(_maxCount);
        this.addProperty("плоский");
    }

    private void setMaxCount(int _maxCount) {
        this.maxCount = _maxCount;
    }

    @Override
    public boolean addItem(AbstractItem _elem) throws ItemStoreException {
        super.addItem(_elem);
        if (this.items.size() == this.maxCount) {
            throw new ExcessAmountException();
        }
        if (this.itFits(_elem)) {
            return (this.items.push(_elem) != null);
        } else {
            throw new AddNotPerticulareItemException(_elem);
        }
    }

    @Override
    public AbstractItem popItem() {
        if (this.items.isEmpty()) {
            return null;
        }
        AbstractItem it = this.items.pop();
        this.deleteItem(it);
        return it;
    }

    @Override
    public Iterator iterator() {
        return this.items.iterator();
    }

    @Override
    public boolean itFits(AbstractItem _elem) {
        return _elem != null && _elem.peculiar("плоский");
    }

    @Override
    public String getInfo() {
        String s = super.getInfo();
        s += " Максимальное количество: " + this.maxCount;
        s += " Всего объектов : " + this.items.size();
        s += " Объекты:" + this.getItemsInfo();
        return s;
    }

}
