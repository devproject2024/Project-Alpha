package com.squareup.picasso;

public enum s {
    NO_CACHE(1),
    NO_STORE(2);
    
    final int index;

    static boolean shouldReadFromMemoryCache(int i2) {
        return (i2 & NO_CACHE.index) == 0;
    }

    static boolean shouldWriteToMemoryCache(int i2) {
        return (i2 & NO_STORE.index) == 0;
    }

    private s(int i2) {
        this.index = i2;
    }
}
