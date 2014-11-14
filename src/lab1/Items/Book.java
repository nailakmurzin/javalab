package lab1.Items;

import lab1.Models.AbstractItem;

public class Book extends AbstractItem {

    protected String text;

    public Book(String _name, double _weight, String[] array, String _text) {
        this.init(_name, _weight, array);
        text = _text;
        this.addProperty("плоский");
    }

    public String showText() {
        return text;
    }
}
