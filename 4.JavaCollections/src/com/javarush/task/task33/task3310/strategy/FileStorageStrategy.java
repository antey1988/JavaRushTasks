package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {

    static final int DEFAULT_INITIAL_CAPACITY = 500;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize = 2000;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    @Override
    public boolean containsKey(Long key) {
        for (FileBucket fb : table) {
            if (fb == null) break;
            Entry entry = fb.getEntry();
            if ((entry != null) && (entry.getKey().equals(key))) return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        for (FileBucket fb : table) {
            if (fb == null) break;
            Entry entry = fb.getEntry();
            if ((entry != null) && (entry.getValue().equals(value))) return true;
        }
        return false;
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket fb : table) {
            if (fb == null) break;
            Entry entry = fb.getEntry();
            if ((entry != null) && (entry.getValue().equals(value))) return entry.getKey();
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        for (FileBucket fb : table) {
            if (fb == null) break;
            Entry entry = fb.getEntry();
            if ((entry != null) && (entry.getKey().equals(key))) return entry.getValue();
        }
        return null;
    }

    @Override
    public void put(Long key, String value) {
        FileBucket fbnew = new FileBucket();        
        for (FileBucket fb : table) {
            if (fb == null) break;
            Entry entry = fb.getEntry();
            if ((entry != null) && (entry.getKey().equals(key))) {
                fbnew = fb;
                break;
            }
        }
        Entry e = new Entry(0, key, value, null);        
        fbnew.putEntry(e);
        table[size++] = fbnew;
        if (fbnew.getFileSize() > maxBucketSize) resize(2 * table.length);
    }

    void resize(int newCapacity) {
        FileBucket[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == bucketSizeLimit) {
            return;
        }

        FileBucket[] newTable = new FileBucket[newCapacity];
        int k = 0;
        for (int i = 0; i < oldCapacity; i++) {
            if (oldTable[i].getFileSize() == 0) {
                oldTable[i].remove();
                k++;
            } else {
                newTable[i-k] = oldTable[i];
            }
        }
        table = newTable;
    }

    public long getMaxBucketSize() {
        return maxBucketSize;
    }

    public void setMaxBucketSize(long maxBucketSize) {
        this.maxBucketSize = maxBucketSize;
    }

    private boolean tabletClear() {
        return table[0] == null;
    }
}
