package com.squareup.picasso;

public enum t {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    
    final int index;

    public static boolean shouldReadFromDiskCache(int i2) {
        return (i2 & NO_CACHE.index) == 0;
    }

    public static boolean shouldWriteToDiskCache(int i2) {
        return (i2 & NO_STORE.index) == 0;
    }

    public static boolean isOfflineOnly(int i2) {
        return (i2 & OFFLINE.index) != 0;
    }

    private t(int i2) {
        this.index = i2;
    }
}
