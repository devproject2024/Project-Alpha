package org.greenrobot.greendao.internal;

import java.util.Arrays;
import org.greenrobot.greendao.DaoLog;

public final class LongHashMap<T> {
    private int capacity;
    private int size;
    private Entry<T>[] table;
    private int threshold;

    static final class Entry<T> {
        final long key;
        Entry<T> next;
        T value;

        Entry(long j, T t, Entry<T> entry) {
            this.key = j;
            this.value = t;
            this.next = entry;
        }
    }

    public LongHashMap() {
        this(16);
    }

    public LongHashMap(int i2) {
        this.capacity = i2;
        this.threshold = (i2 * 4) / 3;
        this.table = new Entry[i2];
    }

    public final boolean containsKey(long j) {
        for (Entry<T> entry = this.table[((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.capacity]; entry != null; entry = entry.next) {
            if (entry.key == j) {
                return true;
            }
        }
        return false;
    }

    public final T get(long j) {
        for (Entry<T> entry = this.table[((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.capacity]; entry != null; entry = entry.next) {
            if (entry.key == j) {
                return entry.value;
            }
        }
        return null;
    }

    public final T put(long j, T t) {
        int i2 = ((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.capacity;
        Entry<T> entry = this.table[i2];
        for (Entry<T> entry2 = entry; entry2 != null; entry2 = entry2.next) {
            if (entry2.key == j) {
                T t2 = entry2.value;
                entry2.value = t;
                return t2;
            }
        }
        this.table[i2] = new Entry<>(j, t, entry);
        this.size++;
        if (this.size <= this.threshold) {
            return null;
        }
        setCapacity(this.capacity * 2);
        return null;
    }

    public final T remove(long j) {
        int i2 = ((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.capacity;
        Entry<T> entry = this.table[i2];
        Entry<T> entry2 = null;
        while (entry != null) {
            Entry<T> entry3 = entry.next;
            if (entry.key == j) {
                if (entry2 == null) {
                    this.table[i2] = entry3;
                } else {
                    entry2.next = entry3;
                }
                this.size--;
                return entry.value;
            }
            entry2 = entry;
            entry = entry3;
        }
        return null;
    }

    public final void clear() {
        this.size = 0;
        Arrays.fill(this.table, (Object) null);
    }

    public final int size() {
        return this.size;
    }

    public final void setCapacity(int i2) {
        Entry<T>[] entryArr = new Entry[i2];
        for (Entry<T> entry : this.table) {
            while (entry != null) {
                long j = entry.key;
                int i3 = ((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % i2;
                Entry<T> entry2 = entry.next;
                entry.next = entryArr[i3];
                entryArr[i3] = entry;
                entry = entry2;
            }
        }
        this.table = entryArr;
        this.capacity = i2;
        this.threshold = (i2 * 4) / 3;
    }

    public final void reserveRoom(int i2) {
        setCapacity((i2 * 5) / 3);
    }

    public final void logStats() {
        int i2 = 0;
        for (Entry<T> entry : this.table) {
            while (entry != null && entry.next != null) {
                i2++;
                entry = entry.next;
            }
        }
        DaoLog.d("load: " + (((float) this.size) / ((float) this.capacity)) + ", size: " + this.size + ", capa: " + this.capacity + ", collisions: " + i2 + ", collision ratio: " + (((float) i2) / ((float) this.size)));
    }
}
