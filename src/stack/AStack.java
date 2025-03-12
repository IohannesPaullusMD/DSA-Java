package src.stack;

import java.util.EmptyStackException;

@SuppressWarnings("unchecked")
public class AStack<T> implements IStack<T> {
    private T[] arr;
    private int count;

    public AStack(int maxCap) {
        arr = (T[]) new Object[maxCap];
        count = 0; 
    }

    public T push(T element) {
        if (count == arr.length) {
            throw new RuntimeException("Array is full");
        }

        return arr[count++] = element;
    }

    public T peek() {
        if (count == 0) {
            throw new EmptyStackException();
        }

        return arr[count-1];
    }

    public T pop() {
        if (count == 0) {
            throw new EmptyStackException();
        }

        return arr[--count];
    }
}
