package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**/

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int)(collection.size()/0.75f) + 1;
        map = new HashMap<>(Math.max(16, capacity));
        Iterator<E> iter = (Iterator<E>) collection.iterator();
        while (iter.hasNext()) {
            map.put(iter.next(), PRESENT);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object clone() throws InternalError {
//        AmigoSet clone;
        try {
            AmigoSet clone = (AmigoSet)super.clone();
            clone.map = (HashMap) map.clone();
            return clone;
        } catch (Exception e) {
            throw new InternalError(e);
        }

    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(E o) {
            return (map.put(o, PRESENT) == null);
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(map.size());
        out.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        for(E e : map.keySet()) out.writeObject(e);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int size = in.readInt();
        int capacity = in.readInt();
        float factory = in.readFloat();
        map = new HashMap<>(capacity,factory);
        for(int i = 0; i < size; i++) map.put((E)in.readObject(), PRESENT);
    }
}
