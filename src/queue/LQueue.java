package src.queue;
public class LQueue<T> implements IQueue<T> {

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    Node<T> frontNode;
    Node<T> rearNode;

    public LQueue() {
        frontNode = null;
        rearNode = null;    
    }

    @Override
    public T add(T element) {
        Node<T> newNode = new Node<>(element);

        if (rearNode == null) {
            rearNode = newNode;
            frontNode = newNode; 
        } else {
            rearNode.next = newNode;
            rearNode = newNode;
        }

        return element;
    }

    @Override
    public T poll() {
        if (frontNode == null) {
            return null;
        }

        T frontElement = frontNode.value;
        frontNode = frontNode.next; 
        return frontElement;
    }

    @Override
    public T peek() {
        if (frontNode == null) {
            return null;
        }

        return frontNode.value;
    }
    
}
