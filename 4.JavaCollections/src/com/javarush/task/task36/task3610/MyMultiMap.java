package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (K key : map.keySet()) {
            size += map.get(key).size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        if (!containsKey(key)) {
            map.put(key, new ArrayList<V>(Arrays.asList(value)));
            return null;
        } else {
            List<V> list = map.get(key);
            int size = list.size();
            if (size == repeatCount) {
                list.remove(0);
                size--;
            }
            list.add(value);
            return list.get(size-1);
        }
    }

    @Override
    public V remove(Object key) {
       if (!containsKey(key)) {
           return null;
       } else {
           List<V> list = map.get(key);
           V value = list.remove(0);
           if (list.size() == 0)  map.remove(key);
           return value;
       }
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        Collection<V> allvalues = new ArrayList<>();
        for (K key : map.keySet()) {
            allvalues.addAll(map.get(key));
        }
        return allvalues;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        boolean contains = false;
        for (K key : map.keySet()) {
            if (map.get(key).contains(value)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}