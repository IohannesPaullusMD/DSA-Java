package src.stack;

import java.util.EmptyStackException;

public class LStack<T> implements IStack<T> {
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> topNode;
    
    public LStack() {
        topNode = null;
    }

    @Override
    public T push(T element) {
        Node<T> newNode = new Node<>(element);

        if (topNode == null) {
            topNode = newNode;
        } else {
            newNode.next = topNode;
            topNode = newNode;
        }

        return element;
    }

    @Override
    public T peek() {
        if (topNode == null) {
            throw new EmptyStackException();
        }

        return topNode.value;
    }

    @Override
    public T pop() {
        if (topNode == null) {
            throw new EmptyStackException();
        }
        
        T topElement = topNode.value;
        topNode = topNode.next;
        return topElement;
    }
    
}
