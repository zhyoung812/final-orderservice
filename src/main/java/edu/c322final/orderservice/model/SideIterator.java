package edu.c322final.orderservice.model;

import java.util.Iterator;
import java.util.List;

public class SideIterator implements Iterator {
    int index;
    List<Side> sides;
    public SideIterator(List<Side> sides) {
        this.index = 0;
        this.sides = sides;
    }
    public boolean hasNext() {
        return index < sides.size();
    }
    public Side next() {
        if (hasNext()) {
            index+=1;
            return sides.get(index-1);
        }
        return null;
    }
}
