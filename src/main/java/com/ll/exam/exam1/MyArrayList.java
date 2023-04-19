package com.ll.exam.exam1;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MyArrayList <T> extends AbstractList<T> implements List<T> {
    private int sz = 0;

    Object[] container = new Object[10];

    @Override
    public boolean add(T t) {
        container[sz++] = t;
        return true;
    }

    @Override
    public T get(int index) {
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
        sz--;
        return (T) container[index];
    }
}
