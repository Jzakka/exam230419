package com.ll.exam.exam1;

public class MyArrayList <T>{
    private int sz = 0;

    public boolean add(T element) {
        sz++;
        return true;
    }

    public boolean contains(T element) {
        return false;
    }

    public int size() {
        return sz;
    }

    public int indexOf(T element) {
        return 0;
    }

    public void clear() {
        sz = 0;
    }

    public boolean isEmpty() {
        return sz==0;
    }

    public T get(int idx) {
        return null;
    }

    public T remove(int idx) {
        sz--;
        return null;
    }
}
