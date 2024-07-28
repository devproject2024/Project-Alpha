package kotlin.a;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.a.a;
import kotlin.g.b.k;

final class x implements Serializable, Map, a {
    public static final x INSTANCE = new x();
    private static final long serialVersionUID = 8246714829545688274L;

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean containsKey(Object obj) {
        return false;
    }

    public final boolean containsValue(Void voidR) {
        k.d(voidR, "value");
        return false;
    }

    public final Void get(Object obj) {
        return null;
    }

    public final int getSize() {
        return 0;
    }

    public final int hashCode() {
        return 0;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Void put(Object obj, Void voidR) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final String toString() {
        return "{}";
    }

    private x() {
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        return containsValue((Void) obj);
    }

    public final Set<Map.Entry> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Object get(Object obj) {
        return get(obj);
    }

    public final Set<Object> keySet() {
        return getKeys();
    }

    public final int size() {
        return getSize();
    }

    public final Collection values() {
        return getValues();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    public final Set<Map.Entry> getEntries() {
        return y.INSTANCE;
    }

    public final Set<Object> getKeys() {
        return y.INSTANCE;
    }

    public final Collection getValues() {
        return w.INSTANCE;
    }

    private final Object readResolve() {
        return INSTANCE;
    }
}
