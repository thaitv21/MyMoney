package com.esp.mymoney;

import java.util.ArrayList;
import java.util.List;

public class Dictionary<K, V> {

    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    public void add(K key, V value) {
        keys.add(key);
        values.add(value);
    }

    public void add(K key, V value, int index) {
        keys.add(index, key);
        values.add(index, value);
    }

    public void remove(int index) {
        keys.remove(index);
        values.remove(index);
    }

    public void remove(K key) {
        int index = keys.indexOf(key);
        if (index >= 0) {
            remove(index);
        }
    }

    public List<K> getKeys() {
        return  keys;
    }

    public List<V> getValues() {
        return values;
    }

    public K getKey(int index) {
        return keys.get(index);
    }

    public V getValue(int index) {
        return values.get(index);
    }

    public V getValue(K key) {
        int index = keys.indexOf(key);
        if (index >= 0) {
            return values.get(index);
        }
        return null;
    }

    public int size() {
        return keys.size();
    }
}
