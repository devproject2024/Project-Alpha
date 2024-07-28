package com.google.a.a.c;

import com.google.a.a.c.h;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class k extends AbstractMap<String, Object> implements Cloneable {
    Map<String, Object> j;
    public final f k;

    public enum c {
        IGNORE_CASE
    }

    public k() {
        this(EnumSet.noneOf(c.class));
    }

    public k(EnumSet<c> enumSet) {
        this.j = a.a();
        this.k = f.a(getClass(), enumSet.contains(c.IGNORE_CASE));
    }

    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        j a2 = this.k.a(str);
        if (a2 != null) {
            return a2.a((Object) this);
        }
        if (this.k.f7569b) {
            str = str.toLowerCase();
        }
        return this.j.get(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public Object put(String str, Object obj) {
        j a2 = this.k.a(str);
        if (a2 != null) {
            Object a3 = a2.a((Object) this);
            a2.a((Object) this, obj);
            return a3;
        }
        if (this.k.f7569b) {
            str = str.toLowerCase();
        }
        return this.j.put(str, obj);
    }

    public k a(String str, Object obj) {
        j a2 = this.k.a(str);
        if (a2 != null) {
            a2.a((Object) this, obj);
        } else {
            if (this.k.f7569b) {
                str = str.toLowerCase();
            }
            this.j.put(str, obj);
        }
        return this;
    }

    public final void putAll(Map<? extends String, ?> map) {
        for (Map.Entry next : map.entrySet()) {
            a((String) next.getKey(), next.getValue());
        }
    }

    public final Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (this.k.a(str) == null) {
            if (this.k.f7569b) {
                str = str.toLowerCase();
            }
            return this.j.remove(str);
        }
        throw new UnsupportedOperationException();
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return new b();
    }

    /* renamed from: b */
    public k clone() {
        try {
            k kVar = (k) super.clone();
            g.a((Object) this, (Object) kVar);
            kVar.j = (Map) g.c(this.j);
            return kVar;
        } catch (CloneNotSupportedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    final class b extends AbstractSet<Map.Entry<String, Object>> {

        /* renamed from: b  reason: collision with root package name */
        private final h.c f7604b;

        b() {
            this.f7604b = new h(k.this, k.this.k.f7569b).entrySet();
        }

        public final Iterator<Map.Entry<String, Object>> iterator() {
            return new a(this.f7604b);
        }

        public final int size() {
            return k.this.j.size() + this.f7604b.size();
        }

        public final void clear() {
            k.this.j.clear();
            this.f7604b.clear();
        }
    }

    final class a implements Iterator<Map.Entry<String, Object>> {

        /* renamed from: b  reason: collision with root package name */
        private boolean f7600b;

        /* renamed from: c  reason: collision with root package name */
        private final Iterator<Map.Entry<String, Object>> f7601c;

        /* renamed from: d  reason: collision with root package name */
        private final Iterator<Map.Entry<String, Object>> f7602d;

        a(h.c cVar) {
            this.f7601c = cVar.iterator();
            this.f7602d = k.this.j.entrySet().iterator();
        }

        public final boolean hasNext() {
            return this.f7601c.hasNext() || this.f7602d.hasNext();
        }

        public final void remove() {
            if (this.f7600b) {
                this.f7602d.remove();
            }
            this.f7601c.remove();
        }

        public final /* synthetic */ Object next() {
            if (!this.f7600b) {
                if (this.f7601c.hasNext()) {
                    return this.f7601c.next();
                }
                this.f7600b = true;
            }
            return this.f7602d.next();
        }
    }
}
