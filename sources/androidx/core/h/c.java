package androidx.core.h;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3082a;

    c(Object obj) {
        this.f3082a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        Object obj2 = this.f3082a;
        if (obj2 == null) {
            return cVar.f3082a == null;
        }
        return obj2.equals(cVar.f3082a);
    }

    public final int hashCode() {
        Object obj = this.f3082a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f3082a + "}";
    }
}
