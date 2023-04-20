package com.ll.exam.exam1;

import java.util.*;
import java.util.function.Predicate;

public class MyArrayList <T> extends AbstractList<T> implements List<T> {
    private int sz = 0;

    Object[] container;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int length) {
        container = new Object[length];
    }

    @Override
    public boolean add(T t) {
        if (sz == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[sz++] = t;
        return true;
    }

    @Override
    public T get(int index) {
        if (index >= sz) {
            throw new IndexOutOfBoundsException();
        }
        return (T) container[index];
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public void clear() {
        sz = 0;
    }

    @Override
    public T remove(int index) {
        T removed = get(index);
        for (int i = index; i+1 < sz; i++) {
            container[i] = container[i + 1];
        }
        sz--;
        return removed;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        //TODO
        int filteredContainerSize = 0;
        Object[] filteredContainer = new Object[container.length];
        for (int i = 0; i < sz; i++) {
            if (!filter.test((T)container[i])) {
                filteredContainer[filteredContainerSize++] = container[i];
            }
        }
        container = filteredContainer;
        sz = filteredContainerSize;
        return container.length != filteredContainerSize;
    }
}
