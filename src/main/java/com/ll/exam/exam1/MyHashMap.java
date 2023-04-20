package com.ll.exam.exam1;

import java.util.*;

import static java.util.Objects.hash;

public class MyHashMap<K,V> extends AbstractMap<K,V> implements Map<K,V> {

    private Node<K,V>[] table = new Node[16];

    private Set<Entry<K, V>> entrySet = new HashSet<>();

    static class Node<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldVal = this.value;
            this.value = value;
            return oldVal;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return getKey().equals(node.getKey());
        }

        @Override
        public int hashCode() {
            return hash(getKey());
        }
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }

    @Override
    public V put(K key, V value) {
        int index = indexFor(hash(key.hashCode()));
        Node<K, V> entry = table[index];

        if (entry != null) {
            while (entry.next != null) {
                if (entry.key.equals(key)) { // 이미 있는걸 교체
                    V oldValue = entry.value;
                    entry.value = value;
                    return oldValue;
                }
                entry = entry.next;
            }
        }

        table[index] = new Node<>(key, value, table[index]);
        entrySet.add(table[index]);
        return null;
    }

    @Override
    public V get(Object key) {
        int index = indexFor(hash(key.hashCode()));
        Node<K, V> entry = table[index];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    private int indexFor(int hash) {
        return hash&(table.length-1);
    }
}
