package lab1.storages;

import lab1.Models.AbstractItem;
import lab1.Exceptions.*;

public class Box extends Bag {

    private boolean enable;

    public Box(String _name, double _maxWeight, double _weight, String... array) {
        super(_name, _maxWeight, _weight, array);
        enable = true;
        this.addProperty("плоский");
        this.addProperty("квадратный");
    }

    public boolean isOpen() {
        return this.enable;
    }

    public void close() {
        this.enable = false;
    }

    public void open() {
        this.enable = true;
    }

    @Override
    public boolean addItem(AbstractItem _elem) throws ItemStoreException {
        if (enable) {
            super.addItem(_elem);
        }
        return false;
    }

}
