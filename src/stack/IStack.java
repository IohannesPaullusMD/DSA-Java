package src.stack;

public interface IStack<T> {
    public T push(T element);
    public T peek();
    public T pop();
}
