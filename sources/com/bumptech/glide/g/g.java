package com.bumptech.glide.g;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class g<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f6616a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private final long f6617b;

    /* renamed from: c  reason: collision with root package name */
    private long f6618c;

    /* renamed from: d  reason: collision with root package name */
    private long f6619d;

    /* access modifiers changed from: protected */
    public int a(Y y) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void a(T t, Y y) {
    }

    public g(long j) {
        this.f6617b = j;
        this.f6618c = j;
    }

    public final synchronized long b() {
        return this.f6618c;
    }

    public final synchronized Y b(T t) {
        return this.f6616a.get(t);
    }

    public final synchronized Y b(T t, Y y) {
        long a2 = (long) a(y);
        if (a2 >= this.f6618c) {
            a(t, y);
            return null;
        }
        if (y != null) {
            this.f6619d += a2;
        }
        Y put = this.f6616a.put(t, y);
        if (put != null) {
            this.f6619d -= (long) a(put);
            if (!put.equals(y)) {
                a(t, put);
            }
        }
        a(this.f6618c);
        return put;
    }

    public final synchronized Y c(T t) {
        Y remove;
        remove = this.f6616a.remove(t);
        if (remove != null) {
            this.f6619d -= (long) a(remove);
        }
        return remove;
    }

    public final void a() {
        a(0);
    }

    /* access modifiers changed from: protected */
    public final synchronized void a(long j) {
        while (this.f6619d > j) {
            Iterator<Map.Entry<T, Y>> it2 = this.f6616a.entrySet().iterator();
            Map.Entry next = it2.next();
            Object value = next.getValue();
            this.f6619d -= (long) a(value);
            Object key = next.getKey();
            it2.remove();
            a(key, value);
        }
    }
}
