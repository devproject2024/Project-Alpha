package org.apache.http.c;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class b extends a implements Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f72510a = new ConcurrentHashMap();

    public final d a(String str, Object obj) {
        if (str == null) {
            return this;
        }
        if (obj != null) {
            this.f72510a.put(str, obj);
        } else {
            this.f72510a.remove(str);
        }
        return this;
    }

    public final Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        for (Map.Entry next : this.f72510a.entrySet()) {
            bVar.a((String) next.getKey(), next.getValue());
        }
        return bVar;
    }

    public final String toString() {
        return "[parameters=" + this.f72510a + "]";
    }
}
