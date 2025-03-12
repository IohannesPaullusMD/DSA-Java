package src.queue;

public interface IQueue<T> {
    public T add(T element);
    public T poll();
    public T peek();
}
