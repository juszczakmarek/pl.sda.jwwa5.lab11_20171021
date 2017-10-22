package pl.sda.wwa5.lab11.queue;

import java.util.List;

public abstract class Lifo<T> implements LifoInterface<T> {

    protected List<T> list;

    @Override
    public void push (T o) {
        list.add(o);
    }

    @Override
    public T pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException();
        }
        return list.remove(list.size()-1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean contains(T o) {
        return list.contains(o);
    }

}
