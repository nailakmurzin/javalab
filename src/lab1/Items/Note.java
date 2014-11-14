package lab1.Items;

public class Note extends Book {

    public Note(String _name, double _weight, String... array) {
        super(_name, _weight, "", array);
    }

    public void addText(String _text) {
        this.text += "\n" + _text;
    }

}
