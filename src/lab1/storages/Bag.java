package lab1.storages;

import lab1.Models.*;
import java.util.*;
import lab1.Exceptions.*;

public class Bag extends AbstractStorage implements LimitedStorage {

    private final HashSet<AbstractItem> items = new HashSet();
    private double maxWeight = 0;

    protected void setMaxWeight(double _maxWeight) {
        maxWeight = _maxWeight;
    }

    public Bag(String _name, double _maxWeight, double _weight, String... array) {
        maxWeight = _maxWeight;
        this.init(_name, _weight, array);
    }

    @Override
    public boolean addItem(AbstractItem _elem) throws ItemStoreException {
        super.addItem(_elem);

        if (this.itFits(_elem)) {
            this.removeProperty("плоский");
            return this.items.add(_elem);
        } else {
            throw new ExcessWeightException();
        }
    }

    @Override
    public AbstractItem popItem() {
        if (this.items.isEmpty()) {
            return null;
        }
        AbstractItem it = this.items.iterator().next();
        this.items.remove(it);

        this.deleteItem(it);
        return it;
    }

    @Override
    public Iterator iterator() {
        return this.items.iterator();
    }

    @Override
    public boolean itFits(AbstractItem _elem) {
        return (_elem.getWeight() + this.getWeightContent()) <= maxWeight;
    }

    public boolean makeFlat() {
        for (AbstractItem it : this.items) {
            if (!it.peculiar("плоский")) {
                return false;
            }
        }
        this.addProperty("плоский");
        return true;

    }

    @Override
    public String getInfo() {
        String s = super.getInfo();
        s += " Максимальный вес: " + this.maxWeight;
        s += " Всего объектов : " + this.items.size();
        s += " Объекты:" + this.getItemsInfo();
        return s;
    }

}
