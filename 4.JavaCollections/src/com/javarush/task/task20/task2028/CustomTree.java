package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    List<Entry<String>> elements = new ArrayList<>();
    int count;

    public CustomTree() {
        this.root = new Entry<>("zeroElement");
        //this.elements.add(root);
    }

    @Override
    public boolean add(String s) {
        Entry<String> childElement = new Entry<>(s);
        List<Entry<String>> elements = new ArrayList<>();
        elements.add(root);
        Entry<String> parentElement = FreeChild(elements);
        if (parentElement.availableToAddLeftChildren) {
            parentElement.availableToAddLeftChildren = false;
            parentElement.leftChild = childElement;
        } else {
            parentElement.availableToAddRightChildren = false;
            parentElement.rightChild = childElement;
        }
        childElement.parent = parentElement;
        this.elements.add(childElement);
        return true;
    }

    static public Entry<String> FreeChild(List<Entry<String>> elements) {
        List<Entry<String>> childs = new ArrayList<>();
        for (Entry<String> curEntry : elements) {
            if (!curEntry.isAvailableToAddChildren()) {
                childs.add(curEntry.leftChild);
                childs.add(curEntry.rightChild);
            } else return curEntry;
        }
        return FreeChild(childs);
    }

    public String getParent(String s) {
        return (FindEntryForName(s) != null) ? FindEntryForName(s).parent.elementName : null;
    }

    public Entry<String> FindEntryForName(String s) {
        for (Entry<String> curEntry : elements) {
            if (curEntry.elementName.equals(s)) return curEntry;
        }
        return null;
    }

    @Override
    public String get(int index) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return elements.size();
    }

    public String set(int index, String element) {
        throw  new UnsupportedOperationException();
    }

    public void add(int index, String element) {
        throw  new UnsupportedOperationException();
    }

    public boolean remove(Object s) {
        if (!(s instanceof String)) throw  new UnsupportedOperationException();
        Entry<String> curEntry  = FindEntryForName((String)s);
        if (curEntry == null) return false;
        else {
            if (curEntry.parent.leftChild == curEntry) curEntry.parent.availableToAddLeftChildren = true;
            else curEntry.parent.availableToAddRightChildren = true;
            Queue<Entry<String>> queue = new ArrayDeque<>();
            queue.add(curEntry);
            while (!queue.isEmpty()) {
                Entry<String> entry = queue.poll();
                elements.remove(entry);
                if (!entry.availableToAddLeftChildren) queue.add(entry.leftChild);
                if (!entry.availableToAddRightChildren) queue.add(entry.rightChild);
            }
        }
        return  true;
    }

    public String remove(int index) {
        throw  new UnsupportedOperationException();
    }

    public List<String> subList(int fromIndex, int toIndex) {
        throw  new UnsupportedOperationException();
    }
    
    protected void removeRange(int fromIndex, int toIndex) {
        throw  new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c) {
        throw  new UnsupportedOperationException();
    }

    static class Entry<T> implements  Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
