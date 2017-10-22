package pl.sda.wwa5.lab11.queue;

public interface LifoInterface<T> {

    public void push (T o);

    public T pop();

    public int size();

    public boolean contains(T o);
}
