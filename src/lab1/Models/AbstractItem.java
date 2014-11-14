package lab1.Models;

import java.util.*;

public abstract class AbstractItem {

    private String name;
    private double weight;
    private Storage storage;
    private final HashSet<String> properties;

    public AbstractItem() {
        this.properties = new HashSet();
        this.name = "";
        this.weight = 0;
    }

    protected void init(String _name, double _weight, String[] array) {
        this.SetName(_name);
        this.setWeight(_weight);
        this.addProperties(array);
    }

    protected void SetName(String _name) {
        this.name = _name;
    }

    protected void setWeight(double _weight) {
        this.weight = _weight;
    }

    protected void addProperty(String _property) {
        this.properties.add(_property);
    }

    protected void addProperties(String... array) {
        for (String s : array) {
            this.addProperty(s);
        }
    }

    protected boolean removeProperty(String _property) {
        return this.properties.remove(_property);
    }

    protected void setStorage(Storage stor) {
        this.storage = stor;
    }

    protected void makeFreeItem() {
        this.storage = null;
    }

    protected Storage getStorage() {
        return this.storage;
    }

    public String getName() {
        return this.name;
    }

    public String getInfo() {
        String info;
        info = " Имя: " + this.getName();
        info += " Вес: " + this.getWeight();
        info += " Находится в хранилище: " + (this.storage != null);
        info += "\nСвойства: ";

        Iterator<String> it = properties.iterator();
        while (it.hasNext()) {
            info += it.next();
            if (it.hasNext()) {
                info += ", ";
            } else {
                info += ".";
            }
        }
        return info;
    }

    public double getWeight() {
        return this.weight;
    }

    public boolean peculiar(String property) {
//        for (String p : this.properties) {
//            if (p.equals(property)) {
//                return true;
//            }
//        }
//        return false;
        return properties.contains(property);
    }

    @Override
    public String toString() {
        return getInfo();
    }

}
