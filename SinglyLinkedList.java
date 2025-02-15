import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public SinglyLinkedList() {
        firstNode = lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T add(T element) {
        return add(element, true);
    }

    public T add(T element, boolean isAddLast) {
        Node<T> newNode = new Node<>(element);

        if (lastNode == null) {
            firstNode = lastNode = newNode;
        } else if (isAddLast) {
            lastNode.next = newNode;
            lastNode = newNode;
        } else {
            newNode.next = firstNode;
            firstNode = newNode;
        }

        ++size;

        return element;
    }

    /**
     * the caller of this method
     * should first make sure that
     * position isn't out of bounds.
     */
    private Node<T> getNodeAt(int position) {
        Node<T> currNode = firstNode;
        
        for (int i = 0; i < position; ++i) {
            currNode = currNode.next;
        }

        return currNode;
    }

    public T insert(T element, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException(position);
        }
        
        if (position == 0 || position == size) {
            return add(element, position == size);
        }

        Node<T> newNode = new Node<>(element);
        Node<T> currNode = getNodeAt(position - 1);

        newNode.next = currNode.next;
        currNode.next = newNode;
        ++size;

        return element;
    }

    public T get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(position);
        }

        return getNodeAt(position).value;
    }

    public T replace(T element, int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(position);
        }

        return getNodeAt(position).value = element;
    }

    public T remove(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(position);
        }

        if (position == 0 || position == (size-1)) {
            return remove(position == 0);
        }

        Node<T> prevNode = getNodeAt(position - 1);
        T x = prevNode.next.value;

        prevNode.next = prevNode.next.next;
        --size;

        return x;
    }

    public T remove(boolean isRemoveFirst) {
        if (size < 1) {
            throw new NoSuchElementException();
        }

        Node<T> nodeToRemove = firstNode;

        if (size == 1) {
            firstNode = lastNode = null;
        } else if (isRemoveFirst) {
            nodeToRemove = firstNode;
            firstNode = firstNode.next;
        } else {
            nodeToRemove = lastNode;
            lastNode = getNodeAt(size-1);
        }
        
        --size;

        return nodeToRemove.value;
    }
}
