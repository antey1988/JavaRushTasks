package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;
import sun.awt.GlobalCursorManager;

public class CachingProxyRetriever implements Retriever {
    private OriginalRetriever originalRetriever;
    private LRUCache<Long, Object> lruCache = new LRUCache<>(15);

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object obj = lruCache.find(id);
        if (obj != null) {
            System.out.println("Getting a value for id #" + id + " from Cache...");
            return obj;
        }
        else {
            obj = originalRetriever.retrieve(id);
            if (obj != null) lruCache.set(id, obj);
            return obj;
        }
    }
}
