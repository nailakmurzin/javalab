package lab1.Models;

import lab1.Models.AbstractItem;

public interface LimitedStorage extends Storage {

    public boolean itFits(AbstractItem _elem);
}
