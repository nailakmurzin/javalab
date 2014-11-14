package lab1.storages;

import lab1.Models.*;
import java.util.*;
import lab1.Exceptions.*;

public class Pile extends AbstractStorage implements LimitedStorage {

    private final Stack<AbstractItem> items = new Stack();
    private int maxCount = 0;

    public Pile(String _name, int _maxCount, String[] array) {
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
        }
        return false;
    }

    @Override
    public AbstractItem getItem() {
        return this.items.pop();
    }

    @Override
    public AbstractItem findItem(String _name) {
        Iterator it = this.iterator();
        while (it.hasNext()) {
            AbstractItem elem = (AbstractItem) it.next();
            if (elem.getName().equals(_name)) {
                it.remove();
                return elem;
            }
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return this.items.iterator();
    }

    @Override
    public boolean itFits(AbstractItem _elem) {
        return _elem != null && _elem.peculiar("плоский") && this.items.size() == this.maxCount;
    }

    @Override
    public String getInfo() {
        String s = super.getInfo();
        s += " Максимальное количество: " + this.maxCount;
        s += " Вес собственный : " + super.getWeight();
        s += " Вес всего : " + this.getWeight();
        s += " Всего объектов : " + this.items.size();
        s += " Объекты:" + this.items();
        return s;
    }

}
