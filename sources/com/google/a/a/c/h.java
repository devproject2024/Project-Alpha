package com.google.a.a.c;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

final class h extends AbstractMap<String, Object> {

    /* renamed from: a  reason: collision with root package name */
    final Object f7582a;

    /* renamed from: b  reason: collision with root package name */
    final f f7583b;

    public final /* synthetic */ Object put(Object obj, Object obj2) {
        String str = (String) obj;
        j a2 = this.f7583b.a(str);
        com.google.a.a.b.a.a.a.a.c.a(a2, (Object) "no field of key ".concat(String.valueOf(str)));
        Object a3 = a2.a(this.f7582a);
        a2.a(this.f7582a, com.google.a.a.b.a.a.a.a.c.a(obj2));
        return a3;
    }

    h(Object obj, boolean z) {
        this.f7582a = obj;
        this.f7583b = f.a(obj.getClass(), z);
        com.google.a.a.b.a.a.a.a.c.a(!this.f7583b.f7568a.isEnum());
    }

    /* renamed from: a */
    public final c entrySet() {
        return new c();
    }

    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public final Object get(Object obj) {
        j a2;
        if ((obj instanceof String) && (a2 = this.f7583b.a((String) obj)) != null) {
            return a2.a(this.f7582a);
        }
        return null;
    }

    final class c extends AbstractSet<Map.Entry<String, Object>> {
        c() {
        }

        /* renamed from: a */
        public final b iterator() {
            return new b();
        }

        public final int size() {
            int i2 = 0;
            for (String a2 : h.this.f7583b.f7570c) {
                if (h.this.f7583b.a(a2).a(h.this.f7582a) != null) {
                    i2++;
                }
            }
            return i2;
        }

        public final void clear() {
            for (String a2 : h.this.f7583b.f7570c) {
                h.this.f7583b.a(a2).a(h.this.f7582a, (Object) null);
            }
        }

        public final boolean isEmpty() {
            for (String a2 : h.this.f7583b.f7570c) {
                if (h.this.f7583b.a(a2).a(h.this.f7582a) != null) {
                    return false;
                }
            }
            return true;
        }
    }

    final class b implements Iterator<Map.Entry<String, Object>> {

        /* renamed from: b  reason: collision with root package name */
        private int f7588b = -1;

        /* renamed from: c  reason: collision with root package name */
        private j f7589c;

        /* renamed from: d  reason: collision with root package name */
        private Object f7590d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f7591e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f7592f;

        /* renamed from: g  reason: collision with root package name */
        private j f7593g;

        b() {
        }

        public final boolean hasNext() {
            if (!this.f7592f) {
                this.f7592f = true;
                this.f7590d = null;
                while (this.f7590d == null) {
                    int i2 = this.f7588b + 1;
                    this.f7588b = i2;
                    if (i2 >= h.this.f7583b.f7570c.size()) {
                        break;
                    }
                    this.f7589c = h.this.f7583b.a(h.this.f7583b.f7570c.get(this.f7588b));
                    this.f7590d = this.f7589c.a(h.this.f7582a);
                }
            }
            if (this.f7590d != null) {
                return true;
            }
            return false;
        }

        public final void remove() {
            if (this.f7593g != null && !this.f7591e) {
                this.f7591e = true;
                this.f7593g.a(h.this.f7582a, (Object) null);
                return;
            }
            throw new IllegalStateException();
        }

        public final /* synthetic */ Object next() {
            if (hasNext()) {
                this.f7593g = this.f7589c;
                Object obj = this.f7590d;
                this.f7592f = false;
                this.f7591e = false;
                this.f7589c = null;
                this.f7590d = null;
                return new a(this.f7593g, obj);
            }
            throw new NoSuchElementException();
        }
    }

    final class a implements Map.Entry<String, Object> {

        /* renamed from: b  reason: collision with root package name */
        private Object f7585b;

        /* renamed from: c  reason: collision with root package name */
        private final j f7586c;

        a(j jVar, Object obj) {
            this.f7586c = jVar;
            this.f7585b = com.google.a.a.b.a.a.a.a.c.a(obj);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String getKey() {
            String str = this.f7586c.f7598c;
            return h.this.f7583b.f7569b ? str.toLowerCase() : str;
        }

        public final Object getValue() {
            return this.f7585b;
        }

        public final Object setValue(Object obj) {
            Object obj2 = this.f7585b;
            this.f7585b = com.google.a.a.b.a.a.a.a.c.a(obj);
            this.f7586c.a(h.this.f7582a, obj);
            return obj2;
        }

        public final int hashCode() {
            return getKey().hashCode() ^ getValue().hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return getKey().equals(entry.getKey()) && getValue().equals(entry.getValue());
        }
    }
}
