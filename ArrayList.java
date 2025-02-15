
@SuppressWarnings("unchecked")
public class ArrayList<T> {
    private static final int DEFAULT_INITIAL_CAPACITY = 8;

    private T[] arr;
    private int size;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int inititalCapacity) {
        if (inititalCapacity != DEFAULT_INITIAL_CAPACITY) {
            // make the initial capacity be a power 2
            int x = 1;
            while (x < inititalCapacity) {
                x = x << 1;
            }
            inititalCapacity = x;
        }

        arr = (T[]) new Object[inititalCapacity];
        size = 0;
    }

    private void resize() {
        T[] newArr = (T[]) new Object[size << 1];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    public int size() {
        return size;
    }

    public T add(T element) {
        return insert(element, size); 
    }

    public T insert(T element, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException(position);
        }

        if (size == arr.length) {
            resize();
        }

        for (int i = size; i > position; --i) {
            arr[i] = arr[i-1];
        }

        ++size;

        return arr[position] = element;
    }

    public T get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(position);
        }

        return arr[position];
    }

    public T replace(T element, int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(position);
        }

        return arr[position] = element;
    }

    public T remove(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(position);
        }
        
        T x = arr[position];
        --size;
        
        for (int i = position + 1; i < size; ++i) {
            arr[i-1] = arr[i];
        }

        return x;
    }
}
