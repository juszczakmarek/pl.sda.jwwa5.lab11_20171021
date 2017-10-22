package pl.sda.wwa5.lab11.queue;

import java.util.ArrayList;
import java.util.LinkedList;

public class Lifo {

    //private ArrayList<Object> arrayList = new ArrayList<>();
    private LinkedList<Object> linkedList = new LinkedList<>();

    public void push (Object o) {
        linkedList.push(o);
    }

    public Object pop() {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException();
        }
        return linkedList.pop();
    }

    public int size() {
        return linkedList.size();
    }

    public boolean contains(Object o) {
        return linkedList.contains(o);
    }

}
