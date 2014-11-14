package lab1.storages;

import lab1.Models.*;
import java.util.*;
import lab1.Exceptions.*;

public class Bag extends AbstractStorage implements LimitedStorage {

    private final HashSet<AbstractItem> items = new HashSet();
    private double maxWeight = 0;

    public Bag(String _name, double _maxWeight, String[] array, double _weight) {
        maxWeight = _maxWeight;
        this.init(_name, _weight, array);
    }

    protected void setMaxWeight(double _maxWeight) {
        maxWeight = _maxWeight;
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
    public AbstractItem getItem() {
        if (this.items.isEmpty()) {
            return null;
        }
        AbstractItem it = this.items.iterator().next();
        this.items.remove(it);

        this.deleteItem(it);
        return it;
    }

    @Override
    public AbstractItem findItem(String _name) {
        Iterator it = this.iterator();
        while (it.hasNext()) {
            AbstractItem elem = (AbstractItem) it.next();
            if (elem.getName().equals(_name)) {
                it.remove();
                this.deleteItem(elem);
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
    public double getWeight() {
        return super.getWeight() + this.getWeightContent();
    }

    protected double getWeightContent() {
        double summWeight = 0;
        Iterator<AbstractItem> it = items.iterator();
        while (it.hasNext()) {
            summWeight += it.next().getWeight();
        }
        return summWeight;
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
        s += " Вес собственный : " + super.getWeight();
        s += " Вес всего : " + this.getWeight();
        s += " Всего объектов : " + this.items.size();
        return s;
    }

}
