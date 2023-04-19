package com.ll.exam.exam1;

import java.util.*;

public class MyArrayList <T> extends AbstractList<T> implements List<T> {
    private int sz = 0;

    Object[] container = new Object[10];

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
}
