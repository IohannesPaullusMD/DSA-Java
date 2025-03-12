package src.queue;

@SuppressWarnings("unchecked")
public class AQueue<T> implements IQueue<T> {

    private T[] arr;
    private int count;

    public AQueue(int maxCap) {
        arr = (T[]) new Object[maxCap];
        count = 0;
    }

    @Override
    public T add(T element) {
        if (count == arr.length) {
            throw new IllegalStateException("Queue is full");
        }

        return arr[count++] = element;
    }

    @Override
    public T peek() {
        if (count == 0) {
            return null;
        }

        return arr[0]; 
    }

    @Override
    public T poll() {
        if (count == 0) {
            return null;
        }
        T qVal = arr[0];
        System.arraycopy(arr, 1, arr, 0, --count);
        return qVal;
    }


    
    
}
