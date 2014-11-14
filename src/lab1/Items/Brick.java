package lab1.Items;

import lab1.Models.AbstractItem;
import lab1.*;

public class Brick extends AbstractItem {

    public Brick(String _name, double _weight, String... array) {
        this.init(_name, _weight, array);
        this.addProperty("крепкий");
    }
}
