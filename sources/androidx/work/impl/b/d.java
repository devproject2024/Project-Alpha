package androidx.work.impl.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public String f5154a;

    /* renamed from: b  reason: collision with root package name */
    public Long f5155b;

    public d(String str) {
        this(str, 0);
    }

    public d(String str, long j) {
        this.f5154a = str;
        this.f5155b = Long.valueOf(j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f5154a.equals(dVar.f5154a)) {
            return false;
        }
        Long l = this.f5155b;
        Long l2 = dVar.f5155b;
        if (l != null) {
            return l.equals(l2);
        }
        return l2 == null;
    }

    public final int hashCode() {
        int hashCode = this.f5154a.hashCode() * 31;
        Long l = this.f5155b;
        return hashCode + (l != null ? l.hashCode() : 0);
    }
}
