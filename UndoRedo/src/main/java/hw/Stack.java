package hw;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

/******************************************************************************
 * Stack<E> provides a generic stack implementation.
 * It is a LIFO (Last-In-First-Out) data structure.
 ******************************************************************************/
public class Stack<E> {
    private E[] data;
    private int size;

    public Stack() {
        final int INITIAL_CAPACITY = 10;
        size = 0;
        data = (E[]) Array.newInstance(Object.class, INITIAL_CAPACITY);
    }

    public Stack(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException
                    ("Initial Capacity " + initialCapacity + " is negative");
        size = 0;
        data = (E[]) Array.newInstance(Object.class, initialCapacity);
    }
    public void clear() {
        size = 0;
    }

    public void ensureCapacity(int minimumCapacity) {
        E[] biggerArray;

        if (data.length < minimumCapacity) {
            biggerArray = (E[]) Array.newInstance(Object.class, minimumCapacity);;
            System.arraycopy(data, 0, biggerArray, 0, size);
            data = biggerArray;
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    // Return the top item from the stack (end of the array)
    public E peek() {
        if (size == 0)
            throw new EmptyStackException();
        return data[size - 1];
    }

    // Remove the top item from the stack (end of the array)
    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        return data[--size];
    }

    // Add an item to the top of the stack (end of the array)
    public void push(E item) {
        if (size == data.length) {
            ensureCapacity(size * 2 + 1);
        }
        data[size] = item;
        size++;
    }

    public int size() {
        return size;
    }

    // Return a string representation of the stack
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            sb.append(data[i] + " -> ");
        }
        if (size > 0) {
            sb.delete(sb.length() - 4, sb.length());
        }
        return sb.toString();
    }
}
