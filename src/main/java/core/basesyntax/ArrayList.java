package core.basesyntax;

import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    //private static final int DEFAULT_LOAD_FACTOR = 75;
    private T[] elements;
    private int size;
    private int capacity;
    private int loadFactor;

    public ArrayList(){
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        elements[size++] = value;
    }

    @Override
    public void add(T value, int index) {
        if (index < 0 || index > size) {
            throw new ArrayListIndexOutOfBoundsException(String.format("Index %d is out of bounds for ArrayList with size %d", index, size));
        }
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = value;
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        elements = (T[]) new Object[list.size() + capacity];
        for (int i = 0; i < list.size(); i++) {
            elements[i] = list.get(i);
        }
        size = list.size();
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public void set(T value, int index) {
        elements[index] = value;
    }

    @Override
    public T remove(int index) {
        T removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removedElement;

    }

    @Override
    public T remove(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return remove(i);
            }
        }
        throw new NoSuchElementException("Element " + element
                + " is not found in the ArrayList");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
}
