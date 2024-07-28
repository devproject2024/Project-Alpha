package com.google.c;

import java.util.Iterator;
import java.util.Map;

public final class af extends ag {

    /* renamed from: b  reason: collision with root package name */
    private final at f37702b;

    public final at a() {
        return a(this.f37702b);
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final boolean equals(Object obj) {
        return a().equals(obj);
    }

    public final String toString() {
        return a().toString();
    }

    static class a<K> implements Map.Entry<K, Object> {

        /* renamed from: a  reason: collision with root package name */
        Map.Entry<K, af> f37703a;

        /* synthetic */ a(Map.Entry entry, byte b2) {
            this(entry);
        }

        private a(Map.Entry<K, af> entry) {
            this.f37703a = entry;
        }

        public final K getKey() {
            return this.f37703a.getKey();
        }

        public final Object getValue() {
            af value = this.f37703a.getValue();
            if (value == null) {
                return null;
            }
            return value.a();
        }

        public final Object setValue(Object obj) {
            if (obj instanceof at) {
                return this.f37703a.getValue().b((at) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    static class b<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a  reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f37704a;

        public b(Iterator<Map.Entry<K, Object>> it2) {
            this.f37704a = it2;
        }

        public final boolean hasNext() {
            return this.f37704a.hasNext();
        }

        public final void remove() {
            this.f37704a.remove();
        }

        public final /* synthetic */ Object next() {
            Map.Entry next = this.f37704a.next();
            return next.getValue() instanceof af ? new a(next, (byte) 0) : next;
        }
    }
}
